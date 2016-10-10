package metroPackage;

import java.io.IOException;
import java.util.*;

public class Driver {public static void main(String[] args) {
    try {
        MetroMapParser parser = new MetroMapParser("bostonmetro.txt");
        Metro metro = new Metro();
        parser.generateGraphFromFile(metro);
        App userInput = new App();
        Map<Integer, INode> nodes = metro.getStationList();
        ArrayList<IEdge> edges = metro.getTrackList();

        Scanner scanner = new Scanner(System.in);
        INode src = App.validate(nodes, edges, "What is the Station you are starting at?", scanner);
        INode dest = App.validate(nodes, edges, "Which Station would you like to go to?", scanner);
        scanner.close();

        List<INode> path = metro.getPath(src, dest);
        if(path != null){
            System.out.println("\nPath found");
            App.makeSummary(path, edges);
        } else {
            System.out.println("\nNo such path exists");
        }

    } catch (IOException | BadFileException e) {
        e.printStackTrace();
    }
}
}
