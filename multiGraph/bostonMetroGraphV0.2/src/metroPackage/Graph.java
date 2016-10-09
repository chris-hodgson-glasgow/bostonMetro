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

    /**
     * Graph constructor initialising nodes HashMap and edges ArrayList
     */
    Graph(){
        nodes = new HashMap<>();
        edges = new ArrayList<>();
    }

    /**
     * Adds a node to the graph
     * @param id	The id of the node to add
     * @param name	The name of the node to add
     */
    public void setNode(int id, String name){
        INode station = new Station(id, name);
        nodes.put(station.getId(), station);
    }



    /**
     * Adds an edge to the graph
     * @param nodeAId 	The id of the first node on this edge
     * @param nodeBId 	The id of the second node on this edge
     */
    public void setEdge(String lineName int nodeAId, int nodeBId){
        IEdge edge = new track(lineName,nodeAId, nodeBId);
        edges.add(edge);
    }

    //TODO: Account for nodes with same name
    /**
     * Gets a node
     * @param name	The name of the node to get
     * @return		The node with matching name
     */
    public INode getNode(String name){
        for(int i = 1; i < nodes.size(); i++){
            if(nodes.get(i).getName().equals(name)){
                return (nodes.get(i));
            }
        }

        return (null);
    }

    /**
     * Gets a nodes neighbours
     * @param node	The node to check
     * @return		The nodes neighbours
     */
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

    /**
     * Gets the shortest path from source node to destination node
     * @param src	The source node
     * @param dest	The destination node
     * @return		The nodes along the shortest path from src to dest
     */
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
