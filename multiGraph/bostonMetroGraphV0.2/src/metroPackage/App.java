package metroPackage;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		try {
			MetroMapParser parser = new MetroMapParser("bostonmetro.txt");
			parser.generateGraphFromFile();
			Scanner scanner = new Scanner(System.in);
			System.out.println("src");
			String src = scanner.next();
			System.out.println("dest");
			String dest = scanner.next();
			scanner.close();

			System.out.println(parser.getGraph().getPath(parser.getGraph().getNode(src), parser.getGraph().getNode(dest)));

		} catch (IOException e) {
			System.out.println(e);
		} catch (BadFileException e) {
			e.printStackTrace();
		}
	}

}
