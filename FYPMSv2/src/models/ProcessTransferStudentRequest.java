package models;

/**
 * This class is one that does the necessary steps to update all the relevant details when a transfer student request is 
 * proccessed. 
 * @author Dennis Chen
 * @version 1.0
 */
public class ProcessTransferStudentRequest {
	
	/**
	 * This method takes the specified project id to get back the project object using another class method. Wit this
	 * project object, we will now be able to update the project with the new supervisor username and email.
	 * 
	 * Afterwards, we will use the requester username which is the old project supervisor username and use that to get
	 * the specific supervisor object and remove this project from his project list. Now we will check and update the 
	 * status of all his projects in his project list. Because now the supervisor can be supervising 1 projects dowm 
	 * from 2, and all hus unavailable projects should be available.
	 * 
	 * Lastly, from the additional info which will contain the new supervisor's userid, we will use that and another 
	 * class method to get this specific supervisor object and append this new project into his project list. We will 
	 * check and update the status of all this new supervisor project in his project list. Because now this new supervisor
	 * can be supervising 2 projects up from 1, and all his available project should be unavailable.
	 * 
	 * @param requesterName is the requester's username (the supervisor's username that is transferring
	 * this project to another supervisor).
	 * @param projectID is the project id of the project that requires processing.
	 * @param additionalInfo is the new supervisor's userid that is to be added to the project.
	 */
	public static void manageRequest(String requesterName, int projectID, String additionalInfo) {
	
		// Remove project from old supervisor projectList
		SupervisorList.getSpecificSupervisor(requesterName).removeProject(ProjectList.getSpecificProject(projectID));
	
		// Update status of old supervisor projectList
		SupervisorList.getSpecificSupervisor(requesterName).checkAndSetProjectStatus();
	
		// Set new supervisor name to project
		ProjectList.getSpecificProject(projectID).setSupervisorName(SupervisorList.getSpecificSupervisorID(additionalInfo).getUserName());

		// Set new supervisor email to project
		ProjectList.getSpecificProject(projectID).setSupervisorEmail(SupervisorList.getSpecificSupervisorID(additionalInfo).getEmail());
		
		// Add project to new supervisor projectList
		SupervisorList.getSpecificSupervisorID(additionalInfo).addProject(ProjectList.getSpecificProject(projectID));
	
		//Update status of new supervisor projectList
		SupervisorList.getSpecificSupervisorID(additionalInfo).checkAndSetProjectStatus();	  
	}
}