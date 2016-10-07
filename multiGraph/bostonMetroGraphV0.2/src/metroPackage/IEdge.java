package metroPackage;

public interface IEdge {

	public String getLabel();

	/**
	 * Gets first adjacent node
	 * @return The Node with matching id
	 */
	public int getNodeAId();

	/**
	 * Gets second adjacent node
	 * @return The Node with matching id
	 */
	public int getNodeBId();
}
