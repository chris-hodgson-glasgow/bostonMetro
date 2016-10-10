package metroPackage;

class Station implements INode {

	private int id;
	private String name;

	Station(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId(){
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Station station = (Station) o;

		return id == station.id && name.equals(station.name);
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + name.hashCode();
		return result;
	}
}
