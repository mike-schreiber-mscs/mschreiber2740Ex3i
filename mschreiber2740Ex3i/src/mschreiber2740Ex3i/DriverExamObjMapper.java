package mschreiber2740Ex3i;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.swing.DefaultListModel;

public class DriverExamObjMapper {
	
	private String fileName;
	private Scanner inputFile;
	private File file;
	
	
	public DriverExamObjMapper(String fileName) {
		this.fileName = fileName;
	}	
		
	public boolean openInputFile()	{
		boolean fileOpened = false;
		
		// Open the file.
	    try {
	    	File file = new File(this.fileName);
			fileOpened = file.exists();
			
			if (fileOpened){
				//Open the file
				this.inputFile = new Scanner (file);
			}	    
	    }
	    catch (IOException e) {}
	    
		return fileOpened;
	}
	
		
		
	public DefaultListModel getDriverExam(){
		
		DefaultListModel driverExamCollection = new DefaultListModel();
		
		if(this.openInputFile())
		{
			while (this.inputFile.hasNext()) {
				DriverExam p = this.getNextDriverExam();
				if (p != null)
				driverExamCollection.addElement(p);
			}
		}
		
		this.closeInputFile();
		return driverExamCollection;
		
	}
		
	
	public void closeInputFile() {
		if(this.inputFile !=null) {
			this.inputFile.close();
		}
	}
		
	public DriverExam getNextDriverExam() {
		DriverExam p = null;
		
		int id = 0;
		String name = "";
		double payRate = 0.0;
		double hours = 0.0;
		
		try {
			String textLine = inputFile.nextLine();
			id = Integer.parseInt(textLine);
			name = inputFile.nextLine();
			textLine = inputFile.nextLine();
			payRate = Double.parseDouble(textLine);
			textLine = inputFile.nextLine();
			hours = Double.parseDouble(textLine);
			//p = new DriverExam(id, name, payRate, hours);
		}
		
		catch (NoSuchElementException e) {}
		catch (NumberFormatException e) {}
		
		return p;
	}
		

}
	
