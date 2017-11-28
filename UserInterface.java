import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Properties;

class UserInterface implements ActionListener
{
	Frame f;	
	TextField loginField, passwordField;
	static int subject; //0 for english, 1 for mathematics, 2 for general knowledge	

	UserInterface ()
	{
		f = new Frame ("Quiz home page");
		f.setVisible (true);
		f.setLayout (null);
		f.setSize (500, 500);
		f.addWindowListener (new WCloser());

		Label l1 = new Label ("Welcome to quiz");
		l1.setBounds (50,50,200,30);
		f.add (l1);
		
		Label l2 = new Label ("\nUsername:");
		l2.setBounds (50,90,200,50);
		f.add(l2);

		loginField = new TextField (20);
		loginField.setBounds (50,150,200,30);
		f.add (loginField);

		Label l3 = new Label ("Password:");
		l3.setBounds (50,190,200,50);
		f.add(l3);

		passwordField = new TextField (20);
		passwordField.setEchoChar('*');
		passwordField.setBounds(50,250,200,30);
		f.add (passwordField);

		Button b1 = new Button ("Ok");
		b1.setBounds (50,300,100,30);
		b1.addActionListener (this);
		f.add (b1);
	}

	public void actionPerformed (ActionEvent e)
	{
		String userName = ApplicationProperties.getInstance().userName;
		String password = ApplicationProperties.getInstance().password;		

		if (loginField.getText().equals(userName) && passwordField.getText().equals(password))
		{
			f.setVisible (false);
			SelectSubject obj = new SelectSubject ();
		}
	}

	public static void main (String [] args)
	{
		loadSystemProperties();		
		new UserInterface ();
	}

	private static void loadSystemProperties() {
		Properties properties = new Properties();
		
		try {
			FileReader fileReader = new FileReader("/home/aditi/properties.txt");
			properties.load(fileReader);
			ApplicationProperties applicationProperties = ApplicationProperties.getInstance();

			applicationProperties.userName = properties.getProperty("userName");
			applicationProperties.password = properties.getProperty("password");

			applicationProperties.englishMCQFileName = properties.getProperty("englishMCQFileName");
			applicationProperties.englishTrueOrFalseFileName = properties.getProperty("englishTrueOrFalseFileName");
			applicationProperties.englishFillInTheBlanksFileName = properties.getProperty("englishFillInTheBlanksFileName");
			applicationProperties.questionsInEnglishFileName = properties.getProperty("questionsInEnglishFileName");
			
			applicationProperties.mathematicsMCQFileName = properties.getProperty("mathematicsMCQFileName");
			applicationProperties.mathematicsTrueOrFalseFileName = properties.getProperty("mathematicsTrueOrFalseFileName");
			applicationProperties.mathematicsFillInTheBlanksFileName = properties.getProperty("mathematicsFillInTheBlanksFileName");
			applicationProperties.questionsInMathematicsFileName = properties.getProperty("questionsInMathematicsFileName");
			
			applicationProperties.generalKnowledgeMCQFileName = properties.getProperty("generalKnowledgeMCQFileName");
			applicationProperties.generalKnowledgeTrueOrFalseFileName = properties.getProperty("generalKnowledgeTrueOrFalseFileName");
			applicationProperties.generalKnowledgeFillInTheBlanksFileName = properties.getProperty("generalKnowledgeFillInTheBlanksFileName");
			applicationProperties.questionsInGeneralKnowledgeFileName = properties.getProperty("questionsInGeneralKnowledgeFileName");
			
			applicationProperties.pathForFiles = properties.getProperty("pathForFiles");
			
			fileReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 

	}

}


class SelectSubject implements ActionListener
{
	Frame f;
	Choice c;
	
	SelectSubject ()
	{
		f = new Frame ("Select subject");
		f.setVisible (true);
		f.setLayout (new FlowLayout ());
		f.setSize (300, 300);
		f.addWindowListener (new WCloser());

		Label l = new Label ("Choose subject");
		f.add (l);

		c = new Choice ();
		c.add ("English");
		c.add("Mathematics");
		c.add ("General knowledge");
		f.add (c);

		Button b = new Button ("Ok");
		b.addActionListener (this);
		f.add (b);
		
	}

