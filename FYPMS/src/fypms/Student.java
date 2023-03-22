package fypms;

public class Student extends User{

	public Student(String studentID, String studentName) {
		super(studentID, studentName);
	}

	public String email() {
		return super.getUserID() + "@e.ntu.edu.sg";
	}
}
