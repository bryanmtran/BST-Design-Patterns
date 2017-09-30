public class HeadNode extends Node
{
	public HeadNode(Strategy strategy)
	{
		super(strategy);
		NullNode left = new NullNode(strategy);
		NullNode right = new NullNode(strategy);
		this.left = left;
		this.right = right;
	}
	
	
	public boolean add(String string)
	{
		if (this.string == null)
		{
			this.string = string;
			return true;
		}
		return strategy.add(this, string);
	}
	
}