	public void actionPerformed (ActionEvent event)
	{
		f.setVisible (false);	
		UserInterface.subject = c.getSelectedIndex();	
		SelectFunctionality obj = new SelectFunctionality ();
	}	
}

class SelectFunctionality implements ActionListener
{
	Frame f;

	SelectFunctionality ()
	{
		f = new Frame ("Select functionality");
		f.setVisible (true);
		f.setLayout (new FlowLayout ());
		f.setSize (300, 300);
		f.addWindowListener (new WCloser());

		Button insertButton = new Button ("Insert");
		insertButton.addActionListener (new ActionListener ()
		{
			public void actionPerformed (ActionEvent event)
			{
				insertButtonActionPerformed();
			}
		});
		f.add (insertButton);		

		Button modifyButton = new Button ("Modify");
		modifyButton.addActionListener (new ActionListener ()
		{
			public void actionPerformed (ActionEvent event)
			{
				modifyButtonActionPerformed();
			}
		});
		f.add(modifyButton);

		Button deleteButton = new Button ("Delete");
		deleteButton.addActionListener (new ActionListener ()
		{
			public void actionPerformed (ActionEvent event)
			{
				deleteButtonActionPerformed();
			}
		});
		f.add(deleteButton);	

		Button generateTestButton = new Button ("Generate test");
		generateTestButton.addActionListener (new ActionListener ()
		{
			public void actionPerformed (ActionEvent event)
			{
				generateButtonActionPerformed();
			}
		});
		f.add (generateTestButton);

		Button back = new Button ("Go back");
		back.addActionListener(this);
		f.add(back);
	}

	public void actionPerformed (ActionEvent event)
	{
		f.setVisible(false);
		SelectSubject obj = new SelectSubject();
	}

	private void insertButtonActionPerformed ()
	{
		f.setVisible (false);
		InsertQuestion obj = new InsertQuestion();	
	}

	private void modifyButtonActionPerformed ()
	{
		f.setVisible (false);
		Modify obj = new Modify();	
	}

	private void deleteButtonActionPerformed ()
	{
		f.setVisible (false);
		Delete obj = new Delete();
	}

	private void generateButtonActionPerformed ()
	{
		f.setVisible (false);
		GenerateTest obj = new GenerateTest ();
	}
}
class InsertQuestion implements ActionListener
{
	Frame f;
	Choice c;

	InsertQuestion ()
	{
		f = new Frame ("Insert question");
		f.setVisible (true);
		f.setLayout (new FlowLayout ());
		f.setSize (300, 300);
		f.addWindowListener (new WCloser());

		Label l = new Label ("Choose the type of question to be inserted");
		f.add (l);

		c = new Choice();
		c.add("Multiple choice question");
		c.add("True/False question");
		c.add("Fill in the blanks question");
		f.add(c);

		Button b = new Button ("Ok");
		b.addActionListener (this);
		f.add(b);

		Button back = new Button ("Go back");
		back.addActionListener (this);
		f.add(back);
	}

	public void actionPerformed (ActionEvent event)
	{
		f.setVisible (false);
		if (event.getActionCommand().equals("Go back"))
		{
			SelectFunctionality obj = new SelectFunctionality ();
		}
		else
		{
			int type = c.getSelectedIndex();
			InsertMCQ obj1;
			InsertTrueOrFalse obj2;
			InsertFillInTheBlanks obj3;
			if (type == 0)
				obj1 = new InsertMCQ ();	
			else if (type == 1)
				obj2 = new InsertTrueOrFalse ();
			else if (type == 2)
				obj3 = new InsertFillInTheBlanks ();
		}
	}
}

class InsertMCQ implements ActionListener
{
	Frame f;
	TextField ques;
	TextField c1;
	TextField c2;
	TextField c3;
	TextField c4;
	Choice ans;
	String [] options = new String [4];
	
