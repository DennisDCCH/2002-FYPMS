package models;

import enumclass.ProjectStatus;

public class Supervisor extends User{
	private int supervisingProjectCount;
	//Constructor
	public Supervisor(String userName, String email, String password) {
		super(userName, email, password);
		supervisingProjectCount = checkNumSupervisingProject();
		checkAndSetProjectStatus();
	}
	
	public void createNewProject(int id, String projectTitle) {
		Project p = new Project(id, super.userName, null, projectTitle, ProjectStatus.AVAILABLE );
		//Add p to user list of project
		super.projectList.add(p);
	}
	
	public void checkAndSetProjectStatus() {
		int count = 0;
		for(Project p: super.projectList) {
			if(p.getStatus() == ProjectStatus.ALLOCATED || p.getStatus() == ProjectStatus.RESERVED)
				count++;
			if(count == 2)
				break;
		}
		for(Project p: super.projectList) {
			if(count == 2) {
				if(p.getStatus() == ProjectStatus.AVAILABLE)
					p.setStatus(ProjectStatus.UNAVAILABLE);
			}
			else {
				if(p.getStatus() == ProjectStatus.UNAVAILABLE)
					p.setStatus(ProjectStatus.AVAILABLE);
			}
		}
	}
	
	public int checkNumSupervisingProject() {
		int count = 0;
		for(Project p: super.projectList) {
			if(p.getStatus() == ProjectStatus.ALLOCATED || p.getStatus() == ProjectStatus.RESERVED)
				count++;
		}
		return count;
	}

	public int getSupervisingProjectCount() {
		return supervisingProjectCount;
	}
	
	public void printAllocatedProjects() {
		for(Project p: super.projectList) {
			if(p.getStatus() == ProjectStatus.ALLOCATED)
				p.printProjectDetails();
		}
	}
}
