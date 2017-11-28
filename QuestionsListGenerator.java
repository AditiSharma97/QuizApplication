import java.io.*;

public class QuestionsListGenerator
{
	int [] qno = new int [3];

	int returnNoOfQuestions (int type)
	{
		return qno[type];
	}

	Question [] returnList (FileNames fileNames, int type)
	{
		String mcqFileName = fileNames.mcqFileName;
		String trueOrFalseFileName = fileNames.trueOrFalseFileName;
		String fillInTheBlanksFileName = fileNames.fillInTheBlanksFileName;
		String questionsInSubjectFileName = fileNames.questionsInSubjectFileName;
			
		FileReader fr;
		BufferedReader br;
		
		Question [] q = new Question [1];
		try
		{		
			fr = new FileReader (questionsInSubjectFileName); 
			br = new BufferedReader (fr);


			for (int i = 0; i < 3; i++)
			{
				qno [i] = Integer.parseInt(br.readLine());
			}
		
			br.close();
			fr.close();
		}
		catch (Exception e)
		{
			System.out.println ("Exception found in QuestionsListGenerator class: " + e);
		}

		int no = qno[type]%100;		//computing number of questions in text file

		if (type == 0)
		{
			MultipleChoiceQuestion [] mcq1 = new MultipleChoiceQuestion [1];			
			try 
			{
				fr = new FileReader (mcqFileName);		
				br = new BufferedReader (fr);
				mcq1 = new MultipleChoiceQuestion [no];			

				String a = br.readLine();
				int i = 0;

				for (i = 0; i < (no); i++)
				{
					mcq1[i] = new MultipleChoiceQuestion ();			
					mcq1[i].qID = Long.parseLong(a);
					mcq1[i].question = br.readLine();
					mcq1[i].options [0] = br.readLine();
					mcq1[i].options [1] = br.readLine();
					mcq1[i].options [2] = br.readLine();
					mcq1[i].options [3] = br.readLine();
					mcq1[i].answer = Integer.parseInt(br.readLine());
					a = br.readLine();	
				}
			
				br.close();
				fr.close();
			}
			catch (Exception e)
			{
				System.out.println ("Exception found in QuestionsListGenerator class: " + e);
			}
			q = mcq1;
		}	

		else if (type == 1)
		{
			TrueOrFalseQuestion [] tof = new TrueOrFalseQuestion [1];			
			try 
			{
				fr = new FileReader (trueOrFalseFileName);	
				br = new BufferedReader (fr);
				tof = new TrueOrFalseQuestion [no];
		
				String a = br.readLine();	
				int i = 0;

				for (i = 0; i < (no); i++)
				{
					tof[i] = new TrueOrFalseQuestion ();			
					tof[i].qID = Long.parseLong(a);
					tof[i].question = br.readLine();
					tof[i].answer = (br.readLine().equalsIgnoreCase("True"))?true:false;	
					a = br.readLine();	
				}
			
				br.close();
				fr.close();
			}
			catch (Exception e)
			{
				System.out.println ("Exception found in QuestionsListGenerator class: " + e);
			}
			q = tof;
		}	

		if (type == 2)
		{
			FillInTheBlanksQuestion [] fitb = new FillInTheBlanksQuestion [1];			
			try 
			{
				fr = new FileReader (fillInTheBlanksFileName);
				br = new BufferedReader (fr);
				fitb = new FillInTheBlanksQuestion [no];

				String a = br.readLine();
				int i = 0;

				for (i = 0; i < (no); i++)
				{
					fitb[i] = new FillInTheBlanksQuestion ();			
					fitb[i].qID = Long.parseLong(a);
					fitb[i].question = br.readLine();
					fitb[i].answer = br.readLine();
					a = br.readLine();	
				}
			
				br.close();
				fr.close();
			}
			catch (Exception e)
			{
				System.out.println ("Exception found in QuestionsListGenerator class: " + e);
			}
			q = fitb;
		}	
	
		return q;

	}
}