	InsertMCQ ()
	{
		f = new Frame ("Insert multiple choice question");
		f.setVisible (true);
		f.setLayout (new FlowLayout ());
		f.setSize (300, 300);
		f.addWindowListener (new WCloser());

		Label l1 = new Label ("Enter question");
		f.add (l1);
	
		ques = new TextField (20);
		f.add(ques);
		
		Label l2 = new Label ("Enter four options");
		f.add (l2);

		c1 = new TextField (20);
		c2 = new TextField (20);
		c3 = new TextField (20);
		c4 = new TextField (20);
		f.add(c1);
		f.add(c2);
		f.add(c3);
		f.add(c4);

		Label l3 = new Label ("Select option number that is the right answer");
		f.add(l3);

		ans = new Choice ();
		ans.add("1");
		ans.add("2");
		ans.add("3");
		ans.add("4");
		f.add(ans);

		Button b = new Button ("Add question");
		b.addActionListener (this);
		f.add(b);

		Button back = new Button ("Go back");
		back.addActionListener (this);
		f.add(back);
	}

	public void actionPerformed (ActionEvent event)
	{
		f.setVisible(false);
		InsertQuestion obj1;
		MultipleChoiceQuestion obj;
		if (event.getActionCommand().equals("Go back"))
			obj1 = new InsertQuestion();
		else
		{
			obj = new MultipleChoiceQuestion ();
			obj.question = ques.getText();
			obj.options[0] = c1.getText();
			obj.options[1] = c2.getText();
			obj.options[2] = c3.getText();
			obj.options[3] = c4.getText();
			obj.answer = ans.getSelectedIndex();
			InsertNewQuestion inq = new InsertNewQuestion (UserInterface.subject, obj);
			SelectFunctionality sf = new SelectFunctionality ();
		}
	}
}

class InsertTrueOrFalse implements ActionListener, ItemListener
{
	Frame f;
	TextField ques;
	CheckboxGroup cbg;
	Checkbox t;
	Checkbox fal;
	boolean ans;
	
	InsertTrueOrFalse ()
	{
		f = new Frame ("Insert true or false question");
		f.setVisible (true);
		f.setLayout (new FlowLayout ());
		f.setSize (300, 300);
		f.addWindowListener (new WCloser());

		Label l1 = new Label ("Enter question");
		f.add (l1);
	
		ques = new TextField (20);
		f.add(ques);
		

		Label l3 = new Label ("Select right answer");
		f.add(l3);

		cbg = new CheckboxGroup ();
		t = new Checkbox ("True", cbg, false);
		fal= new Checkbox ("False", cbg, false);
		t.addItemListener (this);
		fal.addItemListener (this);
		f.add(t);
		f.add(fal);
		

		Button b = new Button ("Add question");
		b.addActionListener (this);
		f.add(b);

		Button back = new Button ("Go back");
		back.addActionListener (this);
		f.add(back);
	}

	public void actionPerformed (ActionEvent event)
	{
		f.setVisible(false);
		InsertQuestion obj1;	
		TrueOrFalseQuestion obj;
		if (event.getActionCommand().equals("Go back"))
			obj1 = new InsertQuestion();
		else
		{		
			obj = new TrueOrFalseQuestion ();
			obj.question = ques.getText();
			obj.answer = ans;
			InsertNewQuestion inq = new InsertNewQuestion (UserInterface.subject, obj);
			SelectFunctionality sf = new SelectFunctionality ();
		}			
	}

	public void itemStateChanged (ItemEvent ie)
	{
		if (t.getState() == true)
			ans = true;
		else if (fal.getState() == true)
			ans = false;
	}
}

class InsertFillInTheBlanks implements ActionListener
{
	Frame f;
	TextField ques1;
	TextField ques2;
	TextField ans;
	
	InsertFillInTheBlanks ()
	{
		f = new Frame ("Insert fill in the blanks question");
		f.setVisible (true);
		f.setLayout (new FlowLayout ());
		f.setSize (300, 300);
		f.addWindowListener (new WCloser());

		Label l1 = new Label ("Enter question");
		f.add (l1);
	
		ques1 = new TextField (20);
		f.add(ques1);
		
		Label l2 = new Label ("_____");
		f.add (l2);

		ques2 = new TextField (20);
		f.add(ques2);

		Label l3 = new Label ("Enter right answer");
		f.add(l3);

		ans = new TextField (20);
		f.add(ans);

		Button b = new Button ("Add question");
		b.addActionListener (this);
		f.add(b);

		Button back = new Button ("Go back");
		back.addActionListener (this);
		f.add(back);
	}

