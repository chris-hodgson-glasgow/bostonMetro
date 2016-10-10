package metroPackage;

class Station implements INode {

	private int id;
	private String name;

	/**
	 * Station constructor initialising the id and name
	 * @param id	the id to set
	 * @param name	the name to set
	 */
	Station(int id, String name) {
		this.id = id;
		this.name = name;
	}

	/**
	 * gets the id for this station
	 * @return the id for this station
	 */
	public int getId(){
		return id;
	}

	/**
	 * gets the name of this station
	 * @return	the name of this station
	 */
	public String getName() {
		return name;
	}

	/**
	 * checks for equality between this node and another
	 * @param o	the node to compare this node to
	 * @return	true if the 2 nodes are equal else false
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Station station = (Station) o;

		return id == station.id && name.equals(station.name);
	}

	/**
	 * gets the nodes hashcode
	 * @return	the nodes hashcode
	 */
	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + name.hashCode();
		return result;
	}
}
