package metroPackage;
import java.util.Scanner;
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String start;
		String destenation;
		Scanner input= new Scanner(System.in);
		System.out.println("Which station are you at now?");
		start = input.next();
		//take in and set Starting station
		System.out.println("Whhich station would you like to go too?");
		//take in and set destination station
		destenation =input.next();
		//make graph by using MetroMapPraser
		//pass destination and start to Searching algorithm
		input.close();
	}



}
