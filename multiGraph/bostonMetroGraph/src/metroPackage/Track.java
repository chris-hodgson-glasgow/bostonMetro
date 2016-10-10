package metroPackage;


class Track implements IEdge{

    private String lineName;
    private int outboundID;
    private int inboundID;

    Track(String lineName, int outboundID, int inboundID) {
        this.lineName = lineName;
        this.outboundID = outboundID;
        this.inboundID = inboundID;

    }

    public String getName() {
        return (lineName);
    }

    public int getNodeAId() {
        return (outboundID);
    }

    public int getNodeBId() {
        return (inboundID);
    }

}


