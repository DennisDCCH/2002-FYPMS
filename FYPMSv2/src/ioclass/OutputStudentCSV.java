package ioclass;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

import models.Student;

/**
 * This class exports a new csv file based on the information attained from a list of students
 * @author Dennis Chen
 * @version 1.0
 *
 */
public class OutputStudentCSV {
	/**
	 * This stores the filePath to get to the student csv file
	 */
	private static String filePath = System.getProperty("user.dir") + "\\CSVFiles\\student.csv";
	
	/**
	 * This method deleted the old csv file in the filepath and makes a new one based on the information attained 
	 * from a list of students
	 * @param students the information based on this list of students that is to be saved in a csv file
	 */
	public static void writeCSV(List<Student> students) {
		File oldFile = new File(filePath);
		oldFile.delete();
		
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(filePath);
			
			fileWriter.append("Name, Email, Password, DeregisteredFYP");
			fileWriter.append("\n");
			for(Student s: students) {
				fileWriter.append(s.getUserName());
				fileWriter.append(",");
				fileWriter.append(s.getEmail());
				fileWriter.append(",");
				fileWriter.append(s.getPassword());
				fileWriter.append(",");
				fileWriter.append(String.valueOf(s.getDeregisteredFYP()));
				fileWriter.append("\n");
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
