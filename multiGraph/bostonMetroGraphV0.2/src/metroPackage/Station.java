package metroPackage;

class Station implements INode {

	private int id;
	private String name;

	Station(int id, String name){

		this.id = id;
		this.name = name;

	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}
}
