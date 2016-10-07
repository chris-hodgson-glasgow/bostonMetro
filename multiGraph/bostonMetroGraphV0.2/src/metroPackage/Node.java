package metroPackage;

import java.util.ArrayList;
import java.util.Arrays;

public class Node implements INode {

	private int id;
	private String name;
	
	Node(int id, String name){
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return (name);
	}

	public int getId(){
		return (id);
	}

}
