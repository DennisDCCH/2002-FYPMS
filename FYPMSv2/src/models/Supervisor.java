package models;

import java.util.ArrayList;
import java.util.List;

import enumclass.ProjectStatus;

public class Supervisor extends User{
	private int supervisingProjectCount;
	protected List<Project> projectList;
	
	//Constructor
	public Supervisor(String userName, String email, String password) {
		super(userName, email, password);
		
		projectList = ProjectList.getUserSpecificProjectList(userName);
		supervisingProjectCount = checkNumSupervisingProject();
	}
	
	public void checkAndSetProjectStatus() {
		int count = 0;
		for(Project p: projectList) {
			if(p.getStatus() == ProjectStatus.ALLOCATED || p.getStatus() == ProjectStatus.RESERVED)
				count++;
			if(count == 2)
				break;
		}
		for(Project p: projectList) {
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
		for(Project p: projectList) {
			if(p.getStatus() == ProjectStatus.ALLOCATED || p.getStatus() == ProjectStatus.RESERVED)
				count++;
		}
		return count;
	}

	public int getSupervisingProjectCount() {
		return supervisingProjectCount;
	}
	
	public void printAllocatedProjects() {
		for(Project p: projectList) {
			if(p.getStatus() == ProjectStatus.ALLOCATED)
				p.printProjectDetails();
		}
	}
	
	public void printMyProjects() {
		for(Project p: projectList)
			p.printProjectDetails();
	}
	
	public void addProject(Project p) {
		projectList.add(p);
	}
	
	public void removeProject(Project p) {
		projectList.remove(p);
	}
	
	public Project getProject(int projectID) {
		for(Project p: projectList) {
			if(p.getProjectID() == projectID)
				return p;
		}
		return null;
	}
	
	public Project getAllocatedProject(int projectID) {
		for(Project p: projectList) {
			if(p.getProjectID() == projectID) {
				if(p.getStatus() == ProjectStatus.ALLOCATED)
					return p;
			}
		}
		return null;
	}
	
	public List<Project> getAllocatedProjectList(){
		List<Project> newlist = new ArrayList<Project>();
		for(Project p: projectList) {
			if(p.getStatus() == ProjectStatus.ALLOCATED)
				newlist.add(p);
		}
		return newlist;
	}
	
	public List<Project> getProjectList() {
		return projectList;
	}
}
