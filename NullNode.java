public class NullNode extends Node
{
	public NullNode(Strategy strategy)
	{
		super(strategy);
	}
	
	@Override
	public boolean add(String string, Node parent, boolean addLeft)
	{
		return strategy.prependNode(this, parent, string, addLeft);
	}
	
	@Override
	public boolean isNull()
	{
		return true;
	}

}
