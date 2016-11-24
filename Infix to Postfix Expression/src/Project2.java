import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Project2 
{
	public static void main(String args[]) throws FileNotFoundException
	{
		/*DynamicArrayStack<Integer> q = new DynamicArrayStack<Integer>();
		q.push(9);
		q.push(7);
		q.push(3);
		q.pop();
		q.push(6);
		q.push(5);
	System.out.println(q.size());*/
	
	File file = new File("Project2.txt");
    Scanner input = new Scanner(file);
    
    //Converter c = new Converter();
    
    while(input.hasNextLine()) 
    {
      String line = input.nextLine();
      System.out.println("Infix : " + line);
      String post = Converter.convertPost(line);
      System.out.println("PostFix: "+post +"\n");
      
    }
    
    input.close();
	}

}
