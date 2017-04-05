package mschreiber2740Ex3i;

import javax.swing.DefaultListModel;

//page 541 for description of this assignment

public class DriverExam {
	
	private char [] answers;
	private char [] responses; 
	private final double requiredPct = 0.7;
	
	
	
	//constructor used in testing console
	public DriverExam(char [] answers) {
		super();
		this.answers = new char [answers.length];
		for(char i = 0; i < answers.length; i++)
			answers[i] = (answers[i]);
		
	}
	
	//list model constructor
	public DriverExam(DefaultListModel answers) {
		super();
		this.answers = new char[answers.getSize()]; 
		for(int i = 0; i < answers.getSize(); i++) {
			String r = (String) answers.get(i);
			this.answers[i] = r.charAt(0);
		}
	}
	
	
	
	public void setResponses(DefaultListModel responses){
		this.responses = new char[responses.getSize()]; 
		for(int i = 0; i < responses.getSize(); i++) {
			String r = (String) responses.get(i);
			this.responses[i] = r.charAt(0);
		}
	}
	
	
	//NO IDEA WHERE THIS WAS EVER SETUP. NEVER SHOWN IN LECTURE
	public DefaultListModel getAnswers(){
		throw new UnsupportedOperationException();
		
	}
	
	
	
	//THIS IS NOT WORKING ... RETURNS 66
	public int validate(){
		int i = 0;
		while(answers[i] != 'A' && answers[i] != 'B' && answers[i] != 'C' && answers[i] != 'D'){
			i++;
		}
		return answers[i];
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
	
	
	
	//THIS ONE IS NOT WORKING EXAM.QUESTIONSMISSED CANNOT BE TYPE INT [] MISSED
	public int questionsMissed(){
				
		int [] missed = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		int m = 0;
		
		for(int i = 0; i < answers.length; i++) 
		{
			if(answers[i] != responses[i])
			{
				missed [m] = i + 1;
				m++;
			}
		}
		
		return missed[m];
	}
	
}
