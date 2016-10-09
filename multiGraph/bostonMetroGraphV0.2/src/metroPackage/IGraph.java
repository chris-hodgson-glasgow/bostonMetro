package metroPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

interface IGraph {

	/**
	 * Adds a node to the graph
	 * @param id	The id of the node to add
	 * @param name	The name of the node to add
	 */
	void setNode(int id, String name);

	/**
	 * Adds an edge to the graph
	 * @param name 	The name of this line
	 * @param nodeAId 	The id of the first node on this edge
	 * @param nodeBId 	The id of the second node on this edge
	 */
	void setEdge(String name, int nodeAId, int nodeBId);

	/**
	 * Gets all nodes in the graph
	 * @return	All nodes in the graph
	 */
	Map<Integer, INode> getNodeList();

	/**
	 * Gets all edges in the graph
	 * @return	All edges in the graph
	 */
	ArrayList<IEdge> getEdgeList();

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
