import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Project3 {
	public static void main(String args[]) throws FileNotFoundException {
		/*
		 * File file = new File("Project3.txt"); Scanner input = new
		 * Scanner(file);
		 * 
		 * while(input.hasNextLine()) { LinkedQueue<String> q = new
		 * LinkedQueue<String>(); String line = input.nextLine();
		 * 
		 * String post = Converter.convertPost(line);
		 * 
		 * String[] splited = post.split("\\s+");
		 * 
		 * for (int i = 0;i < splited.length; i++) { if(splited[i] != " ")
		 * q.enqueue(splited[i]);
		 */
		// }
		// }

		File file = new File("Project3.txt");
		Scanner input = new Scanner(file);

		while (input.hasNextLine()) {
			String line = input.nextLine();
			TreeCreation t = new TreeCreation();
			t.createTree(line);

			TreeEvaluation ev = new TreeEvaluation();
			ev.evaluation(t.createTree(line));
			
			System.out.println();
			System.out.println("-----------------------------------------------");
			System.out.println();
			// the Queue should now be EMPTY and stack should now contain only
			// ONE element ( one Binary tree )

		}

		input.close();

	}
}
