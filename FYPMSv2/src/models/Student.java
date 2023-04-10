package models;

public class Student extends User {
	private boolean haveProject;
	private int deregisteredFYP;
	private Project project;
	
	//Constructor
	public Student(String userName, String email, String password, int deregisteredFYP) {
		super(userName, email, password);
		this.deregisteredFYP = deregisteredFYP;
		project = ProjectList.getStudentProject(userName);
		
		if(project == null)
			haveProject = false;
		else 
			haveProject = true;
	}
	
	public boolean isHaveProject() {
		return haveProject;
	}

	public void setHaveProject(boolean haveProject) {
		this.haveProject = haveProject;
	}
	
	public Project getProject() {
			return project;	
	}

	public int getDeregisteredFYP() {
		return deregisteredFYP;
	}

	public void setDeregisteredFYP(int deregisteredFYP) {
		this.deregisteredFYP = deregisteredFYP;
	}
	
	public void printMyProjects() {
		project.printProjectDetails();
	}
}
