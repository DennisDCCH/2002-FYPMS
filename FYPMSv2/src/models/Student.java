package models;

public class Student extends User {
	private boolean haveProject;
	//Constructor
	public Student(String userName, String email, String password) {
		super(userName, email, password);
		haveProject = false;
	}
	
	public boolean isHaveProject() {
		return haveProject;
	}
}
