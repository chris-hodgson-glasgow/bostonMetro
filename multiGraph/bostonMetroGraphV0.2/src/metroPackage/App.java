package metroPackage;

import java.io.IOException;
import java.util.*;

public class App {

	public static void main(String[] args) {
		try {
			MetroMapParser parser = new MetroMapParser("bostonmetro.txt");
			Metro g = new Metro();
			parser.generateGraphFromFile(g);

			Metro metro = parser.getGraph();
			Map<Integer, INode> nodes = metro.getStationList();
			ArrayList<IEdge> edges = metro.getTrackList();

			Scanner scanner = new Scanner(System.in);
			INode src = validate(nodes, edges, "What is the Station you are starting at?", scanner);
			INode dest = validate(nodes, edges, "Which Station would you like to go to?", scanner);
			scanner.close();

			List<INode> path = metro.getPath(src, dest);
			if(path != null){
				System.out.println("\nPath found");
				makeSummary(path, edges);
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

	private static String getLine(int nodeAId, int nodeBId, ArrayList<IEdge> edges){
		for(IEdge edge : edges){
			if(edge.getNodeAId() == nodeAId && edge.getNodeBId() == nodeBId ||
					edge.getNodeBId() == nodeAId && edge.getNodeAId() == nodeBId){
				return(edge.getName());
			}
		}
		return null;
	}

	private static void makeSummary(List<INode> path, ArrayList<IEdge> edges){
		String currentLine = getLine(path.get(0).getId(), path.get(1).getId(), edges);
		String nextLine;
		int sourceId = 0;
		for(int i = 2; i < path.size() - 1; i++){
			nextLine = getLine(path.get(i).getId(), path.get(i + 1).getId(), edges);
			if(nextLine.equals(currentLine)){
				if(i == path.size() - 2){
					System.out.println("from " + path.get(sourceId).getName() + " stay on the " + currentLine + " line until you reach " + path.get(i + 1).getName());
				}
			} else {
				System.out.println("from " + path.get(sourceId).getName() + " go to " + path.get(i).getName() + " on " + currentLine + " line");
				sourceId = i;
			}
			currentLine = nextLine;
		}
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
				if(nodes.get(i).getName().equalsIgnoreCase(input)){
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
