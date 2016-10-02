package bostonMetro;

import java.util.List;

public interface GraphInterface {
	
	public void addNode(NodeInterface inputNode);
	
	public void addEdge(EdgeInterface edge);
	
	public List<EdgeInterface> getPath(NodeInterface startStation, NodeInterface endStation);
	
	public NodeInterface getNodeById(int id);
	
	public List<NodeInterface> getNodeByName(String name); 

}
