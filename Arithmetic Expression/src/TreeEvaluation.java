import java.util.Iterator;
import java.util.Scanner;

public class TreeEvaluation<AnyType> 
{

	LinkedStack<Integer> stack  = new LinkedStack ();
	
	public void evaluation(BinaryTree inputTree)
	{
		int result = 0;
	
		Iterator i = inputTree.iterator();
		while(i.hasNext())
		{
			Object o = i.next();
			if(o instanceof BinaryTree)
			{
				evaluation((BinaryTree) o);
			}
			else
			{
				System.out.println("next variable from tree:  " + o );
					if(!isOperator(o))		
					{
						if(isInteger(o))
						{	
							int it = Integer.parseInt((String) o);
							stack.push(it);
						
						}
				
						else // not integer
						{
							int input;
							// Create a Scanner object for keyboard input.
							Scanner keyboard = new Scanner(System.in);
				      
							// Prompt the user for a number.
							System.out.println("Not an Integer, Please enter a number: ");			     
							input = keyboard.nextInt();
							stack.push(input);				     
						}											
					}
					else // operator
					{											
						int right =  (int) stack.pop();							
						int left =   (int) stack.pop();
						int rightOperand = (int) right;
						int leftOperand = (int) left;
						
						if(o.equals("+"))
						{
							result = leftOperand + rightOperand;
							
						}
						else if(o.equals("-"))
						{
							result = leftOperand - rightOperand;
							
						}
						else if(o.equals("*"))
						{
							result = leftOperand * rightOperand;
							
						}
						else if(o.equals("/"))
						{
							result = leftOperand / rightOperand;
							
						}
				
						stack.push(result);
					}
				}
			}
		System.out.println("calculating final number: " + result + "\n");
		
	}
	
	public boolean isInteger(Object o)
	{
		boolean parsable = true;
	    try{
	        Integer.parseInt((String) o);
	    }
	    catch(NumberFormatException e)
	    {
	        parsable = false;
	    }
	    return parsable;
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

