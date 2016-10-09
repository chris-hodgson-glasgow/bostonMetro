package metroPackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Graph implements IGraph {
    private Map<Integer, INode> nodes;
    private ArrayList<IEdge> edges;

    Graph(){
        nodes = new HashMap<>();
        edges = new ArrayList<>();
    }

    public void setNode(int id, String name){
        INode station = new Station(id, name);
        nodes.put(station.getId(), station);
    }

    public void setEdge(int nodeAId, int nodeBId){
        IEdge edge = new Track(nodeAId, nodeBId);
        edges.add(edge);
    }

    public INode getNode(String name){
        for(int i = 1; i < nodes.size(); i++){
            if(nodes.get(i).getName().equals(name)){
                return (nodes.get(i));
            }
        }

        return (null);
    }

    public ArrayList<INode> getNeighbours(INode node){
        ArrayList<INode> neighbours = new ArrayList<>();

        for(IEdge edge : edges){
            if(edge.getNodeAId() == node.getId() && edge.getNodeBId() != 0){
                neighbours.add(nodes.get(edge.getNodeBId()));
            } else if(edge.getNodeBId() == node.getId() && edge.getNodeAId() != 0){
                neighbours.add(nodes.get(edge.getNodeAId()));
            }
        }

        return (neighbours);
    }

    public List<INode> getPath(INode src, INode dest){
        Set<INode> visited = new HashSet<>();
        Map<INode, INode> prev = new HashMap<>();
        List<INode> path = new LinkedList<>();
        Queue<INode> queue = new LinkedList<>();
        INode current = src;

        queue.add(current);
        visited.add(current);

        while(!queue.isEmpty()){
            current = queue.remove();

            if(current.equals(dest)){
                INode node = dest;
                while (node != null) {
                    path.add(node);
                    node = prev.get(node);
                }
                Collections.reverse(path);
                for (INode aPath : path) {
                    System.out.println(aPath.getName());
                }
                return (path);
            } else {
                for (INode node : getNeighbours(current)){
                    if(!visited.contains(node)){
                        queue.add(node);
                        visited.add(node);
                        prev.put(node, current);
                    }
                }
            }
        }

        return (null);
    }
}
