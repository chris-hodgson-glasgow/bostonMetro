package metroPackage;

import java.util.ArrayList;
import java.util.List;

interface IGraph {

	void setNode(int id, String name);

	void setEdge(int nodeAId, int nodeBId);

	INode getNode(String name);

	ArrayList<INode> getNeighbours(INode node);

	List<INode> getPath(INode src, INode dest);

}
