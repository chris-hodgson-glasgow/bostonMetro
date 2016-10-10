package metroPackage;


class Track implements IEdge{

    private String lineName;
    private int outboundID;
    private int inboundID;

    /**
     * Track constructor initialising lineName, outboundID and inboundID
     * @param lineName      the lineName to set
     * @param outboundID    the outboundID to set
     * @param inboundID     the inboundID to set
     */
    Track(String lineName, int outboundID, int inboundID) {
        this.lineName = lineName;
        this.outboundID = outboundID;
        this.inboundID = inboundID;

    }

    /**
     * gets the stations name
     * @return  the stations name
     */
    public String getName() {
        return (lineName);
    }

    /**
     * gets the id of the first station on this track
     * @return the id of the first station on this track
     */
    public int getNodeAId() {
        return (outboundID);
    }

    /**
     * gets the id of the second station on this track
     * @return the id of the second station on this track
     */
    public int getNodeBId() {
        return (inboundID);
    }

}


