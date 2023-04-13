package models;

import java.util.ArrayList;
import java.util.List;

import enumclass.ProjectStatus;
import ioclass.ReadProjectCSV;

/**
 * This class is one that contains a list of project in the fyp management system. It stores all the information
 * of all projects.
 * @author Dennis Chen
 * @version 1.0
 *
 */
public class ProjectList {
	
	/**
	 * This is a list of project stored in the projectlist class.
	 */
	private static List<Project> projectList;
	
	/**
	 * This method initialise the list of project through the use of another class method.
	 */
	public static void intialise() {
		projectList = ReadProjectCSV.readCSV();
	}
	
	/**
	 * This method will add a new project object into the projectlist's list of project.
	 * @param p this is the new project object
	 */
	public static void addProject(Project p) {
		projectList.add(p);
	}
	
	/**
	 * This method gets all the project in the list of project that have the username in the project object, be it 
	 * be the project's supervisor. It will run through all the project and append it into a new list of project.
	 * @param userName this is the specific username of that wants to get back in all project
	 * @return the list of project with this particular username in it.
	 */
	public static List<Project> getUserSpecificProjectList(String userName){
		List<Project> newList = new ArrayList<Project>();
		for(Project p: projectList) {
			if(p.getSupervisorName().equals(userName))
				newList.add(p);
		}
		return newList;
	}
	

	/**
	 * This method gets all the project in the list of project that have this particular project status in the project
	 * object. It will run through all the project and append it into a new list of projects.
	 * @param status this is the specific project status that wants to get back in all project
	 * @return the list of project with this particular status.
	 */
	public static List<Project> getStatusSpecificProjectList(ProjectStatus status){
		List<Project> newList = new ArrayList<Project>();
		for(Project p: projectList) {
			if(p.getStatus() == status)
				newList.add(p);
		}
		return newList;
	}
	
	/**
	 * Thie methods get the project that is in this class project list based on what is the project id inputted.
	 * If such a project id is not found in the project list, it will get nothing.
	 * @param projectID This is the value of the project id that you want to get back.
	 * @return the project object of the specificed project id.
	 */
	public static Project getSpecificProject(int projectID) {
		for(Project p: projectList) {
			if(p.getProjectID() == projectID)
				return p;
		}
		return null;
	}
	
	/**
	 * Thie methods get the available project that is in this class project list based on what is the project id inputted.
	 * If such a project id is not found in the project list, it will get nothing.
	 * If such a project id is found but the status is not available, it will get nothing
	 * @param projectID This is the value of the project id that you want to get back.
	 * @return the available status project object of the specificed project id.
	 */
	public static Project getSpecificAvailableProject(int projectID) {
		for(Project p: projectList) {
			if(p.getProjectID() == projectID) {
				if(p.getStatus() == ProjectStatus.AVAILABLE)
					return p;
			}
		}
		return null;
	}
	
	/**
	 * This method gets the project in the list of project that have the student's username in the project object. 
	 * It will run through all the project to find the project with this specificed username.
	 * @param userName this is the specific username of that wants to get back.
	 * @return the project with this particular username in it.
	 */
	public static Project getStudentProject(String userName) {
		for(Project p: projectList) {
			if(p.getStudentName().equals(userName))
				return p;
		}
		return null;
	}

	/**
	 * This method gets the entire list of project of the projectlist class.
	 * @return this projectlist's list of project.
	 */
	public static List<Project> getProjectList() {
		return projectList;
	}
	
	/**
	 * This method gets the next project id by tabulating what is the size of the current list of project.
	 * @return the next project id.
	 */
	public static int getNextProjectID() {
		return projectList.size() + 1;
	}
}
