# Quiz Application
This application is a quiz generator application. There are 9 text files containing questions in 3 subjects - English, Mathematics and General Knowledge. Each subject has 3 types of questions, namely, multiple choice questions, true or false questions and fill in the blanks questions. This application lets the user insert new questions, modify existing questions, delete questions and generate quiz (with existing questions). There is also an option to export questions in .txt file.

In properties.txt, set pathForFiles as the location of your application folder of this project.
Username and password are contained in the properties.txt file.
Use command:
> javac UserInterface.java

> java UserInterface

The questions are stored in the text files as follows:
EnglishMCQ.txt: Multiple choice questions for subject English
EnglishTrueOrFalse.txt: True or false questions for subject English
EnglishFillInTheBlanks.txt: Fill in the blanks questions for subject English
Similar files for subjects Mathematics and General Knowledge (can find the exact file names in properties.txt).

QuestionsInEnglish.txt: stores the number of questions in subject English for all 3 types of questions
Similar files for subjects Mathematics and General Knowledge.
