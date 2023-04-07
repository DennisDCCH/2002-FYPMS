package models;

public class Student extends User {
	private boolean haveProject;
	
	//Constructor
	public Student(String userName, String email, String password) {
		super(userName, email, password);
		
		haveProject = initialSetHaveProject();
	}
	
	public boolean isHaveProject() {
		return haveProject;
	}
	
	private boolean initialSetHaveProject() {
		for(Project p: super.projectList)
			return true;
		return false;
	}
}