	public void actionPerformed (ActionEvent event)
	{
		f.setVisible(false);
		InsertQuestion obj1;
		FillInTheBlanksQuestion obj;
		if (event.getActionCommand().equals("Go back"))
			obj1 = new InsertQuestion();
		else
		{		
			obj = new FillInTheBlanksQuestion ();
			if (!(ques1.getText().equals("")) && !(ques2.getText().equals("")))
				obj.question = ques1.getText() + " _____ " + ques2.getText();
			else if (!(ques1.getText().equals("")) && ques2.getText().equals(""))
				obj.question = ques1.getText() + " _____";
			else if (ques1.getText().equals("") && !(ques2.getText().equals("")))
				obj.question = "_____ " + ques2.getText();	
			obj.answer = ans.getText();
			InsertNewQuestion inq = new InsertNewQuestion (UserInterface.subject, obj);
			SelectFunctionality sf = new SelectFunctionality();
		}	
	}
}

class Modify implements ActionListener
{
	Frame f;
	Choice c;
	
	Modify ()
	{
		f = new Frame ("Modify");
		f.setVisible (true);
		f.setLayout (new FlowLayout ());
		f.setSize (300, 300);
		f.addWindowListener (new WCloser());

		Label l1 = new Label ("Select items you wish to modify");
		f.add(l1);

		c = new Choice ();
		c.add("Multiple choice question");
		c.add("True/False question");
		c.add("Fill in the blanks question");
		f.add(c);

		Button b = new Button ("Ok");
		b.addActionListener(this);
		f.add(b);

		Button btnGoBack = new Button ("Go back");
		btnGoBack.addActionListener (this);
		f.add(btnGoBack);
	}

	public void actionPerformed (ActionEvent event)
	{
		f.setVisible (false);
		if (event.getActionCommand().equals("Go back"))
		{
			SelectFunctionality obj = new SelectFunctionality();
		}
		else
		{		
			int choice = c.getSelectedIndex();
			Generate obj = new Generate (choice, 0);
		}
	}
}

class Delete implements ActionListener
{
	Frame f;
	Choice c;

	Delete ()
	{
		f = new Frame ("Delete");
		f.setVisible (true);
		f.setLayout (new FlowLayout ());
		f.setSize (300, 300);
		f.addWindowListener (new WCloser());

		Label l = new Label ("Select type of question to be deleted");
		f.add(l);

		c = new Choice ();
		c.add("Multiple choice question");
		c.add("True/False question");
		c.add("Fill in the blanks question");
		f.add(c);

		Button b = new Button ("Ok");
		b.addActionListener(this);
		f.add(b);

		Button btnGoBack = new Button ("Go back");
		btnGoBack.addActionListener (this);
		f.add(btnGoBack);
	}

	public void actionPerformed (ActionEvent event)
	{
		f.setVisible(false);
		if (event.getActionCommand().equals("Go back"))
		{
			SelectFunctionality obj = new SelectFunctionality ();
		}		
		else
		{
			int choice = c.getSelectedIndex();
			Generate obj = new Generate (choice, 1);
		}	
	}
}


class Generate implements ActionListener
{
	Frame f;
	TextField t;
	boolean [] state;
	int x, i;
	int index;
	long id;
	int option;
	int ch;
	Dialog d;
		
