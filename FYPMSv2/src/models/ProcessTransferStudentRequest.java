package models;

public class ProcessTransferStudentRequest {
	public static void manageRequest(String requesterName, int projectID, String additionalInfo) {
		// r request id, requester name, responder name, project id, new supervisor name
		
		// Remove project from old supervisor projectList
		SupervisorList.getSpecificSupervisor(requesterName).removeProject(ProjectList.getSpecificProject(projectID));
		// SupervisorList.getSpecificSupervisor(r.getRequesterName()).removeProject(ProjectList.getSpecificProject(r.getProjectID()));
		
		// Update status of old supervisor projectList
		SupervisorList.getSpecificSupervisor(requesterName).checkAndSetProjectStatus();
		// SupervisorList.getSpecificSupervisor(r.getRequesterName()).checkAndSetProjectStatus();
		
		// Set new supervisor name to project
		ProjectList.getSpecificProject(projectID).setSupervisorName(SupervisorList.getSpecificSupervisorID(additionalInfo).getUserName());
		// ProjectList.getSpecificProject(r.getProjectID()).setSupervisorName(SupervisorList.getSpecificSupervisorID(r.getAdditionalInfo()).getUserName());
		
		// Set new supervisor email to project
		ProjectList.getSpecificProject(projectID).setSupervisorEmail(SupervisorList.getSpecificSupervisorID(additionalInfo).getEmail());
		
		// Add project to new supervisor projectList
		SupervisorList.getSpecificSupervisorID(additionalInfo).addProject(ProjectList.getSpecificProject(projectID));
		// SupervisorList.getSpecificSupervisorID(r.getAdditionalInfo()).addProject(ProjectList.getSpecificProject(r.getProjectID()));
		
		//Update status of new supervisor projectList
		SupervisorList.getSpecificSupervisorID(additionalInfo).checkAndSetProjectStatus();
		// SupervisorList.getSpecificSupervisorID(r.getAdditionalInfo()).checkAndSetProjectStatus();
		  
	}
}
