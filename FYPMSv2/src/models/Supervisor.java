package models;

import java.util.ArrayList;
import java.util.List;

import enumclass.ProjectStatus;

/**
 * This class is a supervisor which is a subclass of the user. Supervisor inherits attributes and methods from the user class.
 * A supervisor is able to access the FYP management system.
 * @author Dennis
 * @version 1.0
 */
public class Supervisor extends User{
	
	/**
	 * This attribute check for how many project is the supervisor currently supervising. Meaning either the project
	 * have a status of allocated or reserved. 
	 */
	private int supervisingProjectCount;
	
	/**
	 * This is a list of project that the supervisor currently have, which can be of any status. 
	 * Projects can be created by the supervisor or can be transferred over by other supervisors. 
	 * A supervisor can have many projects, thus the need for a list of projects.
	 * So this is a list of objects
	 */
	protected List<Project> projectList;
	
	/**
	 * This constructs a student with a specificed username, email, password.
	 * The username, email and password will be feed into the super class which is user.
	 * 
	 * Afterwards, we will attain all the project that have the supervisor is part based on his username 
	 * through the use of another class method and put it in the supervisor's project list.
	 * 
	 * Then we will initialise the attribute supervisingProjectCount with a method used on this project list.
	 *
	 * @param userName the username of the supervisor
	 * @param email the email of the supervisor
	 * @param password the password of the supervisor
	 */
	public Supervisor(String userName, String email, String password) {
		super(userName, email, password);
		
		projectList = ProjectList.getUserSpecificProjectList(userName);
		supervisingProjectCount = checkNumSupervisingProject();
	}
	
	/**
	 * This method will run through the supervisor's list of project and checks for the number of project that he is
	 * currently supervising. This means any project with a status of reserved or allocated. 
	 * If the number of projects that he is supervising is less than 2, we will check for any projects in this 
	 * list of project that have the status unavailable and set the project status as available.
	 * If the number of projects that he is supervising is 2, we will check for any project in this list of
	 * project that have the status available and set the project status as unavailable.
	 */
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
	
	/**
	 * This method will run through the supervisor's list of project and checks for the total number of project that
	 * he is currently supervising. This means any project with a status of reserved or allocated project. 
	 * @return the total number of project that supervisor is supervising.
	 */
	public int checkNumSupervisingProject() {
		int count = 0;
		for(Project p: projectList) {
			if(p.getStatus() == ProjectStatus.ALLOCATED || p.getStatus() == ProjectStatus.RESERVED)
				count++;
		}
		return count;
	}

	/**
	 * This method gets the current number of project the supervisor is supervising. Meaning the total number of 
	 * projects with the status of allocated or reserved.
	 * @return the total number of project that supervisor is supervising.
	 */
	public int getSupervisingProjectCount() {
		return supervisingProjectCount;
	}
	
	/**
	 * This method will print out the details of the project that have the status allocated in the 
	 * supervisor's project list
	 */
	public void printAllocatedProjects() {
		for(Project p: projectList) {
			if(p.getStatus() == ProjectStatus.ALLOCATED)
				p.printProjectDetails();
		}
	}
	
	/**
	 * This method will print out the details of all the project in the supervisor's project list
	 */
	public void printMyProjects() {
		for(Project p: projectList)
			p.printProjectDetails();
	}
	
	/**
	 * This method will add a new project object into the supervisor's project list
	 * @param p This is the new project object
	 */
	public void addProject(Project p) {
		projectList.add(p);
	}
	
	/**
	 * This method will remove a existing project object in the supervisor's project list
	 * @param p This is the project object that needs to be removed
	 */
	public void removeProject(Project p) {
		projectList.remove(p);
	}
	
	/**
	 * Thie methods get the project that is in the supervisor's project list based on what is the project id inputted.
	 * If such a project id is not found in the supervisor's project list, it will get nothing.
	 * @param projectID This is the value of the project id that you want to get back.
	 * @return the project object of the specificed project id.
	 */
	public Project getProject(int projectID) {
		for(Project p: projectList) {
			if(p.getProjectID() == projectID)
				return p;
		}
		return null;
	}
	
	/**
	 * Thie methods get the allocated project that is in the supervisor's project list based on what is the project id inputted.
	 * If such a project id is not found in the supervisor's project list, it will get nothing.
	 * If such a project id is found, but the project status is not allocated, it will also get nothing.
	 * @param projectID This is the value of the project id that you want to get back.
	 * @return the allocated project object of the specificed project id.
	 */
	public Project getAllocatedProject(int projectID) {
		for(Project p: projectList) {
			if(p.getProjectID() == projectID) {
				if(p.getStatus() == ProjectStatus.ALLOCATED)
					return p;
			}
		}
		return null;
	}
	
	/**
	 * This method get all the project that have the status allocated in the supervisor's project list.
	 * This method will run through all the project in supervisor's project list, if the project is allocated, it will
	 * be appeneded into a new list of project.
	 * @return the supervisor's list of allocated projects.
	 */
	public List<Project> getAllocatedProjectList(){
		List<Project> newlist = new ArrayList<Project>();
		for(Project p: projectList) {
			if(p.getStatus() == ProjectStatus.ALLOCATED)
				newlist.add(p);
		}
		return newlist;
	}
	
	/**
	 * This method gets the entire list of project of the supervisor
	 * @return this supervisor's list of project
	 */
	public List<Project> getProjectList() {
		return projectList;
	}
}
