package models;

import enumclass.RequestStatus;
import enumclass.RequestType;

/**
 * This class is a transfer student request which is a subclass of the request class. The transfer student request class
 * inherits attributes and methods from the request class.
 * The register transfer student request is a specific request made by a supervisor to a coordinator in order to change
 * the supervisor of the project.
 * @author Dennis Chen
 * @version 1.0
 */
public class TransferStudentRequest extends Request{

	/**
	 * This contructs a transfer student request with a specified request id, requester's username, responder's username,
	 * project id of the project that requires processing, request status and additional information.
	 * 
	 * All of this information and the request type: transfer student will be feed into the super class request.
	 * 
	 * @param requestID the request id of the register fyp request.
	 * @param requesterName the requester's username of the register fyp request.
	 * @param responderName the responder's username of the register fyp request.
	 * @param projectID the project id of the project that requires processing in the register fyp request.
	 * @param status the request status of the register fyp request.
	 * @param additionalInfo the additional information of the register fyp request.
	 */
	public TransferStudentRequest(int requestID, String requesterName, String responderName, int projectID, RequestStatus status, String additionalInfo) {
		super(requestID, requesterName, responderName, projectID, RequestType.TRANSFER_STUDENT, status, additionalInfo);
	}

	/**
	 * This will print all relevant details of the transfer student request.
	 */
	public void printRequestDetails() {
		System.out.println("Request ID: " + requestID);
		System.out.println("Requester Name: " + requesterName);
		System.out.println("Responder Name: " + responderName);
		System.out.println("Request Type: " + type);
		System.out.println("Request Status: " + status);
		System.out.println("Request to transfer project ID " + projectID + " to " + additionalInfo + "\n");
	}
	
	/**
	 * This is the method that checks whether our transfer student request is approved or rejected. 
	 * If approved, will update the request status and make use of another class methods to make the necessary changes.
	 * If rejected, will update the request status.
	 */
	public void processRequest() {
		if(super.handleRequest()) {
			super.setStatus(RequestStatus.APPROVED);
			ProcessTransferStudentRequest.manageRequest(requesterName, projectID, additionalInfo);
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
