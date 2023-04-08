package models;

public class ProcessTransferStudentRequest {
	public static void manageRequest(Request r) {
		// r request id, requester name, responder name, project id, new supervisor name
		
		// Remove project from old supervisor projectList
		SupervisorList.getSpecificSupervisor(r.getRequesterName()).removeProject(ProjectList.getSpecificProject(r.getProjectID()));
		
		// Update status of old supervisor projectList
		SupervisorList.getSpecificSupervisor(r.getRequesterName()).checkAndSetProjectStatus();
		
		// Set new supervisor name to project
		ProjectList.getSpecificProject(r.getProjectID()).setSupervisorName(r.getAdditionalInfo());
		
		// Add project to new supervisor projectList
		SupervisorList.getSpecificSupervisorID(r.getAdditionalInfo()).addProject(ProjectList.getSpecificProject(r.getProjectID()));
		
		//Update status of new supervisor projectList
		SupervisorList.getSpecificSupervisorID(r.getAdditionalInfo()).checkAndSetProjectStatus();
		  
	}
}
