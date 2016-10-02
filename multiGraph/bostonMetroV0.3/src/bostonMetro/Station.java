package bostonMetro;

public class Station implements NodeInterface {
	
	private int id;
	private String name;
	
	public Station(int id, String name)
	{
		this.id = id;
		this.name = name;
	}

	@Override
	public String GetName() {
		
		return name;
	}

	@Override
	public int getID() {
		
		return id;
	}

}
