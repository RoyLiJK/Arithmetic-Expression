import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TreeCreation 
{
	public BinaryTree createTree() throws FileNotFoundException
	{
		File file = new File("Project3.txt");
		Scanner input = new Scanner(file);
		LinkedStack<BinaryTree> stack  = new LinkedStack <BinaryTree>();
		
		while(input.hasNextLine()) 
		{
			LinkedQueue<String> q = new LinkedQueue<String>();
			String line = input.nextLine();
			
			String post = Converter.convertPost(line);			
      
			String[] splited = post.split("\\s+");
      
			for (int i = 0;i < splited.length; i++)
			{
				if(splited[i] != " ")
				q.enqueue(splited[i]);
			} 
			
			
			
			// now we have a Queue and a Stack to create Tree 
			
			while(!q.isEmpty())
			{				
				if(!isOperator(q.first()))
				{
					BinaryTree T = new BinaryTree(q.dequeue());
					stack.push(T);					
				}				
				else
				{
					BinaryTree T = new BinaryTree(q.dequeue());
					BinaryTree rightChild = new BinaryTree(stack.pop());
					BinaryTree leftChild = new BinaryTree(stack.pop());
					T.attach(leftChild, rightChild);
					stack.push(T);
				}
			
			}
			
			// the Queue should now be EMPTY  and  stack should now contain only ONE element ( one Binary tree )
			
		}
    
		input.close();
		return stack.pop();
		
	}




	@Override
	public String toString() {
		return "TreeCreation []";
	}




	public boolean isOperator(String string)
	{
		if(string.equals("+") || string.equals("-") || string.equals("*") || string.equals("/") || string.equals("(") || string.equals(")"))
		{
			return true;
		}
		return false;
	}
	
	
}
