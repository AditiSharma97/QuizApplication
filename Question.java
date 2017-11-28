import java.io.*;

abstract class Question
{
	String question;
	long qID;

	abstract public String toString ();
	abstract public String returnAnswer ();	
}

class MultipleChoiceQuestion extends Question
{
	String [] options = new String [4];	
	int answer; //0, 1, 2, 3

	public String toString ()
	{
		return question + "\n" + options [0] + "\n" + options [1] + "\n" + options [2] + "\n" + options [3];
	}

	public String returnAnswer ()
	{
		return Integer.toString(answer+1);
	}
}

class TrueOrFalseQuestion extends Question
{
	boolean answer;

	public String toString ()
	{
		return question;
	}
	
	public String returnAnswer ()
	{
		return Boolean.toString (answer);
	}
}

class FillInTheBlanksQuestion extends Question
{
	String answer;

	public String toString ()
	{
		return question;
	}
	
	public String returnAnswer ()
	{
		return answer;
	}
}
