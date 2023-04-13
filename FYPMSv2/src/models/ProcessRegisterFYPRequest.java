package models;

import enumclass.ProjectStatus;
/**
 * This class is one that does the necessary steps to update all the relevant details when a register fyp request is 
 * proccessed. 
 * @author Dennis Chen
 * @version 1.0
 */
public class ProcessRegisterFYPRequest {
	
	/**
	 * This method takes the specified project id to get back the project object using another class method. With this
	 * project object, we will now add the students name and email to the project and update the status.
	 * 
	 * Afterwards, from the project we will get the supervisor username and use that to get this specific supervisor object using
	 * another class method and now check and updates that status of all his projects in his project list. Because now
	 * the supervisor can be supervising 2 projects up from 1, and all his available project should be unavailable.
	 * 
	 * @param projectID is the project id of the project that requires processing.
	 * @param requesterName is the requester's username (the student's username that needs to be added to the project).
	 * @param additionalInfo is the student's email that needs to be added to the project.
	 */
	public static void manageRequest(int projectID, String requesterName, String additionalInfo) {
		
		// Set student name to project
		ProjectList.getSpecificProject(projectID).setStudentName(requesterName);
		
		// Set student email to project
		ProjectList.getSpecificProject(projectID).setStudentEmail(additionalInfo);
		
		// Set project status
		ProjectList.getSpecificProject(projectID).setStatus(ProjectStatus.ALLOCATED);
		
		//Update status of supervisor project list
		SupervisorList.getSpecificSupervisor(ProjectList.getSpecificProject(projectID).getSupervisorName()).checkAndSetProjectStatus();
	}
	
	/**
	 * This method takes the specified project id to get back the project object from another class method. With this
	 * project object, we will now update the project status.
	 * 
	 * Afterwards, from the project we will get the supervisor username and use that to get this specific supervisor object
	 * using another class method and now check and updates that status of all his projects in his project list. Because
	 * now the supervisor can be supervising 1 project only down from 2, and all his unavailable projects is now available.
	 * 
	 * @param projectID is the project id of the project that requires processing.
	 */
	public static void rejectRequest(int projectID) {
		// Set project status
		ProjectList.getSpecificProject(projectID).setStatus(ProjectStatus.AVAILABLE);
		
		// Update status of supervisor project list
		SupervisorList.getSpecificSupervisor(ProjectList.getSpecificProject(projectID).getSupervisorName()).checkAndSetProjectStatus();	
	}
}
