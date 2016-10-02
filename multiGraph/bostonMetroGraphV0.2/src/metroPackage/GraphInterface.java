package metroPackage;

public interface GraphInterface {

	public void setNode(int id,String name, String line);
	
	public NodeInterface getNode(int id);
	
	public int[] getNeighbours(int id, String line);
	
}
