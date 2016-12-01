import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Project2 
{
	public static void main(String args[]) throws FileNotFoundException
	{
		
	File file = new File("Project2.txt");
    Scanner input = new Scanner(file);
    
   
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
