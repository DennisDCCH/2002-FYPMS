package models;

public class ProcessChangeTitleRequest {

	public static void manageRequest(int projectID, String additionalInfo) {
		// r request id, requester name, responder name, project id, additonal info
		
		// Set new project title
		ProjectList.getSpecificProject(projectID).setProjectTitle(additionalInfo);
		// ProjectList.getSpecificProject(r.getProjectID()).setProjectTitle(r.getAdditionalInfo());
		
	}
}
