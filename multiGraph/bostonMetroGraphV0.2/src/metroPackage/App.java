package metroPackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {

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

	static void makeSummary(List<INode> path, ArrayList<IEdge> edges){
		if(path.size() == 1) {
			System.out.println("You're already here");
		} else {
			String currentLine = getLine(path.get(0).getId(), path.get(1).getId(), edges);
			String nextLine;
			int sourceId = 0;

			if (path.size() == 2) {
				System.out.println("Go from station " + path.get(0).getName() + " to the next stop at station " + path.get(1).getName() + " on the " + currentLine + " line");
			} else if (path.size() == 3) {
				nextLine = getLine(path.get(1).getId(), path.get(2).getId(), edges);
				assert nextLine != null;
				if (nextLine.equals(currentLine)) {
					System.out.println("from station " + path.get(0).getName() + " stay on the " + currentLine + " line until you reach station " + path.get(2).getName());
				} else {
					System.out.println("Go from station " + path.get(0).getName() + " to station " + path.get(1).getName() + " on " + currentLine + " line");
					System.out.println("Go from station " + path.get(1).getName() + " to station " + path.get(2).getName() + " on " + nextLine + " line");
				}
			} else {
				for (int i = 2; i < path.size() - 1; i++) {
					nextLine = getLine(path.get(i).getId(), path.get(i + 1).getId(), edges);
					assert nextLine != null;
					if (nextLine.equals(currentLine)) {
						if (i == path.size() - 2) {
							System.out.println("from station " + path.get(sourceId).getName() + " stay on the " + currentLine + " line until you reach station " + path.get(i + 1).getName());
						}
					} else {
						System.out.println("from station " + path.get(sourceId).getName() + " go to station " + path.get(i).getName() + " on the " + currentLine + " line");
						sourceId = i;
					}
					currentLine = nextLine;
				}
			}
		}
	}

	static INode validate(Map<Integer, INode> nodes, ArrayList<IEdge> edges, String node, Scanner scanner){
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
