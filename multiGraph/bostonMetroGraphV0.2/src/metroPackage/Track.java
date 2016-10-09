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


        public String getlineName() {
            return lineName;



        public INode getNodeA() {
            return null;
        }


        public INode getNodeB() {
            return null;
        }

        public void setId(int id) {

        }


        public void setNodeA(INode nodeA) {

        }


        public void setNodeB(INode nodeB) {

        }
    }

}