	Generate (int choice, int opt)
	{
		QuestionsListGenerator obj = new QuestionsListGenerator ();
		option = opt;
		ch = choice;
		Question [] q = new Question [1];

		FileNames fileNames = new FileNames();

		switch (UserInterface.subject) {
		case 0:
			fileNames.mcqFileName = ApplicationProperties.getInstance().pathForFiles
					+ ApplicationProperties.getInstance().englishMCQFileName;
			fileNames.fillInTheBlanksFileName = ApplicationProperties.getInstance().pathForFiles
					+ ApplicationProperties.getInstance().englishFillInTheBlanksFileName;
			fileNames.trueOrFalseFileName = ApplicationProperties.getInstance().pathForFiles
					+ ApplicationProperties.getInstance().englishTrueOrFalseFileName;
			fileNames.questionsInSubjectFileName = ApplicationProperties.getInstance().pathForFiles
					+ ApplicationProperties.getInstance().questionsInEnglishFileName;

			break;
		case 1:
			fileNames.mcqFileName = ApplicationProperties.getInstance().pathForFiles
					+ ApplicationProperties.getInstance().mathematicsMCQFileName;
			fileNames.fillInTheBlanksFileName = ApplicationProperties.getInstance().pathForFiles
					+ ApplicationProperties.getInstance().mathematicsFillInTheBlanksFileName;
			fileNames.trueOrFalseFileName = ApplicationProperties.getInstance().pathForFiles
					+ ApplicationProperties.getInstance().mathematicsTrueOrFalseFileName;
			fileNames.questionsInSubjectFileName = ApplicationProperties.getInstance().pathForFiles
					+ ApplicationProperties.getInstance().questionsInMathematicsFileName;

			break;
		case 2:
			fileNames.mcqFileName = ApplicationProperties.getInstance().pathForFiles
					+ ApplicationProperties.getInstance().generalKnowledgeMCQFileName;
			fileNames.fillInTheBlanksFileName = ApplicationProperties.getInstance().pathForFiles
					+ ApplicationProperties.getInstance().generalKnowledgeFillInTheBlanksFileName;
			fileNames.trueOrFalseFileName = ApplicationProperties.getInstance().pathForFiles
					+ ApplicationProperties.getInstance().generalKnowledgeTrueOrFalseFileName;
			fileNames.questionsInSubjectFileName = ApplicationProperties.getInstance().pathForFiles
					+ ApplicationProperties.getInstance().questionsInGeneralKnowledgeFileName;
			break;
		}

		q = obj.returnList (fileNames, choice);
		

		f = new Frame ("Select question");
		f.setVisible (true);
		f.setLayout (new FlowLayout());
		f.setSize (500, 500);
		f.addWindowListener (new WCloser());
	
		Label l1 = new Label ("Type the question ID of the question you want to select");
		//l1.setBounds (50,50,500,30);
		f.add(l1);
		
		x = obj.returnNoOfQuestions (choice) % 100;

		TextArea text = new TextArea ("");
		//Label l2;
		//int y = 100;
		for (i = 0; i < x; i++)
		{
			text.append(q[i].qID + ": " + q[i].question + "\n");
			//l2 = new Label (q[i].qID + ": " + q[i].question);
			//l2.setBounds (50,y,700,30);
			//f.add(l2);
			//y = y + 40;
		}
		f.add(text);

		t = new TextField (20);
		//t.setBounds (50,y,70,30);
		f.add(t);		
		//y = y + 40;		

		Button b = new Button ("Ok");
		//b.setBounds (50,y,70,30);
		b.addActionListener (this);
		f.add (b);
		//y = y + 40;
	
		Button btnGoBack = new Button ("Go back");
		//btnGoBack.setBounds (50,y,70,30);
		btnGoBack.addActionListener (this);
		f.add(btnGoBack);
	}

