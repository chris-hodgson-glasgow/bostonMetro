package metroPackage;


public class Track implements IEdge{



    private String lineName;
    private int outboundID;
    private int inboundID;





    Track(String name,int outboundID, int inboundID){

        this.lineName = name;
        this.outboundID = outboundID;
        this.inboundID = inboundID;


    }


    public String getLineName() {
        return lineName;
    }



    public int getNodeAId() {
        return outboundID;
    }


    public int getNodeBId() {
        return inboundID;
    }




    public void setNodeA(int nodeA) {
        outboundID=nodeA;
    }


    public void setNodeB(int nodeB) {
        inboundID=nodeB;
    }
}


