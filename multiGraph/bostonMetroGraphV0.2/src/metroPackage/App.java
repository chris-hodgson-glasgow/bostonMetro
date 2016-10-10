package metroPackage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		try {
			MetroMapParser parser = new MetroMapParser("bostonmetro.txt");
			parser.generateGraphFromFile();

			Metro metro = parser.getGraph();
			Map<Integer, INode> nodes = metro.getStationList();
			ArrayList<IEdge> edges = metro.getTrackList();

			Scanner scanner = new Scanner(System.in);
			INode src = validate(nodes, edges, "What is the Station you are starting at?", scanner);
			INode dest = validate(nodes, edges, "Which Station would you like to go to?", scanner);
			scanner.close();

			if(metro.getPath(src, dest) != null){
				System.out.println("\nPath found");
			} else {
				System.out.println("\nNo such path exists");
			}

		} catch (IOException | BadFileException e) {
			e.printStackTrace();
		}
	}

	private static String getLineName(INode stationFound, ArrayList<IEdge> edges){
		for (IEdge edge : edges) {
			if (edge.getNodeAId() == stationFound.getId() || edge.getNodeBId() == stationFound.getId()) {
				return (edge.getName());
			}
		}

		return (null);
	}

	private static INode validate(Map<Integer, INode> nodes, ArrayList<IEdge> edges, String node, Scanner scanner){
		Map<String, INode> stationsFound = new HashMap<>();
		int stationCounter = 0;
		Boolean found = false;
		String input = "";
		INode targetNode = null;

		while(!found){
			System.out.println(node);
			input = scanner.next();
			for (int i = 1; i < nodes.size(); i++){
				if(nodes.get(i).getName().equals(input)){
					found = true;
					stationsFound.put(getLineName(nodes.get(i), edges), nodes.get(i));
					if(stationCounter < 1) targetNode = stationsFound.get(getLineName(nodes.get(i), edges));
					stationCounter++;
				}
			}
			if(!found) System.err.println("Station " + input + " was not found. Are you sure it's spelt correctly?");
		}

		if(stationCounter > 1){
			System.out.println(stationCounter + " stations have been found with the same name.");
			for (Object o : stationsFound.entrySet()) {
				Map.Entry station = (Map.Entry) o;
				System.out.println(input + " on line " + station.getKey());
			}
			found = false;
			while(!found) {
				System.out.println("Which of the above are you going to? Please provide the line name");
				input = scanner.next();
				if (stationsFound.get(input) != null) {
					found = true;
					targetNode = stationsFound.get(input);
				} else {
					System.err.println("Please try again. Are you sure it's spelt correctly");
				}
			}
		}

		return (targetNode);
	}
}
