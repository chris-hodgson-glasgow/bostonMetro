package metroPackage;

import java.util.*;

class Graph implements IGraph{
    private ArrayList<IEdge> edges;
    private HashMap<Integer, INode> nodes;

    Graph(){
        edges = new ArrayList<>();
        nodes = new HashMap<>();
    }

    public void setNode(int id, String name){
        INode node = new Station(id, name);
        nodes.put(node.getId(), node);
    }

    public void setEdge(String label, int nodeAId, int nodeBId){
        IEdge edge = new Track(label, nodeAId, nodeBId);
        edges.add(edge);
    }

    public INode getNode(String name){
        for(int i = 1; i < nodes.size(); i++){
            if(nodes.get(i).getName().equals(name))
                return (nodes.get(i));
        }
        return (null);
    }

    public HashMap<Integer, INode> getNodeList(){
        return (nodes);
    }

    public ArrayList<IEdge> getEdgeList(){
        return (edges);
    }


    public ArrayList<String> getPath(INode src, INode dest){
        Queue<INode> queue = new LinkedList<>();
        ArrayList<String> visited = new ArrayList<>();
        queue.add(src);

        while(!queue.isEmpty()){
            INode current = queue.remove();
            if(current.equals(dest)){
                return (visited);
            } else {
                for (IEdge edge : edges) {
                    if ((edge.getNodeAId() == current.getId() && edge.getNodeBId() != 0) &&
                            (!queue.contains(edges.get(edge.getNodeBId())) &&
                                    !visited.contains(edges.get(edge.getNodeBId()).getName()))) {
                        queue.add(edges.get(edge.getNodeBId()));
                    } else if ((edge.getNodeBId() == current.getId() && edge.getNodeAId() != 0) &&
                            (!queue.contains(edges.get(edge.getNodeAId())) &&
                                    !visited.contains(edges.get(edge.getNodeAId()).getName()))) {
                        queue.add(edges.get(edge.getNodeAId()));
                    }
                }
            }
            visited.add(current.getName());
        }
        return (null);
    }
}
