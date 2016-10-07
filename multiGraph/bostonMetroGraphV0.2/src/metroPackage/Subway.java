package metroPackage;

import java.util.*;

class Subway {
    private IGraph subway;
    private ArrayList<IEdge> tracks;
    private HashMap<Integer, INode> stations;

    Subway(){
        subway = new Graph();
        tracks = subway.getEdgeList();
        stations = subway.getNodeList();
    }

    public void setStation(int id, String name){
        subway.setNode(id, name);
    }

    public void setTrack(String label, int nodeAId, int nodeBId){
        subway.setEdge(label, nodeAId, nodeBId);
    }

    public INode getStation(String name){
        return (subway.getNode(name));
    }

    public HashMap<Integer, INode> getStationList(){
        return (subway.getNodeList());
    }

    public ArrayList<IEdge> getTrackList(){
        return (subway.getEdgeList());
    }

    private String getTrackColor(int id){
        for(IEdge track : tracks){
            if(track.getNodeAId() == id || track.getNodeBId() == id){
                return (track.getLabel());
            }
        }
        return ("");
    }

    public ArrayList<String> getPath(INode src, INode dest){
        Queue<INode> queue = new LinkedList<>();
        ArrayList<String> visited = new ArrayList<>();
        ArrayList<String> visited1 = new ArrayList<>();
        String destColor = getTrackColor(dest.getId());
        String curColor = getTrackColor(src.getId());
        queue.add(src);

        while(!queue.isEmpty()){
            INode current = queue.remove();

            if(current.equals(dest)){
                return (visited);
            } else {
                for (IEdge track : tracks) {
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

        INode temp = src;
        src = dest;
        dest = temp;
        destColor = getTrackColor(dest.getId());
        curColor = getTrackColor(src.getId());
        queue.add(src);
        while(!queue.isEmpty()) {
            INode current = queue.remove();

            if (current.equals(dest)) {
                return (visited1);
            } else {
                for (IEdge track : tracks) {
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
}
