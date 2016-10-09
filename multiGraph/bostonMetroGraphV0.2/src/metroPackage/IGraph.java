package metroPackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

interface IGraph {

	void setNode(int id, String name);

	void setEdge(int nodeAId, int nodeBId);

	INode getNode(String name);

	public ArrayList<INode> getNeighbours(INode node);

	public List<INode> getPath(INode src, INode dest);

}
