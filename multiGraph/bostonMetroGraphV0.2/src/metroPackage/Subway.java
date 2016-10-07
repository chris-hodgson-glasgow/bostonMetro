package metroPackage;

import java.util.*;

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
//				if ((tracks.get(x).getNodeAId() == visited.get(i).getId() && tracks.get(x).getNodeBId() == visited.get(i + 1).getId())) {
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

	public String getTrackColor(int id){
		for(Edge track : tracks){
			if(track.getNodeAId() == id || track.getNodeBId() == id){
				return (track.getLabel());
			}
		}
		return ("");
	}

	public ArrayList<String> getPath(Node src, Node dest){
		Queue<Node> queue = new LinkedList<>();
		ArrayList<String> visited = new ArrayList<>();
		ArrayList<String> visited1 = new ArrayList<>();
		String destColor = getTrackColor(dest.getId());
		String curColor = getTrackColor(src.getId());
		queue.add(src);

		while(!queue.isEmpty()){
			Node current = queue.remove();

			if(current.equals(dest)){
				return (visited);
			} else {
				for (Edge track : tracks) {
					if (track.getNodeAId() == current.getId() && track.getNodeBId() != 0) {
						if (!queue.contains(stations.get(track.getNodeBId())) &&
								!visited.contains(stations.get(track.getNodeBId()).getName())) {
							if (track.getLabel().equals(destColor) || track.getLabel().equals(curColor)){
								queue.add(stations.get(track.getNodeBId()));
							}
						}
					}
				}
				visited.add(current.getName());
			}
		}

		Node temp = src;
		src = dest;
		dest = temp;
		destColor = getTrackColor(dest.getId());
		curColor = getTrackColor(src.getId());
		queue.add(src);
		while(!queue.isEmpty()) {
			Node current = queue.remove();

			if (current.equals(dest)) {
				return (visited1);
			} else {
				for (Edge track : tracks) {
					if(track.getNodeAId() == current.getId() && visited.contains(stations.get(track.getNodeBId()).getName())){
						visited1.add(current.getName());
						Collections.reverse(visited1);
						visited.addAll(visited1);
						return (visited);
					} else if (track.getNodeAId() == current.getId() && track.getNodeBId() != 0) {
						if (!queue.contains(stations.get(track.getNodeBId())) &&
								!visited.contains(stations.get(track.getNodeBId()).getName())) {
							if (track.getLabel().equals(destColor) || track.getLabel().equals(curColor)) {
								queue.add(stations.get(track.getNodeBId()));
							}
						}
					}
				}
			}
			visited1.add(current.getName());
		}
		return (null);
	}


//	public ArrayList<String> getPath(Node src, Node dest){
//		Queue<Node> queue = new LinkedList<>();
//		ArrayList<Node> visited = new ArrayList<>();
//		//ArrayList<String> visited1 = new ArrayList<>();
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
//				return (trimPath(visited));
//			} else {
//				for (Edge track : tracks) {
//					if (track.getNodeAId() == current.getId() && track.getNodeBId() != 0) {
//						if (!queue.contains(stations.get(track.getNodeBId())) &&
//								!visited.contains(stations.get(track.getNodeBId()))) {
//							if(track.getLabel().contains(destColor) || track.getLabel().equals(curColor)) {
//								queue.add(stations.get(track.getNodeBId()));
//								curColor = track.getLabel();
//							}
//						}
//					}  /*else if (track.getNodeBId() == current.getId() && track.getNodeAId() != 0) {
//						if (!queue.contains(stations.get(track.getNodeAId())) &&
//								!visited.contains(stations.get(track.getNodeAId()).getName())) {
//							if(track.getLabel().contains(destColor) || track.getLabel().equals(curColor)) {
//								queue.add(stations.get(track.getNodeAId()));
//								curColor = track.getLabel();
//							}
//						}
//					} */
//				}
//			}
//			visited.add(current);
//			System.out.println(current.getName());
//		}
//		return null;
//		}
	}
