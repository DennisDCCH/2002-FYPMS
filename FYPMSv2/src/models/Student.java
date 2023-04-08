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
		if(super.projectList.size() == 0)
			return false;
		else 
			return true;
	}

	public void setHaveProject(boolean haveProject) {
		this.haveProject = haveProject;
	}
	
	public Project getProject() {
		for(Project p: projectList)
			return p;
		return null;	
	}
}
