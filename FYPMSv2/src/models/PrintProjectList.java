package models;

import enumclass.ProjectStatus;
/**
 * This class stores methods that will print all the relevant details based on all the projects in the 
 * FYP management system 
 * @author Dennis Chen
 * @version 1.0
 *
 */
public class PrintProjectList {
	
	/**
	 * This method will print out all the details of all project in the FYP management system. It gets the entire
	 * list of projects through another class methods.
	 */
	public static void printAllProject() {
		for(Project p: ProjectList.getProjectList())
			p.printProjectDetails();
	}
	
	/**
	 * This method will print out all the details of the projects with this specified supervisor's username. It
	 * gets this list of projects through another class methods.
	 * @param userName the specified supervisor's username of the project
	 */
	public static void printSupervisorSpecificProjects(String userName) {
		if(ProjectList.getUserSpecificProjectList(userName).size() > 0) {
			for(Project p: ProjectList.getUserSpecificProjectList(userName))
				p.printProjectDetails();
		}
		else {
			System.out.println("This supervisor have no projects");
		}
	}
	
	/**
	 * This method will print out all the details of the projects with this specificed status of the project. It get
	 * this list of projects through another class methods.
	 * @param status the specified status of the project
	 */
	public static void printStatusSpecificProjects(ProjectStatus status) {
		if(ProjectList.getStatusSpecificProjectList(status).size() > 0) {
			for(Project p: ProjectList.getStatusSpecificProjectList(status))
				p.printProjectDetails();
		}
		else {
			System.out.println("There is no projects with this status");
		}
	}
}
     