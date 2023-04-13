package ioclass;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import models.Student;

/**
 * This class reads from the data file and using the information in the data file make a list of student object
 * @author Dennis Chen
 * @version 1.0
 *
 */
public class ReadStudentCSV {
	/**
	 * This stores the filePath to get to the student csv file
	 */
	private static String filePath = System.getProperty("user.dir") + "\\CSVFiles\\student.csv";

	/**
	 * This method reads from the csv file and it will make a student object based on the information stored in 
	 * each row of the csv file. Each of this student object is appended into a list to make a list of students
	 * @return the list of students that is made from the information in the csv file
	 */
	public static List<Student> readCSV() {
		BufferedReader reader = null;
		
		try {
			List<Student> studentList = new ArrayList<Student>();
			String line = ",";
			
			reader = new BufferedReader(new FileReader(filePath));
			reader.readLine();
			
			while((line = reader.readLine()) != null) {
				 String[] fields = line.split(",");
				 
				 if(fields.length > 0) {
					 Student s = new Student(fields[0], fields[1], fields[2], Integer.valueOf(fields[3])); 
					 studentList.add(s);
				 }
			}
			return studentList;
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			try {
				reader.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}