	public void actionPerformed (ActionEvent event)
	{
		
			f.setVisible(false);
			if (event.getActionCommand().equals("Go back"))
			{
				Modify obj1;
				Delete obj2;				
				if (option == 0)				
					obj1 = new Modify ();
				else 
					obj2 = new Delete ();
			}
			else
			{
				id = Long.parseLong(t.getText());
				QuestionDeletion obj = new QuestionDeletion ();
				QuestionSelector sel = new QuestionSelector ();
				MultipleChoiceQuestion mcq = new MultipleChoiceQuestion ();
				Question q;
				FileNames fileNames = new FileNames();

				switch (UserInterface.subject) {
				case 0:
					fileNames.mcqFileName = ApplicationProperties.getInstance().pathForFiles
							+ ApplicationProperties.getInstance().englishMCQFileName;
					fileNames.fillInTheBlanksFileName = ApplicationProperties.getInstance().pathForFiles
							+ ApplicationProperties.getInstance().englishFillInTheBlanksFileName;
					fileNames.trueOrFalseFileName = ApplicationProperties.getInstance().pathForFiles
							+ ApplicationProperties.getInstance().englishTrueOrFalseFileName;
					fileNames.questionsInSubjectFileName = ApplicationProperties.getInstance().pathForFiles
							+ ApplicationProperties.getInstance().questionsInEnglishFileName;

					break;
				case 1:
					fileNames.mcqFileName = ApplicationProperties.getInstance().pathForFiles
							+ ApplicationProperties.getInstance().mathematicsMCQFileName;
					fileNames.fillInTheBlanksFileName = ApplicationProperties.getInstance().pathForFiles
							+ ApplicationProperties.getInstance().mathematicsFillInTheBlanksFileName;
					fileNames.trueOrFalseFileName = ApplicationProperties.getInstance().pathForFiles
							+ ApplicationProperties.getInstance().mathematicsTrueOrFalseFileName;
					fileNames.questionsInSubjectFileName = ApplicationProperties.getInstance().pathForFiles
							+ ApplicationProperties.getInstance().questionsInMathematicsFileName;

					break;
				case 2:
					fileNames.mcqFileName = ApplicationProperties.getInstance().pathForFiles
							+ ApplicationProperties.getInstance().generalKnowledgeMCQFileName;
					fileNames.fillInTheBlanksFileName = ApplicationProperties.getInstance().pathForFiles
							+ ApplicationProperties.getInstance().generalKnowledgeFillInTheBlanksFileName;
					fileNames.trueOrFalseFileName = ApplicationProperties.getInstance().pathForFiles
							+ ApplicationProperties.getInstance().generalKnowledgeTrueOrFalseFileName;
					fileNames.questionsInSubjectFileName = ApplicationProperties.getInstance().pathForFiles
							+ ApplicationProperties.getInstance().questionsInGeneralKnowledgeFileName;
					break;
				}

				if (option == 0)
				{
					q = sel.select(fileNames, ch, id);
					UserModifyQuestion umq = new UserModifyQuestion (q, ch, fileNames);
				}
				else if (option == 1)
				{
					obj.delete (id, fileNames, ch);
					SelectFunctionality select = new SelectFunctionality();
				}

			}
	}
}

class UserModifyQuestion implements ActionListener
{
	Frame f;
	TextField questionTextField;
	TextField opt1, opt2, opt3, opt4;
	TextField answerTextField;
	Button submit;
	int typeOfQuestion;
	FileNames fileNames;
	long id;

	UserModifyQuestion (Question ques, int typeOfQuestion, FileNames fnames)
	{
		this.typeOfQuestion = typeOfQuestion;
		fileNames = fnames;		
		id = ques.qID;		
		f = new Frame ("Modify question");
		f.setVisible (true);
		f.setLayout (null);
		f.setSize (600, 600);
		f.addWindowListener (new WCloser());

		Label l1 = new Label ("Modify any part of the question or answer and click on 'Submit' button");
		l1.setBounds (50,50,500,30);
		f.add(l1);

		int y = 80;
		questionTextField = new TextField (ques.question, 50);
		questionTextField.setBounds(50,y,500,30);
		f.add(questionTextField);
		y = y+30;
	
		if (typeOfQuestion == 0)
		{
			MultipleChoiceQuestion mcq = (MultipleChoiceQuestion) ques;
			opt1 = new TextField (mcq.options[0], 50);
			opt1.setBounds (50,y,500,30);
			y = y + 30;
			opt2 = new TextField (mcq.options[1], 50);
			opt2.setBounds (50,y,500,30);
			y = y + 30;
			opt3 = new TextField (mcq.options[2], 50);
			opt3.setBounds (50,y,500,30);
			y = y + 30;
			opt4 = new TextField (mcq.options[3], 50);
			opt4.setBounds (50,y,500,30);
			y = y + 30;	
			f.add(opt1);
			f.add(opt2);
			f.add(opt3);
			f.add(opt4);
		}

		answerTextField = new TextField (ques.returnAnswer(), 50);
		answerTextField.setBounds(50,y,500,30);
		y = y + 40;
		f.add(answerTextField);	

		Button submit = new Button ("Submit");
		submit.setBounds(50,y,70,30);
		y = y + 30;
		submit.addActionListener(this);
		f.add(submit);
		
		Button btnGoBack = new Button ("Go back");
		btnGoBack.setBounds(50,y,70,30);
		btnGoBack.addActionListener(this);
		f.add(btnGoBack);
	}

