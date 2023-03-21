package fypms;

public class Student extends User{
	private boolean haveProject;
	
	public Student(String studentID, String studentName) {
		super(studentID, studentName);
		haveProject = false;
	}

	public boolean isHaveProject() {
		return haveProject;
	}

	public void setHaveProject(boolean haveProject) {
		this.haveProject = haveProject;
	}
	
	public String email() {
		return userID + "@e.ntu.edu.sg";
	}
}
