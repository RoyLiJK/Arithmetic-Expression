
public class Converter 
{
	static String convertPost(String input) 
	{
		LinkedStack<Character> converterStack = new LinkedStack<Character>();
		String output = "";

		for (int i = 0; i < input.length(); i++)
		{
			char ch = input.charAt(i);
			int precidence = getPrecidence(ch);
			int StackPrecidence = 0;
			if (!converterStack.isEmpty())
			{
				StackPrecidence = getPrecidence(converterStack.top());

			}

			// reading in
			if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '(' || ch == ')')
			{
				if (ch == ')')
				{
					while (!converterStack.isEmpty() && converterStack.top() != '(') 
					{
						output = output + ' ' + converterStack.pop();
					}
					converterStack.pop();
				} 
				else if (precidence <= StackPrecidence) 
				{
					while (precidence <= StackPrecidence) 
					{
						if (converterStack.top() == '(') 
						{
							break;
						}
						output = output + ' ' + converterStack.pop();
						if (!converterStack.isEmpty()) 
						{
							StackPrecidence = getPrecidence(converterStack.top());
						} 
						else 
						{
							StackPrecidence = -1;
						}
					}
					converterStack.push(ch);

				} 
				else

				if (precidence > StackPrecidence) 
				{
					converterStack.push(ch);
				}
			} 
			else 
			{
				output = output + ch;
			}

		}

		while (!converterStack.isEmpty()) 
		{
			output = output + ' ' + converterStack.pop();
		}

		return output;

	}

	private static int getPrecidence(char ch) 
	{
		if (ch == '(' || ch == ')') 
		{
			return 3;
		}
		if (ch == '+' || ch == '-') 
		{
			return 1;
		} 
		else if (ch == '*' || ch == '/') 
		{
			return 2;
		}
		return 0;
	}

}
