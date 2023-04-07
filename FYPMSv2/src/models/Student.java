package models;

public class Student extends User {
	private boolean haveProject;
	//Constructor
	public Student(String userName, String email, String password, ProjectList projectList) {
		super(userName, email, password, projectList);
		haveProject = false;
	}
	
	public boolean isHaveProject() {
		return haveProject;
	}
}
