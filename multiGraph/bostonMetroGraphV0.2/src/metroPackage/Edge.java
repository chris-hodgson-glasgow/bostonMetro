package metroPackage;

public interface Edge {

	/**
	 * Gets the edge id.
	 * @return the Edge id
	 */
	public int getId();

	/**
	 * Gets first adjacent node
	 * @return The Node with matching id
	 */
	public Node getNodeA();

	/**
	 * Gets second adjacent node
	 * @return The Node with matching id
	 */
	public Node getNodeB();

	/**
	 * Sets the id of this edge
	 * @param id id to set
	 */
	public void setId(int id);

	/**
	 * Sets the first adjacent node on this edge
	 * @param nodeA Node to set as first adjacent node
	 */
	public void setNodeA(Node nodeA);

	/**
	 * Sets the second adjacent node on this edge
	 * @param nodeB Node to set as second adjacent node
	 */
	public void setNodeB(Node nodeB);
}
