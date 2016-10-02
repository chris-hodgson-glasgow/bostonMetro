package bostonMetro;

import java.util.ArrayList;
import java.util.List;

public class Subway implements GraphInterface {
	
	private List<NodeInterface> allNodes;
	private List<EdgeInterface> allEdges;
	
	public Subway(){
		
		allNodes = new ArrayList<NodeInterface>();
		allEdges = new ArrayList<EdgeInterface>();
		
	}

	@Override
	public void addNode(NodeInterface inputNode) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addEdge(EdgeInterface edge) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<EdgeInterface> getPath(NodeInterface startStation, NodeInterface endStation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NodeInterface getNodeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NodeInterface> getNodeByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
