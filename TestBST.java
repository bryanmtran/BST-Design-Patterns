import static org.junit.Assert.*;
import java.util.NoSuchElementException;
import org.junit.Test;

public class TestBST 
{
	private BinarySearchTree bst;
	
	@Test
	public void testAddAndSize()
	{
		bst = new BinarySearchTree(new Alphabetical());
		
		// Test on 1 node:
		bst.add("E");
		assertEquals("E",bst.root.string);
		assertEquals(1,bst.size());
		
		// Test on multiple nodes:
		bst.add("C");
		assertEquals("C",bst.root.left.string);
		bst.add("H");
		assertEquals("H",bst.root.right.string);
		bst.add("A");
		assertEquals("A",bst.root.left.left.string);
		bst.add("D");
		assertEquals("D",bst.root.left.right.string);
		bst.add("F");
		assertEquals("F",bst.root.right.left.string);
		bst.add("J");
		assertEquals("J",bst.root.right.right.string);
		bst.add("J");
		assertEquals("J",bst.root.right.right.string);
		assertEquals(7,bst.size());
		
		// Test irregular input.
		bst.add("3");
		assertEquals("3",bst.root.left.left.left.string);
		bst.add("!");
		assertEquals("!",bst.root.left.left.left.left.string);
		bst.add("Z");
		assertEquals("Z",bst.root.right.right.right.string);
		bst.add("z");
		assertEquals("Z",bst.root.right.right.right.string);
		bst.add("");
		assertEquals("",bst.root.left.left.left.left.left.string);
		bst.add(" ");
		assertEquals(" ",bst.root.left.left.left.left.left.right.string);
		assertEquals(12,bst.size());
	}
	
	@Test
	public void testToArrayAndToString()
	{
		bst = new BinarySearchTree(new Alphabetical());
		bst.add("C");
		bst.add("B");
		bst.add("D");
		bst.add("A");
		bst.add("E");
		String[] array = bst.toArray();
		assertEquals("A",array[0]);
		assertEquals("B",array[1]);
		assertEquals("C",array[2]);
		assertEquals("D",array[3]);
		assertEquals("E",array[4]);
		
		assertEquals("[A, B, C, D, E]",bst.toString());
	}
	
	@Test(expected=IllegalStateException.class)
	public void testIteratorState()
	{
		bst = new BinarySearchTree(new Alphabetical());
		BSTIterator iterator = bst.iterator();
		bst.add("E");
		iterator.next();
	}
	
	@Test(expected=NoSuchElementException.class)
	public void testIteratorEmpty()
	{
		bst = new BinarySearchTree(new Alphabetical());
		bst.add("E");
		BSTIterator iterator = bst.iterator();
		iterator.next();
		iterator.next();
	}
	
	@Test
	public void testIterator()
	{
		bst = new BinarySearchTree(new Alphabetical());
		bst.add("E");
		bst.add("C");
		bst.add("H");
		bst.add("A");
		bst.add("D");
		bst.add("F");
		bst.add("J");
		
		BSTIterator iterator = bst.iterator();
		assertEquals(true,iterator.hasNext());
		assertEquals("A",iterator.next());
		assertEquals("C",iterator.next());
		assertEquals("D",iterator.next());
		assertEquals("E",iterator.next());
		assertEquals("F",iterator.next());
		assertEquals("H",iterator.next());
		assertEquals("J",iterator.next());
		assertEquals(false,iterator.hasNext());
	}
	
	@Test(expected=IllegalStateException.class)
	public void testIteratorReverseState()
	{
		bst = new BinarySearchTree(new Alphabetical());
		BSTIteratorReverse iterator = bst.iteratorReverse();
		bst.add("E");
		iterator.next();
	}
	
	@Test(expected=NoSuchElementException.class)
	public void testIteratorReverseEmpty()
	{
		bst = new BinarySearchTree(new Alphabetical());
		bst.add("E");
		BSTIteratorReverse iterator = bst.iteratorReverse();
		iterator.next();
		iterator.next();
	}
	
	@Test
	public void testIteratorReverse()
	{
		bst = new BinarySearchTree(new Alphabetical());
		bst.add("E");
		bst.add("C");
		bst.add("H");
		bst.add("A");
		bst.add("D");
		bst.add("F");
		bst.add("J");
		
		BSTIteratorReverse iterator = bst.iteratorReverse();
		assertEquals(true,iterator.hasNext());
		assertEquals("J",iterator.next());
		assertEquals("H",iterator.next());
		assertEquals("F",iterator.next());
		assertEquals("E",iterator.next());
		assertEquals("D",iterator.next());
		assertEquals("C",iterator.next());
		assertEquals("A",iterator.next());
		assertEquals(false,iterator.hasNext());
	}
	
	@Test
	public void testIteratorDecoratorVowel()
	{
		bst = new BinarySearchTree(new Alphabetical());
		bst.add("e");
		bst.add("C");
		bst.add("H");
		bst.add("A");
		bst.add("D");
		bst.add("o");
		bst.add("J");
		
		BSTIterator iterator = bst.iterator();
		IteratorDecoratorVowel decorator = new IteratorDecoratorVowel(iterator);
		assertEquals("A",decorator.next());
		assertEquals("e",decorator.next());
		assertEquals("o",decorator.next());
	}
	
	@Test
	public void testIteratorDecoratorCaps()
	{
		bst = new BinarySearchTree(new Alphabetical());
		bst.add("e");
		bst.add("c");
		bst.add("h");
		bst.add("a");
		bst.add("d");
		bst.add("o");
		bst.add("j");
		
		BSTIterator iterator = bst.iterator();
		IteratorDecoratorCaps decorator = new IteratorDecoratorCaps(iterator);
		assertEquals("A",decorator.next());
		assertEquals("C",decorator.next());
		assertEquals("D",decorator.next());
		assertEquals("E",decorator.next());
		assertEquals("H",decorator.next());
		assertEquals("J",decorator.next());
		assertEquals("O",decorator.next());
	}
	
	@Test
	public void testIteratorDecoratorMixed()
	{
		bst = new BinarySearchTree(new Alphabetical());
		bst.add("e");
		bst.add("c");
		bst.add("h");
		bst.add("a");
		bst.add("d");
		bst.add("o");
		bst.add("j");
		
		BSTIterator iterator = bst.iterator();
		IteratorDecoratorVowel decorVowel = new IteratorDecoratorVowel(iterator);
		IteratorDecoratorCaps decorMix = new IteratorDecoratorCaps(decorVowel);
		assertEquals("A",decorMix.next());
		assertEquals("E",decorMix.next());
		assertEquals("O",decorMix.next());
	}
}
