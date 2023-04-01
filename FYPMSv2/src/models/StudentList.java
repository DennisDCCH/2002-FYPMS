package models;

import java.util.List;

import ioclass.ReadStudentCSV;

public class StudentList {
	List<Student> studentList;
	
	public StudentList() {
		ReadStudentCSV csv = new ReadStudentCSV();
		studentList = csv.readCSV();
	}
} 