	public void actionPerformed (ActionEvent event)
	{
		f.setVisible(false);	
		if (event.getActionCommand().equals("Go back"))
		{
			Generate obj = new Generate (typeOfQuestion, 0);
		}
		else
		{	
			String ques = questionTextField.getText();
			String [] optionsArray = new String [4];	
			if (typeOfQuestion == 0)
			{
				optionsArray[0] = opt1.getText();
				optionsArray[1] = opt2.getText();
				optionsArray[2] = opt3.getText();
				optionsArray[3] = opt4.getText();
			}
			String ans = answerTextField.getText();
			MultipleChoiceQuestion mcq;
			TrueOrFalseQuestion tof;
			FillInTheBlanksQuestion fitb;
			FileModifier mod;
			if (typeOfQuestion == 0)
			{
				mcq = new MultipleChoiceQuestion ();
				mcq.qID = id;			
				mcq.question = ques;
				for (int i = 0; i < 4; i++)
					mcq.options[i] = optionsArray[i];
				mcq.answer = (Integer.parseInt (ans)) - 1;
				mod = new FileModifier (mcq, fileNames, typeOfQuestion);
			}
			else if (typeOfQuestion == 1)
			{
				tof = new TrueOrFalseQuestion();
				tof.qID = id;	
				tof.question = ques;
				tof.answer = Boolean.parseBoolean (ans);
				mod = new FileModifier (tof, fileNames, typeOfQuestion); 
			}
			else if (typeOfQuestion == 2)
			{
				fitb = new FillInTheBlanksQuestion ();
				fitb.qID = id;
				fitb.question = ques;
				fitb.answer = ans;
				mod = new FileModifier (fitb, fileNames, typeOfQuestion);
			}
                        SelectFunctionality sf = new SelectFunctionality();
		}
	}
}

class GenerateTest implements ActionListener, ItemListener
{
	Frame f, f1;
	TextField no;
	CheckboxGroup cbg1;
	Checkbox c1;
	Checkbox c2;
	Choice c;
	int ch;
	int type;
	int numberOfQuestions;
	TextField fileName;
		
	GenerateTest ()
	{
		f = new Frame ();
		f.setVisible (true);
		f.setLayout (new FlowLayout ());
		f.setSize (380, 380);
		f.addWindowListener (new WCloser());

		Label l1 = new Label ("Choose what type of test you wish to view:");
		f.add (l1);

		cbg1 = new CheckboxGroup ();
		c1 = new Checkbox("Question set", cbg1, false);
		c2 = new Checkbox("Solution set", cbg1, false);
		c1.addItemListener(this);
		c2.addItemListener(this);
		f.add (c1);
		f.add(c2);

		c = new Choice();
		c.add("Multiple choice question");
		c.add("True/False question");
		c.add("Fill in the blanks question");
		f.add(c);
		
		Label l2 = new Label ("Enter number of questions to be viewed:");
		f.add (l2);

		no = new TextField (20);
		f.add(no);

		Label l3 = new Label ("Enter name of text file if you wish to export test (with .txt)");
		f.add(l3);
		
		fileName = new TextField (20);
		f.add(fileName);

		Button b = new Button ("Ok");
		b.addActionListener (this);
		f.add (b);
		
		Button back = new Button ("Go back");
		back.addActionListener (this);
		f.add(back);
	}

