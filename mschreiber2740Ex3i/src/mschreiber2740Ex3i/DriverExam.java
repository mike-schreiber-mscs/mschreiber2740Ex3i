package mschreiber2740Ex3i;

import javax.swing.DefaultListModel;

//page 541 for description of this assignment

public class DriverExam {
	
	private char [] answers;
	private char [] responses = {'B', 'D', 'A', 'A', 'C','A', 'B', 'A', 'C', 'D'};
	private final double requiredPct = 0.7;
	
	
	
	//constructor used in testing console
	public DriverExam(char [] answers) {
		super();
		this.answers = new char [answers.length];
		for(char i = 0; i < answers.length; i++)
			answers[i] = (answers[i]);
		
	}
	
	//list model constructor
	public DriverExam(DefaultListModel [] answers) {
		super();
		this.answers = new char [answers.length];
		for(char i = 0; i < answers.length; i++)
			answers[i] = (answers[i]);
	}
	
	
	//copy elements from Strings in defaultListModel to char[] array
	public void setResponses(DefaultListModel responses){
		this.responses = new char[responses.getSize()];
		for(int i = 0; i < responses.getSize(); i++) {
			String r = (String) responses.get(i);
			this.responses[i] = r.charAt(0);
		}
	}
	
	
	public DefaultListModel getAnswers(){
		throw new UnsupportedOperationException();
		
	}
	
	
	
	//validate return index of first element found in responses[] that is not A B C or D use a while loop that checks the index of array 
	public int validate(){
		throw new UnsupportedOperationException();
	}

	
	
	public boolean passed(){		
		boolean passed = false;
		int numQuestions = 10; // how do I put the size of the array into numQuestions
		int totalCorrect = totalCorrect();
		
		if(totalCorrect >= requiredPct * numQuestions) {
			passed = true;
		}
		
		else {
			passed = false;
		}
		return passed;
	}
	
	
	public int totalCorrect(){
		int correct = 0;
		for(int i = 0; i < answers.length; i++)
		{
			if(answers[i] == responses[i])
			{
				correct++;
			}
		}
		return correct;		
	}
	
	
	public int totalIncorrect(){
		int incorrect = 0;
		for(int i = 0; i < answers.length; i++)
		{
			if(answers[i] != responses[i])
			{
				incorrect++;
			}
		}
		return incorrect;
	}
	
	
	public int questionsMissed(){
		throw new UnsupportedOperationException();
	}
	
	
	
	
}
