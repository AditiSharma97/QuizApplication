import java.io.*;

public class QuizExporter
{
	FileWriter fw;
	BufferedWriter bw;
	PrintWriter out;

	QuizExporter (Question [] questions, String fileName, int typeOfQuestion, int printSolutions)
	{
		
		try {
			fw = new FileWriter (fileName);
			bw = new BufferedWriter (fw);
			out = new PrintWriter (bw);

			int noOfQuestions = questions.length;

			for (int i = 0; i < noOfQuestions; i++)
			{
				out.println ((i+1) + ". " + questions[i].toString());
				if (printSolutions == 1)
					out.println ("Ans: " + questions[i].returnAnswer());
				out.println ("\n");
			}

			System.out.println ("File has been saved as " + fileName);
			out.close();
			bw.close();
			fw.close();
		}
		catch (Exception e)
		{
			System.out.println ("Exception found in QuizExporter class: " + e);
		}
	}
}
