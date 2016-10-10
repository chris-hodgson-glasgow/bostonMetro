package metroPackage;

interface IEdge {

	/**
	 * Gets the edge name.
	 * @return the Edge name
	 */
	String getName();

	/**
	 * Gets first adjacent node
	 * @return The Node with matching id
	 */
	int getNodeAId();

	/**
	 * Gets second adjacent node
	 * @return The Node with matching id
	 */
	int getNodeBId();

}
