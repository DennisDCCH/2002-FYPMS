package ioclass;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import models.Student;

public class OutputStudentCSV {
	private List<Student> students;
	private static String filePath = System.getProperty("user.dir") + "\\CSVFiles\\student.csv";
	
	public OutputStudentCSV(List<Student> students) {
		this.students = students;
		writeCSV();
	}
	
	public void writeCSV() {
		File oldFile = new File(filePath);
		oldFile.delete();
		
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(filePath);
			
			fileWriter.append("Name, Email, Password");
			fileWriter.append("\n");
			for(Student s: students) {
				fileWriter.append(s.getUserName());
				fileWriter.append(",");
				fileWriter.append(s.getEmail());
				fileWriter.append(",");
				fileWriter.append(s.getPassword());
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
