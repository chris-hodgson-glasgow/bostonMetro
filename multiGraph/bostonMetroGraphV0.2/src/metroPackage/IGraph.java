package metroPackage;

import java.util.ArrayList;
import java.util.HashMap;

interface IGraph {

	void setNode(int id, String name);

	void setEdge(String label, int nodeA, int nodeB);

	INode getNode(String name);

	HashMap<Integer, INode> getNodeList();

	ArrayList<IEdge> getEdgeList();

	ArrayList<String> getPath(INode src, INode dest);

}
