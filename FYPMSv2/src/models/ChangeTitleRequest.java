package models;

import enumclass.RequestStatus;
import enumclass.RequestType;

public class ChangeTitleRequest extends Request{

	public ChangeTitleRequest(int requestID, String requesterName, String responderName, int projectID, RequestStatus status, String additionalInfo) {
		super(requestID, requesterName, responderName, projectID, RequestType.CHANGE_TITLE, status, additionalInfo);
	}

	public void printRequestDetails() {
		System.out.println("Request ID: " + requestID);
		System.out.println("Requester Name: " + requesterName);
		System.out.println("Responder Name: " + responderName);
		System.out.println("Request Type: " + type);
		System.out.println("Request Status: " + status);
		System.out.println("Request to change project title of project ID " + projectID + " to \"" + additionalInfo + "\"\n" );
	}
	
	public void processRequest() {
		if(super.handleRequest()) {
			super.setStatus(RequestStatus.APPROVED);
			ProcessChangeTitleRequest.manageRequest(projectID, additionalInfo);
			System.out.println("The request have been accepted!");
			System.out.println("Returning back to the request menu...\n");
		}
		else {
			super.setStatus(RequestStatus.REJECTED);
			System.out.println("The request have been rejected!");
			System.out.println("Returning back to the request menu...\n");
		}	
	}
}
