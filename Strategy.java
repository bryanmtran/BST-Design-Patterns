
public interface Strategy
{
	public boolean add(Node context, String string);
	public boolean prependNode(Node context, Node parent, String string, boolean addLeft);
}
