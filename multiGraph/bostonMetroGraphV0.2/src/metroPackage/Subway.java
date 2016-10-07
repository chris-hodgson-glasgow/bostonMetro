package metroPackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Subway implements IGraph {
	private ArrayList<Edge> tracks;
	private HashMap<Integer, Node> stations;

	public Subway(){
		tracks = new ArrayList<>();
		stations = new HashMap<>();
	}

	public void setNode(int id, String name){
		Node station = new Node(id, name);
		stations.put(station.getId(), station);
	}

	public void setEdge(String label, int nodeAId, int nodeBId){
		Edge track = new Edge(label, nodeAId, nodeBId);
		tracks.add(track);
	}

	public Node getNode(String name){
		for(int i = 1; i < stations.size(); i++){
			if(stations.get(i).getName().equals(name))
				return (stations.get(i));
		}
		return (null);
	}

//	public ArrayList<String> trimPath(ArrayList<Node> visited){
//		Boolean link;
//		ArrayList<String> shortestPath = new ArrayList<>();
//		int i = 0;
//
//		while(i < visited.size() - 1) {
//			link = false;
//			for (int x = 0; x < tracks.size(); x++) {
//				if ((tracks.get(x).getNodeAId() == visited.get(i).getId() && tracks.get(x).getNodeBId() == visited.get(i + 1).getId()) ||
//						tracks.get(x).getNodeBId() == visited.get(i).getId() && tracks.get(x).getNodeAId() == visited.get(i + 1).getId()) {
//					link = true;
//				}
//			}
//				if (!link) {
//					System.out.println("no link with " + visited.get(i + 1).getName());
//					visited.remove(i + 1);
//				} else {
//					System.out.println("found link with " + visited.get(i + 1).getName());
//					i++;
//				}
//			}
//
//		for(int x = 0; x < visited.size(); x++){
//			shortestPath.add(visited.get(x).getName());
//		}
//
//		return (shortestPath);
//	}

//	public ArrayList<String> getPath(Node src, Node dest){
//		Queue<Node> queue = new LinkedList<>();
//		ArrayList<String> visited = new ArrayList<>();
//		ArrayList<String> visited1 = new ArrayList<>();
//		String destColor = "";
//		String curColor = "";
//		for(Edge track : tracks){
//			if(track.getNodeAId() == dest.getId() ||
//					track.getNodeBId() == dest.getId()){
//				destColor = track.getLabel();
//			}
//			if(track.getNodeAId() == src.getId() ||
//					track.getNodeBId() == src.getId()){
//				curColor = track.getLabel();
//			}
//		}
//		//System.out.println("Dest Line: " + destColor);
//		queue.add(src);
//
//		while(!queue.isEmpty()){
//			Node current = queue.remove();
//			//System.out.println("Line: " + curColor);
//
//			if(current.equals(dest)){
//				return (visited);
//			} else {
//				//if exact match ignore other resuls, keep exact, if relative ignore cuurent else current
//				int i = 0;
//				Boolean found = false;
//				while(!found && i < tracks.size()){
//					if (tracks.get(i).getNodeAId() == current.getId() && tracks.get(i).getNodeBId() != 0) {
//						if (!queue.contains(stations.get(tracks.get(i).getNodeBId())) &&
//								!visited.contains(stations.get(tracks.get(i).getNodeBId()).getName())) {
//							if(tracks.get(i).getLabel().equals(destColor)) {
//								queue.add(stations.get(tracks.get(i).getNodeBId()));
//								curColor = tracks.get(i).getLabel();
//								found = true;
//							}
//						}
//					}
//					i++;
//				}
//
//				i = 0;
//				while(!found && i < tracks.size()){
//					if (tracks.get(i).getNodeAId() == current.getId() && tracks.get(i).getNodeBId() != 0) {
//						if (!queue.contains(stations.get(tracks.get(i).getNodeBId())) &&
//								!visited.contains(stations.get(tracks.get(i).getNodeBId()).getName())) {
//							if(tracks.get(i).getLabel().contains(destColor)) {
//								queue.add(stations.get(tracks.get(i).getNodeBId()));
//								curColor = tracks.get(i).getLabel();
//								found = true;
//							}
//						}
//					}
//					i++;
//				}
//				i = 0;
//				while(!found && i < tracks.size()){
//					if (tracks.get(i).getNodeAId() == current.getId() && tracks.get(i).getNodeBId() != 0) {
//						if (!queue.contains(stations.get(tracks.get(i).getNodeBId())) &&
//								!visited.contains(stations.get(tracks.get(i).getNodeBId()).getName())) {
//							if(tracks.get(i).getLabel().equals(curColor)) {
//								queue.add(stations.get(tracks.get(i).getNodeBId()));
//								curColor = tracks.get(i).getLabel();
//								found = true;
//							}
//						}
//					}
//					i++;
//				}
//				i = 0;
//				while(!found && i < tracks.size()){
//					if (tracks.get(i).getNodeAId() == current.getId() && tracks.get(i).getNodeBId() != 0) {
//						if (!queue.contains(stations.get(tracks.get(i).getNodeBId())) &&
//								!visited.contains(stations.get(tracks.get(i).getNodeBId()).getName())) {
//							if(tracks.get(i).getLabel().contains(destColor)) {
//								queue.add(stations.get(tracks.get(i).getNodeBId()));
//								curColor = tracks.get(i).getLabel();
//								found = true;
//							}
//						}
//					}
//					i++;
//				}
//
//			}
//			visited.add(current.getName());
//			System.out.println(current.getName());
//		}
//		System.out.println("ERROR SEARCH 2 INIT");
//
//
//		Node target = src;
//		src = dest;
//		dest = target;
//		for(Edge track : tracks){
//			if(track.getNodeAId() == dest.getId() ||
//					track.getNodeBId() == dest.getId()){
//				destColor = track.getLabel();
//			}
//			if(track.getNodeAId() == src.getId() ||
//					track.getNodeBId() == src.getId()){
//				curColor = track.getLabel();
//			}
//		}
//		System.out.println("Dest Line: " + destColor);
//		queue.add(src);
//		System.out.println("SEARCH 2 START");
//		while(!queue.isEmpty()){
//			Node current = queue.remove();
//			if(!current.getName().equals("State") && !current.getName().equals("DowntownCrossing")) System.out.println(current.getName());
//			//System.out.println("Line: " + curColor);
//
//			if(current.equals(dest)){
//				return (visited);
//			} else {
//				int i = 0;
//				Boolean found = false;
//				while(!found && i < tracks.size()){
//					if (tracks.get(i).getNodeAId() == current.getId() && tracks.get(i).getNodeBId() != 0) {
//						if (!queue.contains(stations.get(tracks.get(i).getNodeBId())) &&
//								!visited.contains(stations.get(tracks.get(i).getNodeBId()).getName())) {
//							if(tracks.get(i).getLabel().equals(destColor)) {
//								queue.add(stations.get(tracks.get(i).getNodeBId()));
//								curColor = tracks.get(i).getLabel();
//								found = true;
//								if(!current.getName().equals("State") && !current.getName().equals("DowntownCrossing")) System.out.println("Found exact dest line");
//							}
//						}
//					} else if(tracks.get(i).getNodeBId() == current.getId() && tracks.get(i).getNodeAId() != 0) {
//						if (!queue.contains(stations.get(tracks.get(i).getNodeAId())) &&
//								!visited.contains(stations.get(tracks.get(i).getNodeAId()).getName())) {
//							if(tracks.get(i).getLabel().equals(destColor)) {
//								queue.add(stations.get(tracks.get(i).getNodeAId()));
//								curColor = tracks.get(i).getLabel();
//								found = true;
//								if(!current.getName().equals("State") && !current.getName().equals("DowntownCrossing")) System.out.println("Found exact dest line");
//							}
//						}
//					}
//					i++;
//				}
//
//				i = 0;
//				while(!found && i < tracks.size()){
//					if (tracks.get(i).getNodeAId() == current.getId() && tracks.get(i).getNodeBId() != 0) {
//						if (!queue.contains(stations.get(tracks.get(i).getNodeBId())) &&
//								!visited.contains(stations.get(tracks.get(i).getNodeBId()).getName())) {
//							if(tracks.get(i).getLabel().contains(destColor)) {
//								queue.add(stations.get(tracks.get(i).getNodeBId()));
//								curColor = tracks.get(i).getLabel();
//								found = true;
//								if(!current.getName().equals("State") && !current.getName().equals("DowntownCrossing")) System.out.println("Found relative dest line");
//							}
//						}
//					} else if (tracks.get(i).getNodeBId() == current.getId() && tracks.get(i).getNodeAId() != 0) {
//						if (!queue.contains(stations.get(tracks.get(i).getNodeAId())) &&
//								!visited.contains(stations.get(tracks.get(i).getNodeAId()).getName())) {
//							if(tracks.get(i).getLabel().contains(destColor)) {
//								queue.add(stations.get(tracks.get(i).getNodeAId()));
//								curColor = tracks.get(i).getLabel();
//								found = true;
//								if(!current.getName().equals("State") && !current.getName().equals("DowntownCrossing")) System.out.println("Found relative dest line");
//							}
//						}
//					}
//					i++;
//				}
//				i = 0;
//				while(!found && i < tracks.size()){
//					if (tracks.get(i).getNodeAId() == current.getId() && tracks.get(i).getNodeBId() != 0) {
//						if (!queue.contains(stations.get(tracks.get(i).getNodeBId())) &&
//								!visited.contains(stations.get(tracks.get(i).getNodeBId()).getName())) {
//							if(tracks.get(i).getLabel().equals(curColor)) {
//								queue.add(stations.get(tracks.get(i).getNodeBId()));
//								curColor = tracks.get(i).getLabel();
//								found = true;
//								if(!current.getName().equals("State") && !current.getName().equals("DowntownCrossing")) System.out.println("Found exact current line");
//							}
//						}
//					}
//					i++;
//				}
//				i = 0;
//				while(!found && i < tracks.size()){
//					if (tracks.get(i).getNodeAId() == current.getId() && tracks.get(i).getNodeBId() != 0) {
//						if (!queue.contains(stations.get(tracks.get(i).getNodeBId())) &&
//								!visited.contains(stations.get(tracks.get(i).getNodeBId()).getName())) {
//							if(tracks.get(i).getLabel().contains(destColor)) {
//								queue.add(stations.get(tracks.get(i).getNodeBId()));
//								curColor = tracks.get(i).getLabel();
//								found = true;
//								if(!current.getName().equals("State") && !current.getName().equals("DowntownCrossing")) System.out.println("Found relative dest line");
//							}
//						}
//					}
//					i++;
//				}
//			}
//			visited1.add(current.getName());
//			//System.out.println(current.getName());
//		}
//
//
//		return (null);
//	}


	public ArrayList<String> getPath(Node src, Node dest){
		Queue<Node> queue = new LinkedList<>();
		ArrayList<String> visited = new ArrayList<>();
		ArrayList<String> visited1 = new ArrayList<>();
		String destColor = "";
		String curColor = "";
		for(Edge track : tracks){
			if(track.getNodeAId() == dest.getId() ||
					track.getNodeBId() == dest.getId()){
				destColor = track.getLabel();
			}
			if(track.getNodeAId() == src.getId() ||
					track.getNodeBId() == src.getId()){
				curColor = track.getLabel();
			}
		}
		//System.out.println("Dest Line: " + destColor);
		queue.add(src);

		while(!queue.isEmpty()){
			Node current = queue.remove();
			//System.out.println("Line: " + curColor);

			if(current.equals(dest)){
				return (visited);
			} else {
				for (Edge track : tracks) {
					if (track.getNodeAId() == current.getId() && track.getNodeBId() != 0) {
						if (!queue.contains(stations.get(track.getNodeBId())) &&
								!visited.contains(stations.get(track.getNodeBId()).getName())) {
							if(track.getLabel().contains(destColor) || track.getLabel().equals(curColor)) {
								queue.add(stations.get(track.getNodeBId()));
								curColor = track.getLabel();
							}
						}
					}  else if (track.getNodeBId() == current.getId() && track.getNodeAId() != 0) {
						if (!queue.contains(stations.get(track.getNodeAId())) &&
								!visited.contains(stations.get(track.getNodeAId()).getName())) {
							if(track.getLabel().contains(destColor) || track.getLabel().equals(curColor)) {
								queue.add(stations.get(track.getNodeAId()));
								curColor = track.getLabel();
							}
						}
					}
				}
			}
			visited.add(current.getName());
			System.out.println(current.getName());
		}
		return null;

//		Node target = src;
//		src = dest;
//		dest = target;
//		for(Edge track : tracks){
//			if(track.getNodeAId() == dest.getId() ||
//					track.getNodeBId() == dest.getId()){
//				destColor = track.getLabel();
//			}
//			if(track.getNodeAId() == src.getId() ||
//					track.getNodeBId() == src.getId()){
//				curColor = track.getLabel();
//			}
//		}
//		System.out.println("Dest Line: " + destColor);
//		queue.add(src);
//		System.out.println("SEARCH 2 START");
//		while(!queue.isEmpty()){
//			Node current = queue.remove();
//			System.out.println(current.getName());
//			//System.out.println("Line: " + curColor);
//
//			if(current.equals(dest)){
//				return (visited);
//			} else {
//				for (Edge track : tracks) {
//					if (track.getNodeAId() == current.getId() && track.getNodeBId() != 0) {
//						if(visited.contains(current.getName())){
//							visited.addAll(visited1);
//							return (visited);
//						}
//						if (!queue.contains(stations.get(track.getNodeBId()))) {
//							if(track.getLabel().equals(destColor) || track.getLabel().equals(curColor)) {
//								queue.add(stations.get(track.getNodeBId()));
//								curColor = track.getLabel();
//							}
//						}
//					} /* else if (track.getNodeBId() == current.getId() && track.getNodeAId() != 0) {
//						if (!queue.contains(stations.get(track.getNodeAId())) &&
//								!visited.contains(stations.get(track.getNodeAId()).getName())) {
//							if(track.getLabel().equals(destColor) || track.getLabel().equals(curColor)) {
//								queue.add(stations.get(track.getNodeAId()));
//								curColor = track.getLabel();
//							}
//						}
//					} */
//				}
//			}
//			visited1.add(current.getName());
//			//System.out.println(current.getName());
//		}
	}
}
