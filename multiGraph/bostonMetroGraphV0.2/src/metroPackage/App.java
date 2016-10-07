package metroPackage;
import java.util.Scanner;
public class App {

	public static void main(String[] args) {
		String start;
		String destination;
		Scanner input= new Scanner(System.in);
		System.out.println("Which station are you at now?");
		start = input.next();
		//take in and set Starting station
		System.out.println("Which station would you like to go too?");
		//take in and set destination station
		destination = input.next();
		//make graph by using MetroMapParser
		//pass destination and start to Searching algorithm
		input.close();
	}



}
