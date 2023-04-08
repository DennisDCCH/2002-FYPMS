package models;

import java.util.List;

import ioclass.ReadStudentCSV;

public class StudentList {
	private static List<Student> studentList;
	
	public static void initialise() {
		studentList = ReadStudentCSV.readCSV();
	}
	
	//Checking whether the student belongs in the student list
	public static Student checkDomain(String userID){
		for (Student s: studentList) {
			if(s.getUserID().equals(userID)) 
				return s;
		}
		return null;
	}
	
	public static Student getSpecificStudent(String userName) {
		for(Student s: studentList) {
			if(s.getUserName().equals(userName))
				return s;
		}
		return null;
	}

	//Setter Getter
	public static List<Student> getStudentList() {
		return studentList;
	}
} 
