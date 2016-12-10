import java.util.Iterator;

public class TreeCreation {

	public BinaryTree createTree(String formula) 
	{
		LinkedQueue<String> q = new LinkedQueue<String>();
		LinkedStack<BinaryTree> stack = new LinkedStack<BinaryTree>();

		String post = Converter.convertPost(formula);

		String[] splited = post.split("\\s+");

		for (int i = 0; i < splited.length; i++) 
		{
			if (splited[i] != " ")
				q.enqueue(splited[i]);
			
		}
		
		
		// now we have a Queue and a Stack to create Tree

		while (!q.isEmpty()) 
		{
			if (!isOperator(q.first())) 
			{
				BinaryTree T = new BinaryTree(q.dequeue());
				stack.push(T);
			} else {
				BinaryTree T = new BinaryTree(q.dequeue());
				BinaryTree rightChild = new BinaryTree(stack.pop());
				BinaryTree leftChild = new BinaryTree(stack.pop());
				T.attach(leftChild, rightChild);
				stack.push(T);
			}
			
		}
		return stack.pop();
	}

	
	

	public boolean isOperator(String string) {
		if (string.equals("+") || string.equals("-") || string.equals("*") || string.equals("/") || string.equals("(")
				|| string.equals(")")) {
			return true;
		}
		return false;
	}

	

}

