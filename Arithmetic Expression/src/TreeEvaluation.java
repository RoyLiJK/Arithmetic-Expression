import java.util.Iterator;
import java.util.Scanner;

public class TreeEvaluation<AnyType> 
{
	
	
	public int evaluation(BinaryTree<String> inputTree)
	{
		LinkedStack<Integer> stack  = new LinkedStack ();	
		
		Iterator<String> itr = inputTree.iterator();
	 
		while( itr.hasNext())
		{
			AnyType value =    (AnyType) itr.next();
			
			if(!isOperator(value))		
			{
				if(isInteger( value))
				{
					
					stack.push((Integer) value);
					System.out.println("print test if is integer  " + value );
				}
				
				else // not integer
				{
					Integer input;
					 // Create a Scanner object for keyboard input.
				      Scanner keyboard = new Scanner(System.in);
				      
				      // Prompt the user for a number.
				      System.out.println("Please enter a number: ");			     
				      input = keyboard.nextInt();
				      stack.push(input);
				      
				}
			}
			else // operator
			{
				AnyType right =   (AnyType) stack.pop();
				AnyType left =  (AnyType) stack.pop();
				int rightOperand = (int) right;
				int leftOperand = (int) left;
				int result = 0;
				if(value.equals("+"))
				{
					result = leftOperand + rightOperand;
				}
				else if(value.equals("-"))
				{
					result = leftOperand - rightOperand;
				}
				else if(value.equals("*"))
				{
					result = leftOperand * rightOperand;
				}
				else if(value.equals("/"))
				{
					result = leftOperand / rightOperand;
				}
				
				stack.push(result);
			}
			
		}
		return (int) stack.pop();
	
	}
	
	public boolean isInteger(AnyType value)
	{
		
			if(  value instanceof Integer )
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

