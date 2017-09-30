public class Alphabetical implements Strategy
{
	@Override
	public boolean add(Node context, String string)
	{
		if (string.compareToIgnoreCase(context.string) < 0)
		{
			return context.left.add(string,context,true);
		}
		else if (string.compareToIgnoreCase(context.string) > 0)
		{
			return context.right.add(string,context,false);
		}
		else
		{
			// Inserted string is equivalent to existing string element
			// Duplicates are not allowed. Return false.
			return false;
		}
	}
	
	@Override
	public boolean prependNode(Node context, Node parent, String string, boolean addLeft)
	{
		Node newNode = new Node(context.strategy,string);
		if (addLeft)
		{
			parent.left = newNode;
		}
		else
		{
			parent.right = newNode;
		}
			
		// Set the new node's left child to the context (a NullNode), and create another
		// NullNode to be the new node's right child.
		newNode.left = context;
		NullNode newNull = new NullNode(context.strategy);
		newNode.right = newNull;
		
		return true;
	}
}
