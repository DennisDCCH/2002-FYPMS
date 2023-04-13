package models;

import enumclass.ProjectStatus;
/**
 * This class is one that does the necessary steps to update all the relevant details when a deregister fyp request is 
 * proccessed. 
 * @author Dennis Chen
 * @version 1.0
 */
public class ProcessDeregisterFYPRequest {

	/**
	 * This method takes the specified project id to get back the project object from another class method. With this
	 * project object, we will now remove the student from the project, update the project status.
	 * Afterwards, we will use the requester username which is the project student user name to get back his student
	 * object from another class method and set his deregistered fyp as 1.
	 * Lastly, from the project we will get the supervisor username and use that to get this specific supervisor object
	 * using another class method and now check and updates that status of all his projects in his project list. Because
	 * now the supervisor can be supervising 1 project only down from 2, and all his unavailable projects is now available.
	 * 
	 * @param requesterName is the requester's username (student's username who wants to deregister from fyp). 
	 * @param projectID is the project id of the projec tthat requires processing.
	 */
	public static void manageRequest(String requesterName, int projectID) {

		// Remove student name from project
		ProjectList.getSpecificProject(projectID).removeStudent();
		
		// Update that student have been deregistered from FYP
		StudentList.getSpecificStudent(requesterName).setDeregisteredFYP(1);
		
		// Set project status
		ProjectList.getSpecificProject(projectID).setStatus(ProjectStatus.AVAILABLE);
		
		//Update status of supervisor project list
		SupervisorList.getSpecificSupervisor(ProjectList.getSpecificProject(projectID).getSupervisorName()).checkAndSetProjectStatus();
	}
}
