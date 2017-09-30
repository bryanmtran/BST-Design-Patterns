import java.util.Iterator;

public class IteratorDecoratorCaps extends IteratorDecorator
{

	public IteratorDecoratorCaps(Iterator<String> decoratedIterator)
	{
		super(decoratedIterator);
	}
	
	@Override
	public String next()
	{
		return decoratedIterator.next().toUpperCase();
	}
}
