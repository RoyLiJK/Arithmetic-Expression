import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class Project3 {
	public static void main(String args[]) throws FileNotFoundException {
	
		

		File file = new File("Project3.txt"); // need to have a space between variable for it to run perfectly
		Scanner input = new Scanner(file);
		BinaryTree tree = new BinaryTree();
		while (input.hasNextLine())
		{
			String line = input.nextLine();
			TreeCreation t = new TreeCreation();
			TreeEvaluation ev = new TreeEvaluation();	
			ev.evaluation(t.createTree(line));
			System.out.println("-----------------------------------------------");
		}
		input.close();
	}
}
