package metroPackage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Driver {public static void main(String[] args) {
    try {
        MetroMapParser parser = new MetroMapParser("bostonmetro.txt");
        Metro g = new Metro();
        parser.generateGraphFromFile(g);
        App userInput = new App();
        Metro metro = parser.getGraph();
        Map<Integer, INode> nodes = metro.getStationList();
        ArrayList<IEdge> edges = metro.getTrackList();

        Scanner scanner = new Scanner(System.in);
        INode src = userInput.validate(nodes, edges, "What is the Station you are starting at?", scanner);
        INode dest = userInput.validate(nodes, edges, "Which Station would you like to go to?", scanner);
        scanner.close();

        List<INode> path = metro.getPath(src, dest);
        if(path != null){
            System.out.println("\nPath found");
            userInput.makeSummary(path, edges);
        } else {
            System.out.println("\nNo such path exists");
        }

    } catch (IOException | BadFileException e) {
        e.printStackTrace();
    }
}
}
