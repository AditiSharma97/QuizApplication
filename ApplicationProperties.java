/*	Properties such as location for storing files, file names, as well as currently user name and
	password, are stored in a properties file, so that these values can be altered by a user if 
	required without having to change the source code of the system.
	
	This class stores those values in the memory of the program, so that these values can be 
	accessed anywhere in the application.
	
	This class is made a Singleton, so that only one object of the class can exist at any time,
	and this object is accessible from anywhere in the system, by calling
	ApplicationProperties.getInstance().<property-name>.
	
	Have not made the attributes private, as these are meant to be just retrieved anywhere in the 
	application with no other validation.
*/

public class ApplicationProperties {

	String userName;
	String password;
	
	String englishMCQFileName;
	String englishTrueOrFalseFileName;
	String englishFillInTheBlanksFileName;
	String questionsInEnglishFileName;
	
	String mathematicsMCQFileName;
	String mathematicsTrueOrFalseFileName;
	String mathematicsFillInTheBlanksFileName;
	String questionsInMathematicsFileName;
	
	String generalKnowledgeMCQFileName;
	String generalKnowledgeTrueOrFalseFileName;
	String generalKnowledgeFillInTheBlanksFileName;
	String questionsInGeneralKnowledgeFileName;
	
	String pathForFiles;
	
	private static ApplicationProperties instance = new ApplicationProperties ();
	private ApplicationProperties () {}
	public static ApplicationProperties getInstance () {
		return instance;
	}
	
}
