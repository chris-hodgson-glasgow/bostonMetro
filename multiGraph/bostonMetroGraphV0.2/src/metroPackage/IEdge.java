package metroPackage;

interface IEdge {

	/**
	 * Gets the edge name.
	 * @return the Edge name
	 */
	public String getName();

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

}
