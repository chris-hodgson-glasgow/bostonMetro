package metroPackage;

public class Track {
    private Edge track;

    public Track(int id, Node stationA, Node stationB){
        track = new GraphEdge(id, stationA, stationB);
    }

    public Edge getTrack(){
        return (track);
    }

    public int getId(){
        return (track.getId());
    }

    public Node getStationA(){
        return (track.getNodeA());
    }

    public Node getStationB(){
        return (track.getNodeB());
    }

    public void setId(int id){
        track.setId(id);
    }

    public void setStationA(Node stationA){
        track.setNodeA(stationA);
    }

    public void setStationB(Node stationB){
        track.setNodeB(stationB);
    }
}
