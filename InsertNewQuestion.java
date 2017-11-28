import java.io.*;

class InsertNewQuestion
{
	InsertNewQuestion (int subject, MultipleChoiceQuestion obj)
	{
		int type = 0;		
		try
		{
			FileWriter fw;	
			BufferedWriter bw;
			PrintWriter out;
			FileReader fr;
			BufferedReader br;		
			int [] qno = new int [3];
			String fileName;
			
			switch (subject)
			{
				case 0:		//if the subject chosen is English
					fileName = ApplicationProperties.getInstance().pathForFiles +
							ApplicationProperties.getInstance().questionsInEnglishFileName;
					
					fr = new FileReader (fileName);
					br = new BufferedReader (fr);
					for (int i = 0; i < 3; i++)
					{
						qno [i] = Integer.parseInt(br.readLine());

					}
					br.close();
					fr.close();

					if (type == 0)
					{
						fileName = ApplicationProperties.getInstance().pathForFiles +
								ApplicationProperties.getInstance().englishMCQFileName;
						
						fw = new FileWriter (fileName, true);
						bw = new BufferedWriter (fw);
						out = new PrintWriter (bw);

						obj.qID = ++qno[type];
						out.println (obj.qID); 
						out.println (obj.question);
						for (int i = 0; i < 4; i++)
							out.println (obj.options[i]);
						out.println (obj.answer);
						
						bw.close();
						fw.close();
					}
					
					fileName = ApplicationProperties.getInstance().pathForFiles +
							ApplicationProperties.getInstance().questionsInEnglishFileName;

					fw = new FileWriter (fileName);
					bw = new BufferedWriter (fw);
					for (int i = 0; i < 3; i++)
						bw.write (Integer.toString (qno[i]) + "\n");
					bw.close();
					fw.close();

					break;

				case 1:		//if the subject chosen is Mathematics
					
					fileName = ApplicationProperties.getInstance().pathForFiles +
							ApplicationProperties.getInstance().questionsInMathematicsFileName;

					fr = new FileReader (fileName);
					br = new BufferedReader (fr);
					for (int i = 0; i < 3; i++)
					{
						qno [i] = Integer.parseInt(br.readLine());

					}
					br.close();
					fr.close();

					if (type == 0)
					{				
						fileName = ApplicationProperties.getInstance().pathForFiles +
								ApplicationProperties.getInstance().mathematicsMCQFileName;

						fw = new FileWriter (fileName, true);
						bw = new BufferedWriter (fw);
						out = new PrintWriter (bw);

						obj.qID = ++qno[type];
						out.println (obj.qID); 
						out.println (obj.question);
						for (int i = 0; i < 4; i++)
							out.println (obj.options[i]);
						out.println (obj.answer);
						bw.close();
						fw.close();
					}

					fileName = ApplicationProperties.getInstance().pathForFiles +
							ApplicationProperties.getInstance().questionsInMathematicsFileName;

					fw = new FileWriter (fileName);
					bw = new BufferedWriter (fw);
					for (int i = 0; i < 3; i++)
						bw.write (Integer.toString (qno[i]) + "\n");
					bw.close();
					fw.close();
					break;

				case 2:		//if the subject chosen is General Knowledge
					
					fileName = ApplicationProperties.getInstance().pathForFiles +
							ApplicationProperties.getInstance().questionsInGeneralKnowledgeFileName;

					fr = new FileReader (fileName);
					br = new BufferedReader (fr);
					for (int i = 0; i < 3; i++)
					{
						qno [i] = Integer.parseInt(br.readLine());

					}
					br.close();
					fr.close();

					if (type == 0)
					{			
						fileName = ApplicationProperties.getInstance().pathForFiles +
								ApplicationProperties.getInstance().generalKnowledgeMCQFileName;

						fw = new FileWriter (fileName, true);
						bw = new BufferedWriter (fw);
						out = new PrintWriter (bw);

						obj.qID = ++qno[type];
						out.println (obj.qID); 
						out.println (obj.question);
						for (int i = 0; i < 4; i++)
							out.println (obj.options[i]);
						out.println (obj.answer);
						bw.close();
						fw.close();
					}

					fileName = ApplicationProperties.getInstance().pathForFiles +
							ApplicationProperties.getInstance().questionsInGeneralKnowledgeFileName;

					fw = new FileWriter (fileName);
					bw = new BufferedWriter (fw);
					for (int i = 0; i < 3; i++)
						bw.write (Integer.toString (qno[i]) + "\n");
					bw.close();
					fw.close();
			
					break;			
			}
		
		}
		catch (Exception e)
		{
			System.out.println ("Exception found in InsertNewQuestion class type 1 constructor: " + e);
		}
	}

