package metroPackage;

public class Edge implements IEdge{

    private String label;
    private int nodeAId;
    private int nodeBId;
    /**
     * Constructor setting up initial values
     * @param nodeAId  First station connected to this track
     * @param nodeBId  Second station connected to this track
     */
    public Edge(String label, int nodeAId, int nodeBId){
        this.label = label;
        this.nodeAId = nodeAId;
        this.nodeBId = nodeBId;
    }

    public String getLabel(){
        return (label);
    }

    /**
     * Gets the first station connected to this track
     * @return the first station connected to this track
     */
    public int getNodeAId(){
        return (nodeAId);
    }

    /**
     * Gets the second station connected to this track
     * @return the second station connected to this track
     */
    public int getNodeBId(){
        return (nodeBId);
    }

}
