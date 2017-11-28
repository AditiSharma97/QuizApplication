import java.io.*;

public class FileModifier
{
	FileWriter fw;
	BufferedWriter bw;
	PrintWriter out;
	FileReader fr;
	BufferedReader br;

	FileModifier (Question q, FileNames fileNames, int typeOfQuestion)
	{
		String questionsInSubjectFileName = fileNames.questionsInSubjectFileName;
		String fileName = new String ();
		int qno [] = new int [3];
		long id = q.qID;
		
		switch (typeOfQuestion)
		{
			case 0:		
				fileName = fileNames.mcqFileName;
				break;
			case 1:
				fileName = fileNames.trueOrFalseFileName;
				break;
			case 2:
				fileName = fileNames.fillInTheBlanksFileName;
				break;
		}

		try
		{
			fr = new FileReader (questionsInSubjectFileName);
			br = new BufferedReader (fr);
			for (int i = 0; i < 3; i++)
				qno[i] = Integer.parseInt(br.readLine());
			br.close ();
			fr.close();
			
			int noOfQuestions = qno[typeOfQuestion]%100;	//computing number of questions in text file

			fr = new FileReader (fileName);
			br = new BufferedReader (fr);
			fw = new FileWriter (ApplicationProperties.getInstance().pathForFiles + "Sample.txt");
			bw = new BufferedWriter (fw);
			out = new PrintWriter (bw);

			String a = br.readLine();
			while (a != null)
			{
				MultipleChoiceQuestion mcq;
				TrueOrFalseQuestion tof;
				FillInTheBlanksQuestion fitb;

				if (typeOfQuestion == 0)	//multiple choice question
				{
					MultipleChoiceQuestion multiq = (MultipleChoiceQuestion) q;					
					mcq = new MultipleChoiceQuestion ();
					mcq.qID = Long.parseLong (a);
					mcq.question = br.readLine();
					for (int i = 0; i < 4; i++)
						mcq.options [i] = br.readLine();
					mcq.answer = Integer.parseInt(br.readLine());
					
					if (id == mcq.qID)
					{						
						out.println (multiq.qID);
						out.println (multiq.question);
						for (int i = 0; i < 4; i++)
							out.println (multiq.options[i]);
						out.println (multiq.answer);
					}
					else
					{					
						out.println (mcq.qID);
						out.println (mcq.question);
						for (int i = 0; i < 4; i++)
							out.println (mcq.options[i]);
						out.println (mcq.answer);
					}
				}

				else if (typeOfQuestion == 1)	//true or false question
				{
					TrueOrFalseQuestion tofq = (TrueOrFalseQuestion) q;					
					tof = new TrueOrFalseQuestion ();
					tof.qID = Long.parseLong (a);
					tof.question = br.readLine();
					tof.answer = (br.readLine().equalsIgnoreCase("True"))?true:false;
					
					if (id == tof.qID)
					{						
						out.println (tofq.qID);
						out.println (tofq.question);
						out.println (tofq.answer);
					}
					else
					{
						out.println (tof.qID);
						out.println (tof.question);
						out.println (tof.answer);
					}
				}
			
				else if (typeOfQuestion == 2)	//fill in the blanks question
				{
					FillInTheBlanksQuestion fitbq = (FillInTheBlanksQuestion) q;					
					fitb = new FillInTheBlanksQuestion ();
					fitb.qID = Long.parseLong (a);
					fitb.question = br.readLine();
					fitb.answer = br.readLine();
					
					if (id == fitb.qID)
					{						
						out.println (fitbq.qID);
						out.println (fitbq.question);
						out.println (fitbq.answer);
					}
					else
					{
						out.println (fitb.qID);
						out.println (fitb.question);
						out.println (fitb.answer);
					}
				}

				a = br.readLine();
			}

			
			br.close();
			fr.close();
			out.close();
			bw.close();
			fw.close();
		
			fr = new FileReader (ApplicationProperties.getInstance().pathForFiles + "Sample.txt");
			br = new BufferedReader (fr);
			fw = new FileWriter (fileName);
			bw = new BufferedWriter (fw);
			out = new PrintWriter (bw);
			a = br.readLine();
			while (a != null)
			{
				out.println (a);
				a = br.readLine();
			}
			
			br.close();
			fr.close();
			out.close();
			bw.close();
			fw.close();

			
		}
		catch (Exception e)
		{
			System.out.println ("Exception found in class FileModifier: " + e);
		}
	}
}
