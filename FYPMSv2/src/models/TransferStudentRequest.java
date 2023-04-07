package models;

import enumclass.RequestStatus;
import enumclass.RequestType;

public class TransferStudentRequest extends Request{

	public TransferStudentRequest(int requestID, String requesterName, String responderName, int projectID, RequestStatus status, String additionalInfo) {
		super(requestID, requesterName, responderName, projectID, RequestType.TRANSFER_STUDENT, status, additionalInfo);
	}

	@Override
	public void printRequestDetails() {
		System.out.println("Request ID: " + requestID);
		System.out.println("Requester Name: " + requesterName);
		System.out.println("Responder Name: " + responderName);
		System.out.println("Request Type: " + type);
		System.out.println("Request Status: " + status);
		System.out.println("Request to transfer project ID " + projectID + " to " + additionalInfo + "\n");
		System.out.println();
	}
}
