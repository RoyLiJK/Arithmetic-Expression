
public class Converter 
{
	  static String convertPost(String input) 
	  {
		  DynamicArrayStack<Character> converterStack = new DynamicArrayStack<Character>();
		  String output="";
		 
		  for(int i = 0; i < input.length(); i++) 
		  {		      
		      char ch = input.charAt(i);
		      int precidence = 0;
		      int StackPrecidence = 0;
		      
		      if(ch == '(' ) 
		      {
		        precidence = 0;
		      } 
		      if(ch == '+' || ch == '-' ) 
		      {
		        precidence = 1;
		      } 
		      else if(ch == '*' || ch == '/')
		      {
		        precidence = 2;
		      } 
		   
		      if(ch == '(' ) 
		      {
		    	  StackPrecidence = 0;
		      } 
		      if(!converterStack.isEmpty()) 
		      {
		        if(converterStack.top() == '+' || converterStack.top() == '-')
		        {
		          StackPrecidence = 1;
		        } 
		        else if(converterStack.top() == '*' || converterStack.top() == '/')
		        {
		        	StackPrecidence = 2;
		        }
		        
		      } 
		      
		      //reading in
		      
		      if(ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '(' || ch == ')')
		      {
		    	  
		    	  if(precidence >= StackPrecidence)
		    	  {
		    		  converterStack.push(ch);
		    	  }
		    	  else if(precidence <= StackPrecidence)
		    	  {		     		 		  
		    		  output = output + converterStack.pop();		    		
		    		  converterStack.push(ch);
		    		  
		    		  if(ch == '(')
		              {
		            	  converterStack.push(ch);
		              }
			    	          
		              if(ch == ')')
		              {	            	  
		            	  while(converterStack.top() != '(')
		            	  { 
		            		  output = output + converterStack.pop();
		            	  }
		            	  converterStack.pop();
		              }
		    	  }
		    	 
		      }
		      else 
		      {
		    	  output = output + ch;
		      }
		    	 
		      	     
	   }
	
		  while(!converterStack.isEmpty()) 
		  {  
		      output = output + converterStack.pop();   
		  } 		    
		   
		  return output;
		    
	 }
	  
	
}
