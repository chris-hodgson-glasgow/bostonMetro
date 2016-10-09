package metroPackage;

import java.util.ArrayList;
import java.util.List;

interface IGraph {

	/**
	 * Adds a node to the graph
	 * @param id	the id of the node to add
	 * @param name	the name of the node to add
	 */
	void setNode(int id, String name);

	/**
	 * Adds an edge to the graph
	 * @param nodeAId 	the id of the first node on this edge
	 * @param nodeBId 	the id of the second node on this edge
	 */
	void setEdge(String lineName ,int nodeAId, int nodeBId);

	//TODO: Account for nodes with same name
	/**
	 * Gets a node
	 * @param name	The name of the node to get
	 * @return		the node with matching name
	 */
	INode getNode(String name);

	/**
	 * Gets a nodes neighbours
	 * @param node	The node to check
	 * @return		The nodes neighbours
	 */
	ArrayList<INode> getNeighbours(INode node);

	/**
	 * Gets the shortest path from source node to destination node
	 * @param src	The source node
	 * @param dest	The destination node
	 * @return		The nodes along the shortest path from src to dest
	 */
	List<INode> getPath(INode src, INode dest);

}
