package models;

import java.util.List;

import ioclass.ReadStudentCSV;

/**
 * This class is one that contains a list of students in the fyp management system. It stores all the information
 * of all students.
 * @author Dennis Chen
 * @version 1.0
 *
 */
public class StudentList {
	
	/**
	 * This is a list of students stored in the studentlist class.
	 */
	private static List<Student> studentList;
	
	/**
	 * This method initialise the list of students through the use of another class method.
	 */
	public static void initialise() {
		studentList = ReadStudentCSV.readCSV();
	}
	
	/**
	 * This method gets the students that is in the studentlist's list of students based on what is the
	 * userid inputted. If such a userid is not found in the list, it will get nothing.
	 * @param userID this is the specific userid of the students that wants to get back.
	 * @return a specific student in studentlist's list of students.
	 */
	public static Student checkDomain(String userID){
		for (Student s: studentList) {
			if(s.getUserID().equals(userID)) 
				return s;
		}
		return null;
	}
	
	/**
	 * This method gets the students that is in the studentlist's list of students based on what is the
	 * username inputted. If such a userid is not found in the list, it will get nothing.
	 * @param userName this is the specific username of the students that wants to get back.
	 * @return a specific student in studentlist's list of students.
	 */
	public static Student getSpecificStudent(String userName) {
		for(Student s: studentList) {
			if(s.getUserName().equals(userName))
				return s;
		}
		return null;
	}

	/**
	 * This method gets the entire list of student of the studentlist class.
	 * @return this studentlist's list of student.
	 */
	public static List<Student> getStudentList() {
		return studentList;
	}
} 