	public void actionPerformed(ActionEvent event) {
		f.setVisible(false);
		if (event.getActionCommand().equals("Go back"))
		{
			SelectFunctionality sf = new SelectFunctionality ();
		}
		else if (event.getActionCommand().equals("Back"))
		{
			f1.setVisible(false);
			GenerateTest generate = new GenerateTest();
		}
		else
		{
			String s = no.getText();
			numberOfQuestions = Integer.parseInt(s);
			String exportFileName = fileName.getText();

			type = c.getSelectedIndex();
			
			FileNames fileNames = new FileNames();

			switch (UserInterface.subject) {
			case 0:
				fileNames.mcqFileName = ApplicationProperties.getInstance().pathForFiles
						+ ApplicationProperties.getInstance().englishMCQFileName;
				fileNames.fillInTheBlanksFileName = ApplicationProperties.getInstance().pathForFiles
						+ ApplicationProperties.getInstance().englishFillInTheBlanksFileName;
				fileNames.trueOrFalseFileName = ApplicationProperties.getInstance().pathForFiles
						+ ApplicationProperties.getInstance().englishTrueOrFalseFileName;
				fileNames.questionsInSubjectFileName = ApplicationProperties.getInstance().pathForFiles
						+ ApplicationProperties.getInstance().questionsInEnglishFileName;

				break;
			case 1:
				fileNames.mcqFileName = ApplicationProperties.getInstance().pathForFiles
						+ ApplicationProperties.getInstance().mathematicsMCQFileName;
				fileNames.fillInTheBlanksFileName = ApplicationProperties.getInstance().pathForFiles
						+ ApplicationProperties.getInstance().mathematicsFillInTheBlanksFileName;
				fileNames.trueOrFalseFileName = ApplicationProperties.getInstance().pathForFiles
						+ ApplicationProperties.getInstance().mathematicsTrueOrFalseFileName;
				fileNames.questionsInSubjectFileName = ApplicationProperties.getInstance().pathForFiles
						+ ApplicationProperties.getInstance().questionsInMathematicsFileName;

				break;
			case 2:
				fileNames.mcqFileName = ApplicationProperties.getInstance().pathForFiles
						+ ApplicationProperties.getInstance().generalKnowledgeMCQFileName;
				fileNames.fillInTheBlanksFileName = ApplicationProperties.getInstance().pathForFiles
						+ ApplicationProperties.getInstance().generalKnowledgeFillInTheBlanksFileName;
				fileNames.trueOrFalseFileName = ApplicationProperties.getInstance().pathForFiles
						+ ApplicationProperties.getInstance().generalKnowledgeTrueOrFalseFileName;
				fileNames.questionsInSubjectFileName = ApplicationProperties.getInstance().pathForFiles
						+ ApplicationProperties.getInstance().questionsInGeneralKnowledgeFileName;
				break;
			}
		
			QuizGenerator obj1 = new QuizGenerator(numberOfQuestions, ch, type, fileNames);
			
			Question [] ques;
			ques = obj1.returnQuestionsArray ();
			displayMCQ (ques);
		
			if (!(exportFileName.equals("")))
			{
				QuizExporter obj = new QuizExporter (ques, ApplicationProperties.getInstance().pathForFiles + exportFileName, type, ch);
			}
		
		}

	}

	public void itemStateChanged (ItemEvent ie)
	{
		Object obj = ie.getItem();
		ch = ((String)obj).equals("Question set")?0:1;
		
	}
	
	public void displayMCQ (Question [] arr)
	{
		f1 = new Frame ("Generate test");
		Label l1, l2, l3, l4, l5;
		f1.setVisible (true);
		f1.setLayout (new FlowLayout ());
		f1.setSize (600, 600);
		f1.addWindowListener (new WCloser());
		TextArea text = new TextArea("");
		
		
		for (int i = 0; i < numberOfQuestions; i++)
		{			
			text.append((i+1) + ". " + arr[i].toString() + "\n");			
			
		
			if (ch == 1)
			{	
				text.append ("Answer: " + (arr[i].returnAnswer()) + "\n");			
				
			}
		}
		f1.add(text);
		
		Button btnGoBack = new Button ("Back");
		btnGoBack.addActionListener (this);
		f1.add(btnGoBack);
	}
}


class WCloser extends WindowAdapter
{
	public void windowClosing (WindowEvent event)
	{
		System.exit (0);
	}
}
