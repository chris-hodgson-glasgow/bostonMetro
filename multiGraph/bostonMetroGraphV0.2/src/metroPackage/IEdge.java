package metroPackage;

public interface IEdge {

	/**
	 * Gets the edge id.
	 * @return the Edge id
	 */
	public String getLineName();

	/**
	 * Gets first adjacent node
	 * @return The Node with matching id
	 */
	public int getNodeAId();

	/**
	 * Gets second adjacent node
	 * @return The Node with matching id
	 */
	public 	int getNodeBId();

	/**
	 * Sets the id of this edge
	 * @param id id to set
	 */

	public void setNodeA(int nodeA);

	/**
	 * Sets the second adjacent node on this edge
	 * @param nodeB Node to set as second adjacent node
	 */
	public void setNodeB(int nodeB);
}
