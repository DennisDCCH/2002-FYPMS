package models;

import enumclass.RequestStatus;
import enumclass.RequestType;

public class DeregisterFYPRequest extends Request{

	public DeregisterFYPRequest(int requestID, String requesterName, String responderName, int projectID, RequestStatus status, String additionalInfo) {
		super(requestID, requesterName, responderName, projectID, RequestType.DEREGISTER_FYP, status, additionalInfo);
	}

	@Override
	public void printRequestDetails() {
		System.out.println("Request ID: " + requestID);
		System.out.println("Requester Name: " + requesterName);
		System.out.println("Responder Name: " + responderName);
		System.out.println("Request Type: " + type);
		System.out.println("Request Status: " + status);
		System.out.println("Requet to deregister from project ID " + projectID + "\n");
		System.out.println();
	}
}