	InsertNewQuestion (int subject, TrueOrFalseQuestion obj)
	{
		int type = 1;		
		try
		{
			FileWriter fw;	
			BufferedWriter bw;
			PrintWriter out;
			FileReader fr;
			BufferedReader br;		
			int [] qno = new int [3];
			String fileName;
			
			switch (subject)
			{
				case 0:		//if the subject chosen is English
					fileName = ApplicationProperties.getInstance().pathForFiles +
							ApplicationProperties.getInstance().questionsInEnglishFileName;

					fr = new FileReader (fileName);
					br = new BufferedReader (fr);
					for (int i = 0; i < 3; i++)
					{
						qno [i] = Integer.parseInt(br.readLine());
					}
					br.close();
					fr.close();

					if (type == 1)
					{
						fileName = ApplicationProperties.getInstance().pathForFiles +
								ApplicationProperties.getInstance().englishTrueOrFalseFileName;

						fw = new FileWriter (fileName, true);
						bw = new BufferedWriter (fw);
						out = new PrintWriter (bw);

						obj.qID = ++qno[type];
						out.println (obj.qID); 
						out.println (obj.question);
						out.println (obj.answer);
						
						bw.close();
						fw.close();
					}
					
					fileName = ApplicationProperties.getInstance().pathForFiles +
							ApplicationProperties.getInstance().questionsInEnglishFileName;

					fw = new FileWriter (fileName);
					bw = new BufferedWriter (fw);
					for (int i = 0; i < 3; i++)
						bw.write (Integer.toString (qno[i]) + "\n");
					bw.close();
					fw.close();

					break;

				case 1:		//if the subject chosen is Mathematics
					
					fileName = ApplicationProperties.getInstance().pathForFiles +
							ApplicationProperties.getInstance().questionsInMathematicsFileName;

					fr = new FileReader (fileName);
					br = new BufferedReader (fr);
					for (int i = 0; i < 3; i++)
					{
						qno [i] = Integer.parseInt(br.readLine());
					}
					br.close();
					fr.close();

					if (type == 1)
					{
						fileName = ApplicationProperties.getInstance().pathForFiles +
								ApplicationProperties.getInstance().mathematicsTrueOrFalseFileName;

						fw = new FileWriter (fileName, true);
						bw = new BufferedWriter (fw);
						out = new PrintWriter (bw);

						obj.qID = ++qno[type];
						out.println (obj.qID); 
						out.println (obj.question);
						out.println (obj.answer);
						bw.close();
						fw.close();
					}
				
					fileName = ApplicationProperties.getInstance().pathForFiles +
							ApplicationProperties.getInstance().questionsInMathematicsFileName;

					fw = new FileWriter (fileName);
					bw = new BufferedWriter (fw);
					for (int i = 0; i < 3; i++)
						bw.write (Integer.toString (qno[i]) + "\n");
					bw.close();
					fw.close();
					break;

				case 2:		//if the subject chosen is General Knowledge
					fileName = ApplicationProperties.getInstance().pathForFiles +
							ApplicationProperties.getInstance().questionsInGeneralKnowledgeFileName;

					fr = new FileReader (fileName);
					br = new BufferedReader (fr);
					for (int i = 0; i < 3; i++)
					{
						qno [i] = Integer.parseInt(br.readLine());
					}
					br.close();
					fr.close();

					if (type == 1)
					{
						fileName = ApplicationProperties.getInstance().pathForFiles +
								ApplicationProperties.getInstance().generalKnowledgeTrueOrFalseFileName;

						fw = new FileWriter (fileName, true);
						bw = new BufferedWriter (fw);
						out = new PrintWriter (bw);

						obj.qID = ++qno[type];
						out.println (obj.qID); 
						out.println (obj.question);
						out.println (obj.answer);
						bw.close();
						fw.close();
					}
					
					fileName = ApplicationProperties.getInstance().pathForFiles +
							ApplicationProperties.getInstance().questionsInGeneralKnowledgeFileName;

					fw = new FileWriter (fileName);
					bw = new BufferedWriter (fw);
					for (int i = 0; i < 3; i++)
						bw.write (Integer.toString (qno[i]) + "\n");
					bw.close();
					fw.close();
			
					break;			
			}
		
		}
		catch (Exception e)
		{
			System.out.println ("Exception found in InsertNewQuestion class type 2 constructor: " + e);
		}

	}

