package metroPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class Subway {
    private IGraph subway;

    /**
     * Subway constructor initialising subway Graph
     */
    Subway(){
        subway = new Graph();
    }

    /**
     * Adds a station to the subway
     * @param id	The id of the station to add
     * @param name	The name of the station to add
     */
    public void setStation(int id, String name){
        subway.setNode(id, name);
    }

    /**
     * Adds a track to the subway
     * @param lineName      The line this track is on
     * @param stationAId    The id of the first station on this track
     * @param stationBId 	The id of the second stationBId on this track
     */
    public void setTrack(String lineName,int stationAId, int stationBId){
        subway.setEdge(lineName,stationAId, stationBId);
    }

    /**
     * Gets all stations in the subway
     * @return  All stations in the subway
     */
    public Map<Integer, INode> getStationList(){
        return (subway.getNodeList());
    }

    /**
     * Gets all tracks in the subway
     * @return  All tracks in the subway
     */
    public ArrayList<IEdge> getTrackList(){
        return (subway.getEdgeList());
    }

    /**
     * Gets the shortest path from source station to destination station
     * @param src   The source station
     * @param dest  The destination station
     * @return      The stations along the shortest path from src to dest
     */
    public List<INode> getPath(INode src, INode dest){
        return subway.getPath(src, dest);
    }
}
