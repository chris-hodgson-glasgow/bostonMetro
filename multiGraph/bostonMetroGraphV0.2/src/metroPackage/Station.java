package metroPackage;

import java.util.Arrays;

public class Station implements NodeInterface {

	private int id;
	private String name;
	private String[] lines;
	
	//first element of the array is the name of the line and 
	//second and third are the neighbours on that line. 
	private String[][] neighbours = new String[4][3];
	
	//an example empty array to test if the neighbour holder array
	//is empty using Array.deepEquals.
	private String[] testEmptyArray = new String[2]; 
	
	Station(int id, String name, String[] lines){
		
		this.id = id;
		this.name = name;
		this.lines = lines;
		
	}
	
	@Override
	public String getName() {
		
		return name;
	}

	
	@Override
	public String[] getNeighbours(String edge) {
		
		String[] neighbourHolder = new String[2];
		
		for(int i = 0; i < 4; i++)
		{
				if(neighbours[i][0] == edge)
				{
					neighbourHolder[0] = neighbours[i][1];
					neighbourHolder[1] = neighbours[i][2];
				}
		}
		
		if(Arrays.deepEquals(neighbourHolder, testEmptyArray))
		{
			return null;
		}else
		{
			return neighbourHolder;
		}
		
		
	}

}
