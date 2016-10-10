package metroPackage;

interface INode {

	String getName();
	
	int getId();

	@Override
	boolean equals(Object o);

	@Override
	public int hashCode();
}
