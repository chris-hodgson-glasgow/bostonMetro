package metroPackage;

public class Track {
    private Edge track;

    /**
     * Constructor setting up initial values
     * @param id        id of track
     * @param stationA  First station connected to this track
     * @param stationB  Second station connected to this track
     */
    public Track(int id, Station stationA, Station stationB){
        track = new GraphEdge(id, stationA, stationB);
    }

    /**
     * Gets the track object
     * @return the track object
     */
    public Edge getTrack(){
        return (track);
    }

    /**
     * Gets the track id
     * @return the track id
     */
    public int getId(){
        return (track.getId());
    }

    /**
     * Gets the first station connected to this track
     * @return the first station connected to this track
     */
    public Station getStationA(){
        return (track.getNodeA());
    }

    /**
     * Gets the second station connected to this track
     * @return the second station connected to this track
     */
    public Station getStationB(){
        return (track.getNodeB());
    }

    /**
     * Sets the id of this track
     * @param id id to set
     */
    public void setId(int id){
        track.setId(id);
    }

    /**
     * Sets the first station connected to this track
     * @param stationA First station to set
     */
    public void setStationA(Station stationA){
        track.setNodeA(stationA);
    }

    /**
     * Sets the second station connected to this track
     * @param stationB Second station to set
     */
    public void setStationB(Station stationB){
        track.setNodeB(stationB);
    }
}
