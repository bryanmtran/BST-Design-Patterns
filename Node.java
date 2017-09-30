public class Node 
{
	String string;
	Node left, right;
	Strategy strategy;
	
	public Node(Strategy strategy)
	{
		this.strategy = strategy;
		this.string = null;
		this.left = null;
		this.right = null;
	}
	
	public Node(Strategy strategy, String string)
	{
		this.strategy = strategy;
		this.string = string;
		this.left = null;
		this.right = null;
	}
	
	// In a 'regular' node, parameters 'parent and 'addLeft' are not used in
	// this add method. They exist to allow for polymorphic method calls between
	// this class's add and NullNode's add.
	public boolean add(String string, Node parent, boolean addLeft)
	{
		return strategy.add(this, string);
	}
	
	public boolean isNull()
	{
		return false;
	}
}
