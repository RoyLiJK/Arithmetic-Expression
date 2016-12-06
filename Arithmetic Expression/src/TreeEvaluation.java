import java.util.Iterator;
import java.util.Scanner;

public class TreeEvaluation 
{
	
	public int evaluation(BinaryTree inputTree)
	{
		LinkedStack<Comparable> stack  = new LinkedStack ();	
		Iterator itr = inputTree.iterator();
	 
		while(itr.hasNext())
		{
			
			
			if(!isOperator(itr.next()))		
			{
				if(isInteger((int) itr.next()))
				{
					int result = Integer.parseInt((String) (itr.next()) );
					stack.push(result);
				}
				else // not integer
				{
					String input;
					 // Create a Scanner object for keyboard input.
				      Scanner keyboard = new Scanner(System.in);
				      
				      // Prompt the user for a number.
				      System.out.println("Please enter a number: ");			     
				      input = keyboard.nextLine();
				      stack.push(input);
				}
			}
			else // operator
			{
				int rightOperand = (int) stack.pop();
				int leftOperand = (int) stack.pop();
				int result = 0;
				if(itr.next().equals("+"))
				{
					result = leftOperand + rightOperand;
				}
				else if(itr.next().equals("-"))
				{
					result = leftOperand - rightOperand;
				}
				else if(itr.next().equals("*"))
				{
					result = leftOperand * rightOperand;
				}
				else if(itr.next().equals("/"))
				{
					result = leftOperand / rightOperand;
				}
				
				stack.push(result);
			}
			
		}
		return (int) stack.pop();
	
	}
	
	public boolean isInteger(int object)
	{
		if( object > 0 && object < 999)
		{
			return true;
		}
		return false;
	}
	
	public boolean isOperator(Object object)
	{
		if(object.equals("+") || object.equals("-") || object.equals("*") || object.equals("/") || object.equals("(") || object.equals(")"))
		{
			return true;
		}
		return false;
	}
}
