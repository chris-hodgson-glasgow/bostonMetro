package metroPackage;

import java.util.ArrayList;

public interface IGraph {

	public void setNode(int id, String name);

	public void setEdge(String label, int nodeA, int nodeB);

	public Node getNode(String name);

	// public ArrayList<String> trimPath(ArrayList<Node> visited);

	public ArrayList<String> getPath(Node src, Node dest);
}
