package ioclass;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import models.Student;


public class ReadStudentCSV {
	private static String filePath = System.getProperty("user.dir") + "\\CSVFiles\\student.csv";

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
					 Student s = new Student(fields[0], fields[1], fields[2]); 
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