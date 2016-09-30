package metroPackage;

public class GraphEdge implements Edge{
	private int id;
	private Node nodeA;
	private Node nodeB;

	/**
	 * GraphEdge constructor setting initial values
	 * @param id    id of edge
	 * @param nodeA First adjacent node on edge
	 * @param nodeB Second adjacent node on edge
	 */
	public GraphEdge(int id, Node nodeA, Node nodeB){
		this.id = id;
		this.nodeA = nodeA;
		this.nodeB = nodeB;
	}

	public int getId() {
		return (id);
	}

	public Node getNodeA() {
		return (nodeA);
	}

	public Node getNodeB() {
		return (nodeB);
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNodeA(Node nodeA) {
		this.nodeA = nodeA;
	}

	public void setNodeB(Node nodeB) {
		this.nodeB = nodeB;
	}
}
