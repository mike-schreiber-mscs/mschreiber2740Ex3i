package mschreiber2740Ex3i;

import javax.swing.DefaultListModel;

//page 541 for description of this assignment

public class DriverExam {
	
	private char [] answers;
	private char [] responses = {'B', 'D', 'A', 'A', 'C','A', 'B', 'A', 'C', 'D'};
	private final double requiredPct = 0.7;
	
	
	

	public DriverExam(char [] answers) {
		super();
		this.answers = new char [answers.length];
		for(char i = 0; i < answers.length; i++)
			answers[i] =(answers[i]);
		
	}
	
	public DriverExam(DefaultListModel [] answers) {
		
	}
	
	//copy elements from Strings in defaultListModel to char[]
	public void setResponses(DefaultListModel responses){
		this.responses = new char[responses.getSize()];
		for(int i = 0; i < responses.getSize(); i++) {
			String r = (String) responses.get(i);
			this.responses[i] = r.charAt(0);
		}
	}
	
	
	public DefaultListModel getAnswers(){
		return(null);
		
	}
	
	//validate return index of first element found in responses[] that is not A B C or D use a while loop that checks the index of array 
	public int validate(){
		throw new UnsupportedOperationException();
	}

	public boolean passed(){
		throw new UnsupportedOperationException();
	}
	
	public int totalCorrect(){
		throw new UnsupportedOperationException();
		
		
	}
	
	public int totalIncorrect(){
		throw new UnsupportedOperationException();
	}
	
	public int questionsMissed(){
		throw new UnsupportedOperationException();
	}
	
	
	
	
}
