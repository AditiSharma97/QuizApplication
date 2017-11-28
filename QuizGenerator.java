import java.io.*;
import java.util.*;
import java.lang.*;

class QuizGenerator
{
	static MultipleChoiceQuestion [] mcqarr = new MultipleChoiceQuestion [1];
	static TrueOrFalseQuestion [] tofarr = new TrueOrFalseQuestion [1];
	static FillInTheBlanksQuestion [] fitbarr = new FillInTheBlanksQuestion [1];
	static Question [] ques = new Question [1];	

	int numberOfQuestions;
		
	QuizGenerator (int no, int ch, int type, FileNames fileNames)  //ch = 0 for question set, ch = 1 for answer set
	{	
		numberOfQuestions = no;
		ques = new Question [no];	
		mcqarr = new MultipleChoiceQuestion [no];
		tofarr = new TrueOrFalseQuestion [no];
		fitbarr = new FillInTheBlanksQuestion [no];
		String questionsInSubjectFileName = fileNames.questionsInSubjectFileName;
		String fileName = new String ();
		int min = 0;
		switch (type)
		{
			case 0:		
				fileName = fileNames.mcqFileName;
				switch (UserInterface.subject)
				{
					case 0:
						min = 101;
						break;
					case 1:
						min = 401;
						break;
					case 2:
						min = 701;
						break;
				}
				break;
			case 1:
				fileName = fileNames.trueOrFalseFileName;
				switch (UserInterface.subject)
				{
					case 0:
						min = 201;
						break;
					case 1:
						min = 501;
						break;
					case 2:
						min = 801;
						break;
				}
				break;
			case 2:
				fileName = fileNames.fillInTheBlanksFileName;
				switch (UserInterface.subject)
				{
					case 0:
						min = 301;
						break;
					case 1:
						min = 601;
						break;
					case 2:
						min = 901;
						break;
				}
				break;
		}
		
		int randomNos [] = new int [no];
		
		int max;
		int [] qno = new int [3];
		
		try
		{			
			FileReader fr1 = new FileReader (questionsInSubjectFileName);
			BufferedReader br1 = new BufferedReader (fr1);
			for (int i = 0; i < 3; i++)
				qno[i] = Integer.parseInt(br1.readLine());
			br1.close();
			fr1.close();
		}
		catch (Exception e)
                {
                        System.out.println ("Exception found in QuizGenerator class: " + e);
		}

		try {
				max = qno[type];
				if (no > max % 100)
				{
					no = max % 100;
					numberOfQuestions = no;
				}
				final Random RANDOMISER = new Random();
				randomNos[0] = RANDOMISER.nextInt((max+1)-min)+min;
				int flag = 0;
				for (int i = 1; i < no; i++)
				{
					flag = 0;					
					int x = RANDOMISER.nextInt((max+1)-min)+min;
					int j;
					for (j = 0; j < i; j++)
					{
						if (x == randomNos[j])
						{
							flag = 1;
						}
					}
					if (flag == 1)
					{
						i--;
						continue;
					}
					if (j == i)
						randomNos[i] = x;
				}				
			
				FileReader fr = new FileReader (fileName);
				BufferedReader br = new BufferedReader (fr);
				String s [] = new String [no];
				for (int i = 0; i < no; i++)
					s[i] = Integer.toString(randomNos[i]);		
						
				int index = 0;
				
				if (type == 0)
				{
					MultipleChoiceQuestion mcq1;
					String a = br.readLine();
					while (a!=null)
					{
						mcq1 = new MultipleChoiceQuestion ();
						try {	
							mcq1.qID = Long.parseLong(a);	
							mcq1.question = br.readLine();
							mcq1.options [0] = br.readLine();
							mcq1.options [1] = br.readLine();
							mcq1.options [2] = br.readLine();
							mcq1.options [3] = br.readLine();
							mcq1.answer = Integer.parseInt(br.readLine());

							for (int j = 0; j < no; j++)
							{
								if (a.equals(s[j]))
								{	
									mcqarr[index] = new MultipleChoiceQuestion();
									mcqarr[index] = mcq1;
									index++;
								}
							}	
							a = br.readLine();	
						}
						catch (Exception e)
						{
							System.out.println ("Exception found in QuizGenerator class: " + e);
							System.exit(0);
						}
			
					}
					br.close();
					ques = mcqarr;
				}

				else if (type == 1)
				{
					TrueOrFalseQuestion tof;
					String a = br.readLine();
					while (a!=null)
					{
						tof = new TrueOrFalseQuestion ();
						try {	
							tof.qID = Long.parseLong(a);	
							tof.question = br.readLine();
							tof.answer = (br.readLine().equalsIgnoreCase("True"))?true:false;

							for (int j = 0; j < no; j++)
							{
								if (a.equals(s[j]))
								{	
									tofarr[index] = new TrueOrFalseQuestion();
									tofarr[index] = tof;
									index++;
								}
							}	
							a = br.readLine();	
						}
						catch (Exception e)
						{
							System.out.println ("Exception found in QuizGenerator class: " + e);
							System.exit(0);
						}
			
					}
					br.close();
					ques = tofarr;
				}	

				else if (type == 2)
				{
					FillInTheBlanksQuestion fitb;
					String a = br.readLine();
					while (a!=null)
					{
						fitb = new FillInTheBlanksQuestion ();
						try {	
							fitb.qID = Long.parseLong(a);	
							fitb.question = br.readLine();
							fitb.answer = br.readLine();
							for (int j = 0; j < no; j++)
							{
								if (a.equals(s[j]))
								{	
									fitbarr[index] = new FillInTheBlanksQuestion();
									fitbarr[index] = fitb;
									index++;
								}
							}							
							a = br.readLine();	
						}
						catch (Exception e)
						{
							System.out.println ("Exception found in QuizGenerator class: " + e);
							System.exit(0);
						}
			
					}
					br.close();
					ques = fitbarr;
				}		

			}
			catch (IOException ioe)
			{
				System.out.println ("Exception found in QuizGenerator class: " + ioe);
			}
	}

	Question [] returnQuestionsArray ()
	{	
		return ques;
	}
}
