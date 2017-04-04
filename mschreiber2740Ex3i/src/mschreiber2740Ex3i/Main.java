package mschreiber2740Ex3i;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char [] answers = {'B', 'D', 'A', 'A', 'C', 'A', 'B', 'A', 'C', 'D'}; 
		DriverExam exam = new DriverExam(answers);
		
			
		System.out.println("First invalid repsonse: " + exam.validate());
		System.out.println("Correct: " + exam.totalCorrect());
		System.out.println("Incorrect: " + exam.totalIncorrect());

		//if (exam.passed())
		//	System.out.println("Passed test");
		//else System.out.println("Try again");
		
		//System.out.print("Questions missed: ");
		//int[] missed = exam.questionsMissed();
		//int i = 0;
		//while (i < missed.length && missed[i] > 0) {
		//	System.out.print(" " + missed[i]);
		//	i++;
		//}
		
		return;
	}

}
