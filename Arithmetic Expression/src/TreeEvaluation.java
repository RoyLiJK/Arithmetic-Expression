import java.util.Iterator;
import java.util.Scanner;

public class TreeEvaluation<AnyType> 
{
/*	private static void printTree(BinaryTree tree)
	{
		Iterator i = tree.iterator();
		while(i.hasNext())
		{
			Object o = i.next();
			if(o instanceof BinaryTree)
			{
				printTree((BinaryTree) o);
			}
			else
			{
				System.out.println(o);
			}
		}
	}
	*/
	
	
	public int evaluation(BinaryTree inputTree)
	{
		LinkedStack stack  = new LinkedStack ();	
		
		
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
				System.out.println("this is the thing to be pass:  " + o );
					if(!isOperator(o))		
					{
						if(isInteger(o))
						{
							stack.push( (Integer) o);
							System.out.println("print test if is integer  " + o );
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
							
							System.out.println("push successful ");	
										      
							
						}
					}
					else // operator
					{
						int right =   (int) stack.pop();
						int left =   (int) stack.pop();
						int rightOperand = (int) right;
						int leftOperand = (int) left;
						int result = 0;
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
			
		return (int) stack.pop();
	}
	
	public boolean isInteger(Object o)
	{
		boolean parsable = true;
	    try{
	        Integer.parseInt((String) o);
	    }catch(NumberFormatException e){
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

