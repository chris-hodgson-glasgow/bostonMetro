package metroPackage;

import java.util.List;

class Subway {
    private IGraph subway;

    Subway(){
        subway = new Graph();
    }

    public void setStation(int id, String name){
        subway.setNode(id, name);
    }

    public void setTrack(int nodeAId, int nodeBId){
        subway.setEdge(nodeAId, nodeBId);
    }

    public INode getStation(String name){
        return (subway.getNode(name));
    }

    public List<INode> getPath(INode src, INode dest){
        return subway.getPath(src, dest);
    }
}
