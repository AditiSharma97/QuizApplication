import java.io.*;

public class QuestionSelector
{
	FileReader fr;
	BufferedReader br;
	int qno [] = new int [3];
	int noOfQuestions;
	String fileName;
	String questionsInSubjectFileName;

	Question select (FileNames fileNames, int typeOfQuestion, long qid) //returns the Question object corresponding to the qid selected
	{
		questionsInSubjectFileName = fileNames.questionsInSubjectFileName;
		
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
	
		Question q = new MultipleChoiceQuestion ();		
		try 
		{
			fr = new FileReader (questionsInSubjectFileName);
			br = new BufferedReader (fr);
			for (int i = 0; i < 3; i++)
				qno[i] = Integer.parseInt(br.readLine());
			br.close ();
			fr.close();
			
			noOfQuestions = qno[typeOfQuestion]%100;	//computing number of questions in text file

			fr = new FileReader (fileName);
			br = new BufferedReader (fr);

			String a = br.readLine();
		
			if (typeOfQuestion == 0)	//multiple choice question
			{
				MultipleChoiceQuestion mcq = new MultipleChoiceQuestion ();				
				while (a != null)
				{
					mcq.qID = Long.parseLong(a);
					mcq.question = br.readLine();
					mcq.options [0] = br.readLine();
					mcq.options [1] = br.readLine();
					mcq.options [2] = br.readLine();
					mcq.options [3] = br.readLine();
					mcq.answer = Integer.parseInt(br.readLine());
					a = br.readLine();
					if (mcq.qID == qid)
						break;
				}
				q = mcq;	
			}

			else if (typeOfQuestion == 1)	//true or false question
			{
				TrueOrFalseQuestion tof = new TrueOrFalseQuestion ();				
				while (a != null)
				{
					tof.qID = Long.parseLong(a);
					tof.question = br.readLine();
					tof.answer = (br.readLine().equalsIgnoreCase("True"))?true:false;
					a = br.readLine();
					if (tof.qID == qid)
						break;
				}
				q = tof;	
			}

			else if (typeOfQuestion == 2)	//fill in the blanks question
			{
				FillInTheBlanksQuestion fitb = new FillInTheBlanksQuestion ();				
				while (a != null)
				{
					fitb.qID = Long.parseLong(a);
					fitb.question = br.readLine();
					fitb.answer = br.readLine();
					a = br.readLine();
					if (fitb.qID == qid)
						break;
				}
				q = fitb;	
			}

			fr.close();
			br.close();
			

		}	
		catch (Exception e)
		{
			System.out.println ("Exception found in QuestionSelector class: " + e);
		}
		return q;	
	}
}
