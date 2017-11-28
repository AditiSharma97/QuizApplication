import java.io.*;

public class QuestionDeletion
{
	void delete (long qid, FileNames fileNames, int typeOfQuestion)
	{
		FileReader fr;
		BufferedReader br;
		FileWriter fw;
		BufferedWriter bw;
		PrintWriter out;
		int [] qno = new int [3];
		
		String mcqFileName = fileNames.mcqFileName;
		String trueOrFalseFileName = fileNames.trueOrFalseFileName;
		String fillInTheBlanksFileName = fileNames.fillInTheBlanksFileName;
		String questionsInSubjectFileName = fileNames.questionsInSubjectFileName;
			

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
			System.out.println ("Exception found in QuestionDeletion class: " + e);
		}

		int no = qno[typeOfQuestion] % 100;	//computing number of questions in text file
		
		
		try
		{	
			if (typeOfQuestion == 0)
			{				
				fr = new FileReader (mcqFileName);
				br = new BufferedReader (fr);
				fw = new FileWriter (ApplicationProperties.getInstance().pathForFiles + "Sample.txt");
				bw = new BufferedWriter (fw);
				out = new PrintWriter (bw);
				MultipleChoiceQuestion mcq = new MultipleChoiceQuestion();
				int flag = 0;
				for (int j = 0; j < no; j++)
				{				
					mcq.qID = Long.parseLong(br.readLine());
					mcq.question = br.readLine();
					mcq.options [0] = br.readLine();
					mcq.options [1] = br.readLine();
					mcq.options [2] = br.readLine();
					mcq.options [3] = br.readLine();
					mcq.answer = Integer.parseInt(br.readLine());	

					if (qid == mcq.qID)	//if question id of question to be deleted has been found in the file
						flag = 1;

					else if (qid != mcq.qID)
					{					
						if (flag == 1)					
							out.println (mcq.qID - 1); 
						else
							out.println (mcq.qID);
						out.println (mcq.question);
						for (int i = 0; i < 4; i++)
							out.println (mcq.options[i]);
						out.println (mcq.answer);
					}
				}
				br.close();
				fr.close();
				out.close();
				bw.close();
				fw.close();

				fr = new FileReader (ApplicationProperties.getInstance().pathForFiles + "Sample.txt");
				br = new BufferedReader (fr);
				fw = new FileWriter (mcqFileName);
				bw = new BufferedWriter (fw);
				out = new PrintWriter (bw);
				String a = br.readLine();
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

			else if (typeOfQuestion == 1)
			{				
				fr = new FileReader (trueOrFalseFileName);
				br = new BufferedReader (fr);
				fw = new FileWriter (ApplicationProperties.getInstance().pathForFiles + "Sample.txt");
				bw = new BufferedWriter (fw);
				out = new PrintWriter (bw);
				TrueOrFalseQuestion tof = new TrueOrFalseQuestion();
				int flag = 0;
				for (int j = 0; j < no; j++)
				{				
					tof.qID = Long.parseLong(br.readLine());
					tof.question = br.readLine();
					tof.answer = (br.readLine().equalsIgnoreCase("True"))?true:false;
					if (qid == tof.qID)
						flag = 1;

					else if (qid != tof.qID)
					{					
						if (flag == 1)					
							out.println (tof.qID - 1); 
						else
							out.println (tof.qID);
						out.println (tof.question);
						out.println (tof.answer);
					}
				}
				br.close();
				fr.close();
				out.close();
				bw.close();
				fw.close();

				fr = new FileReader (ApplicationProperties.getInstance().pathForFiles + "Sample.txt");
				br = new BufferedReader (fr);
				fw = new FileWriter (trueOrFalseFileName);
				bw = new BufferedWriter (fw);
				out = new PrintWriter (bw);
				String a = br.readLine();
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
			

			else if (typeOfQuestion == 2)
			{				
				fr = new FileReader (fillInTheBlanksFileName);
				br = new BufferedReader (fr);
				fw = new FileWriter (ApplicationProperties.getInstance().pathForFiles + "Sample.txt");
				bw = new BufferedWriter (fw);
				out = new PrintWriter (bw);
				FillInTheBlanksQuestion fitb = new FillInTheBlanksQuestion();
				int flag = 0;
				for (int j = 0; j < no; j++)
				{				
					fitb.qID = Long.parseLong(br.readLine());
					fitb.question = br.readLine();
					
					fitb.answer = br.readLine();	

					if (qid == fitb.qID)
						flag = 1;

					else if (qid != fitb.qID)
					{					
						if (flag == 1)					
							out.println (fitb.qID - 1); 
						else
							out.println (fitb.qID);
						out.println (fitb.question);
						
						out.println (fitb.answer);
					}
				}
				br.close();
				fr.close();
				out.close();
				bw.close();
				fw.close();

				fr = new FileReader (ApplicationProperties.getInstance().pathForFiles + "Sample.txt");
				br = new BufferedReader (fr);
				fw = new FileWriter (fillInTheBlanksFileName);
				bw = new BufferedWriter (fw);
				out = new PrintWriter (bw);
				String a = br.readLine();
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
			

			fw = new FileWriter (questionsInSubjectFileName); 
			bw = new BufferedWriter (fw);
			for (int x = 0; x < 3; x++)
			{
				if (x == typeOfQuestion)
					bw.write (Integer.toString(qno[x]-1) + "\n");	//updating number of questions in text file
				else
					bw.write (Integer.toString(qno[x]) + "\n");
			}
			bw.close();
			fw.close();
		}	
		catch (Exception e)
		{
			System.out.println ("Exception found in QuestionDeletion class: " + e);
		}
		
	}
}
