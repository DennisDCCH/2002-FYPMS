package models;

import java.util.List;

import ioclass.ReadStudentCSV;

public class StudentList {
	List<Student> studentList;
	
	public StudentList() {
		ReadStudentCSV csv = new ReadStudentCSV();
		studentList = csv.readCSV();
	}
	
	//Checking whether the student belongs in the student list
	public Student checkDomain(String userID){
		for (Student s: studentList) {
			if(s.getUserID().equals(userID)) 
				return s;
		}
		return null;
	}

	//Setter Getter
	public List<Student> getStudentList() {
		return studentList;
	}
} 
