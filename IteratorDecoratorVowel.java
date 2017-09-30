import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorDecoratorVowel extends IteratorDecorator
{
	
	public IteratorDecoratorVowel(Iterator<String> decoratedIterator)
	{
		super(decoratedIterator);
	}
	
	@Override
	public String next()
	{
		while(decoratedIterator.hasNext())
		{
			String element = decoratedIterator.next();
			if (element.charAt(0) == 'a' || element.charAt(0) == 'A' ||
				element.charAt(0) == 'e' ||	element.charAt(0) == 'E' ||
				element.charAt(0) == 'i' ||	element.charAt(0) == 'I' ||
				element.charAt(0) == 'o' ||	element.charAt(0) == 'O' ||
				element.charAt(0) == 'u' || element.charAt(0) == 'U' )
			{
				return element;
			}
		}
		throw new NoSuchElementException();
	}

}
