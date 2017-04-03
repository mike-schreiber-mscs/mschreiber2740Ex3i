package mschreiber2740Ex3i;

import javax.swing.DefaultListModel;

//page 541 for description of this assignment

public class DriverExam {
	
	private char [] answers;
	private char [] responses;
	private final double requiredPct = 0.7;
	
	
	

	public DriverExam(char [] answers) {
		super();
		
		//add code to populate the answers with a for loop to this.answers using the length field answers.length
		
	}
	
	public DriverExam(DefaultListModel [] answers) {
		//add code to populate the answers with a for loop to this.answers using the length field list model.length
	}
	
	public void setResponses(DefaultListModel responses){
		throw new UnsupportedOperationException();
	}
	
	public DefaultListModel getAnswers(){
		return(null);
		
	}
	
	public int validate(){
		throw new UnsupportedOperationException();
	}

}
