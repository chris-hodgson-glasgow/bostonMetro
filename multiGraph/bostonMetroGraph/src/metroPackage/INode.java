package metroPackage;

interface INode {

	/**
	 * gets the nodes name
	 * @return	the nodes name
	 */
	String getName();

	/**
	 * gets the nodes id
	 * @return	the nodes id
	 */
	int getId();

	/**
	 * checks for equality between this node and another
	 * @param o	the node to compare this node to
	 * @return	true if the 2 nodes are equal else false
	 */
	@Override
	boolean equals(Object o);

	/**
	 * gets the nodes hashcode
	 * @return	the nodes hashcode
	 */
	@Override
	int hashCode();
}
