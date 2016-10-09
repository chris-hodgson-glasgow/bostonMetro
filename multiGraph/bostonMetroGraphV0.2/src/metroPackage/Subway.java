package metroPackage;

import java.util.List;

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
     * @param stationAId    The id of the first station on this track
     * @param stationBId 	The id of the second stationBId on this track
     */
    public void setTrack(String linename,int stationAId, int stationBId){
        subway.setEdge(linename,stationAId, stationBId);
    }

    //TODO: Account for stations with same name
    /**
     * Gets a station
     * @param name  The name of the station to get
     * @return      The station with matching name
     */
    public INode getStation(String name){
        return (subway.getNode(name));
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
