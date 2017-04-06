package mschreiber2740Ex3i;

import javax.swing.DefaultListModel;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//char [] answers = {'B', 'D', 'A', 'A', 'C', 'A', 'B', 'A', 'C', 'D'}; 
//		DefaultListModel answersListModel = new DefaultListModel();
//		answersListModel.addElement("B");
//		answersListModel.addElement("D");
//		answersListModel.addElement("A");
//		answersListModel.addElement("A");
//		answersListModel.addElement("C");
//		answersListModel.addElement("A");
//		answersListModel.addElement("B");
//		answersListModel.addElement("A");
//		answersListModel.addElement("C");
//		answersListModel.addElement("D");
//		DriverExam exam = new DriverExam(answersListModel);
		DriverExamObjMapper mapper = new DriverExamObjMapper("DriverExam.txt");
		DriverExam exam = mapper.getDriverExam();
		
		DefaultListModel responsesListModel = new DefaultListModel();
		responsesListModel.addElement("A");
		responsesListModel.addElement("A");
		responsesListModel.addElement("A");
		responsesListModel.addElement("A");
		responsesListModel.addElement("A");
		responsesListModel.addElement("A");
		responsesListModel.addElement("B");
		responsesListModel.addElement("Z");
		responsesListModel.addElement("A");
        responsesListModel.addElement("A");
		exam.setResponses(responsesListModel);
			
		System.out.println("First invalid repsonse: " + exam.validate());
		System.out.println("Correct: " + exam.totalCorrect());
		System.out.println("Incorrect: " + exam.totalIncorrect());

		if (exam.passed()){
			System.out.println("Passed test");
		}
			
		else 
			{
			System.out.println("Try again");
			}
		System.out.print("Questions missed: ");
		int [] missed = exam.questionsMissed();
		int i = 0;
		while (i < missed.length && missed[i] > 0)
			{
				System.out.print(" " + missed[i]);
				i++;
			
			}
		
		return;
	}

}
