import java.util.Iterator;

public abstract class IteratorDecorator implements Iterator<String>
{
	protected Iterator<String> decoratedIterator;
	
	public IteratorDecorator(Iterator<String> decoratedIterator)
	{
		this.decoratedIterator = decoratedIterator;
	}
	
	@Override
	public boolean hasNext()
	{
		return decoratedIterator.hasNext();
	}
	
	@Override
	public String next()
	{
		return decoratedIterator.next();
	}
}
