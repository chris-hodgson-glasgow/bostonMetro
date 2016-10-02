package bostonMetro;

public class Track implements EdgeInterface {
	
	private String name;
	private NodeInterface inboundStation;
	private NodeInterface outboundStation;
	
	public Track(String name, NodeInterface inboundStation, NodeInterface outboundStation)
	{
		this.name = name;
		this.inboundStation = inboundStation;
		this.outboundStation = outboundStation;
	}

	@Override
	public String getName() {
		
		return name;
	}

	@Override
	public NodeInterface getInboundNode() {
		
		return inboundStation;
	}

	@Override
	public NodeInterface getOutboundNode() {
		
		return outboundStation;
	}

}
