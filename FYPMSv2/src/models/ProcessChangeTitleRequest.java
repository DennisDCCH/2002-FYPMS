package models;

public class ProcessChangeTitleRequest {

	public static void manageRequest(Request r) {
		// r request id, requester name, responder name, project id, additonal info
		
		// Set new project title
		ProjectList.getSpecificProject(r.getProjectID()).setProjectTitle(r.getAdditionalInfo());
		
	}
}
