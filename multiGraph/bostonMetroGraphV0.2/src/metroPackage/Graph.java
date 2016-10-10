package metroPackage;

import java.util.*;

class Graph implements IGraph {
    private Map<Integer, INode> nodes;
    private ArrayList<IEdge> edges;

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
        INode node = new Station(id, name);

        nodes.put(node.getId(), node);
    }

    /**
     * Adds an edge to the graph
     * @param name 	The name of this line
     * @param nodeAId 	The id of the first node on this edge
     * @param nodeBId 	The id of the second node on this edge
     */
    public void setEdge(String name, int nodeAId, int nodeBId){
        IEdge edge = new Track(name, nodeAId, nodeBId);
        edges.add(edge);
    }

    /**
     * Gets all nodes in the graph
     * @return	All nodes in the graph
     */
    public Map<Integer, INode> getNodeList(){
        return (nodes);
    }

    /**
     * Gets all edges in the graph
     * @return	All edges in the graph
     */
    public ArrayList<IEdge> getEdgeList(){
        return (edges);
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
