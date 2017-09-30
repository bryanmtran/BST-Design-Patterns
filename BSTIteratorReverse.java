import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class BSTIteratorReverse implements Iterator<String>
{
	private BinarySearchTree bst;
	private Node currentNode;
	private Stack<Node> stack;
	// Records state of BST at time of this iterator's creation.
	// Prevents this iterator from operating once
	// the BST's internal contents have been altered.
	private int bstCreatedState;
	
	public BSTIteratorReverse(BinarySearchTree bst, int bstState)
	{
		this.bst = bst;
		this.bstCreatedState = bstState;
		stack = new Stack<Node>();
		currentNode = bst.root;
		// Initialize stack - push root and keep iterating down right child pointers
		// until a null node is reached, pushing the non-null nodes into the stack
		// along the way.
		diveRightSubtree();
	}
	
	public boolean hasNext()
	{
		if (bstCreatedState != bst.state)
		{
			throw new IllegalStateException();
		}
		return (!stack.empty());
	}
	
	// Reverse In-order traversal through explicit recursion making use of a stack.
	public String next()
	{
		if (bstCreatedState != bst.state)
		{
			throw new IllegalStateException();
		}
		if (!hasNext())
		{
			throw new NoSuchElementException();
		}
		
		Node popped = stack.pop();
		if (!popped.left.isNull())
		{
			currentNode = popped.left;
			diveRightSubtree();
		}
		return popped.string;
	}
	
	private void diveRightSubtree()
	{
		while (!currentNode.isNull())
		{
			stack.push(currentNode);
			currentNode = currentNode.right;
		}
	}
}