	InsertNewQuestion (int subject, FillInTheBlanksQuestion obj)
	{
		int type = 2;		
		try
		{
			FileWriter fw;	
			BufferedWriter bw;
			PrintWriter out;
			FileReader fr;
			BufferedReader br;		
			int [] qno = new int [3];
			String fileName;
			
			switch (subject)
			{
				case 0:		//if the subject chosen is English
					fileName = ApplicationProperties.getInstance().pathForFiles +
							ApplicationProperties.getInstance().questionsInEnglishFileName;

					fr = new FileReader (fileName);
					br = new BufferedReader (fr);
					for (int i = 0; i < 3; i++)
					{
						qno [i] = Integer.parseInt(br.readLine());
					}
					br.close();
					fr.close();

					if (type == 2)
					{
						fileName = ApplicationProperties.getInstance().pathForFiles +
								ApplicationProperties.getInstance().englishFillInTheBlanksFileName;

						fw = new FileWriter (fileName, true);
						bw = new BufferedWriter (fw);
						out = new PrintWriter (bw);

						obj.qID = ++qno[type];
						out.println (obj.qID); 
						out.println (obj.question);
						out.println (obj.answer);
						
						bw.close();
						fw.close();
					}
					
					fileName = ApplicationProperties.getInstance().pathForFiles +
							ApplicationProperties.getInstance().questionsInEnglishFileName;

					fw = new FileWriter (fileName);
					bw = new BufferedWriter (fw);
					for (int i = 0; i < 3; i++)
						bw.write (Integer.toString (qno[i]) + "\n");
					bw.close();
					fw.close();

					break;

				case 1:		//if the subject chosen is Mathematics
					
					fileName = ApplicationProperties.getInstance().pathForFiles +
							ApplicationProperties.getInstance().questionsInMathematicsFileName;

					fr = new FileReader (fileName);
					br = new BufferedReader (fr);
					for (int i = 0; i < 3; i++)
					{
						qno [i] = Integer.parseInt(br.readLine());
					}
					br.close();
					fr.close();

					if (type == 2)
					{
						fileName = ApplicationProperties.getInstance().pathForFiles +
								ApplicationProperties.getInstance().mathematicsFillInTheBlanksFileName;

						fw = new FileWriter (fileName, true);
						bw = new BufferedWriter (fw);
						out = new PrintWriter (bw);

						obj.qID = ++qno[type];
						out.println (obj.qID); 
						out.println (obj.question);
						out.println (obj.answer);

						bw.close();
						fw.close();
					}
				
					fileName = ApplicationProperties.getInstance().pathForFiles +
							ApplicationProperties.getInstance().questionsInMathematicsFileName;

					fw = new FileWriter (fileName);
					bw = new BufferedWriter (fw);
					for (int i = 0; i < 3; i++)
						bw.write (Integer.toString (qno[i]) + "\n");
					bw.close();
					fw.close();
					break;

				case 2:		//if the subject chosen is General Knowledge
					
					fileName = ApplicationProperties.getInstance().pathForFiles +
							ApplicationProperties.getInstance().questionsInGeneralKnowledgeFileName;

					fr = new FileReader (fileName);
					br = new BufferedReader (fr);
					for (int i = 0; i < 3; i++)
					{
						qno [i] = Integer.parseInt(br.readLine());
					}
					br.close();
					fr.close();

					if (type == 2)
					{
						fileName = ApplicationProperties.getInstance().pathForFiles +
								ApplicationProperties.getInstance().generalKnowledgeFillInTheBlanksFileName;

						fw = new FileWriter (fileName, true);
						bw = new BufferedWriter (fw);
						out = new PrintWriter (bw);

						obj.qID = ++qno[type];
						out.println (obj.qID); 
						out.println (obj.question);
						out.println (obj.answer);

						bw.close();
						fw.close();
					}
					
					fileName = ApplicationProperties.getInstance().pathForFiles +
							ApplicationProperties.getInstance().questionsInGeneralKnowledgeFileName;

					fw = new FileWriter (fileName);
					bw = new BufferedWriter (fw);
					for (int i = 0; i < 3; i++)
						bw.write (Integer.toString (qno[i]) + "\n");
					bw.close();
					fw.close();
			
					break;			
			}
		
		}
		catch (Exception e)
		{
			System.out.println ("Exception found in InsertNewQuestion class type 3 constructor: " + e);
		}
	}
}
