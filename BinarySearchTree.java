/*
 * Bryan Tran
 * CS 635 Object-Oriented Design & Programming
 * Assignment 2
 */

import java.util.AbstractSet;
import java.util.ArrayList;

public class BinarySearchTree extends AbstractSet<String>
{	
	HeadNode root;
	Strategy strategy;
	// Tracks internal state of BST. Any change to content of BST will
	// increment this state. Prevents an iterator from operating once
	// the BST's state has changed since the iterator's inception.
	int state;
	int size;
	
	// If a strategy is not specified, default to Alphabetical.
	public BinarySearchTree()
	{
		strategy = new Alphabetical();
		root = new HeadNode(strategy);
		state = 0;
		size = 0;
	}
	
	public BinarySearchTree(Strategy strategy)
	{
		this.strategy = strategy;
		root = new HeadNode(strategy);
		state = 0;
		size = 0;
	}
	
	@Override
	public boolean add(String string)
	{
		if (string == null)
		{
			throw new NullPointerException("String value of node cannot be null");
		}
		state++;
		if (root.add(string))
		{
			size++;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	@Override
	public BSTIterator iterator()
	{
		BSTIterator iterator = new BSTIterator(this, state);
		return iterator;
	}
	
	public BSTIteratorReverse iteratorReverse()
	{
		BSTIteratorReverse iteratorReverse = new BSTIteratorReverse(this, state);
		return iteratorReverse;
	}
	
	@Override
	public int size()
	{
		return size;
	}
	
	@Override
	public String[] toArray()
	{
		ArrayList<String> arrayList = new ArrayList<String>();
		BSTIterator iterator = this.iterator();
		while (iterator.hasNext())
		{
			arrayList.add(iterator.next());
		}
		return arrayList.toArray(new String[0]);
	}
	
	@Override
	public String toString()
	{
		String output = "[";
		String[] stringArray = this.toArray();
		for (int i=0; i<stringArray.length; i++)
		{
			output = output + stringArray[i] + ", ";
		}
		// Remove trailing ", " from string.
		output = output.substring(0, output.length()-2);
		output = output + "]";
		return output;
	}
}
