package models;

import enumclass.ProjectStatus;

public class Supervisor extends User{
	
	//Constructor
	public Supervisor(String userName, String email, String password) {
		super(userName, email, password);
	}
	
	public void createNewProject(int id, String projectTitle) {
		Project p = new Project(id, super.userName, null, projectTitle, ProjectStatus.AVAILABLE );
		//Add p to user list of project
		super.projectList.add(p);
	}
}
