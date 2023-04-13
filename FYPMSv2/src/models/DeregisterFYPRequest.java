package models;

import enumclass.RequestStatus;
import enumclass.RequestType;
/**
 * This class is a deregister fyp request which is a subclass of the request class. The deregister fyp request class
 * inherits attributes and methods from the request class.
 * The deregister fyp request is a specific request made by a student to a coordinator in order to remove the student
 * from the fyp project and programme.
 * @author Dennis Chen
 * @version 1.0
 */
public class DeregisterFYPRequest extends Request{

	/**
	 * This contructs a deregister fyp request with a specified request id, requester's username, responder's username,
	 * project id of the project that requires processing, request status and additional information.
	 * 
	 * All of this information and the request type: deregister fyp will be feed into the super class request.
	 * 
	 * @param requestID the request id of the deregister fyp request.
	 * @param requesterName the requester's username of the deregister fyp request.
	 * @param responderName the responder's username of the deregister fyp request.
	 * @param projectID the project id of the project that requires processing in the deregister fyp request.
	 * @param status the request status of the deregister fyp request.
	 * @param additionalInfo the additional information of the deregister fyp request.
	 */
	public DeregisterFYPRequest(int requestID, String requesterName, String responderName, int projectID, RequestStatus status, String additionalInfo) {
		super(requestID, requesterName, responderName, projectID, RequestType.DEREGISTER_FYP, status, additionalInfo);
	}

	/**
	 * This will print all relevant details of the deregister fyp request.
	 */
	public void printRequestDetails() {
		System.out.println("Request ID: " + requestID);
		System.out.println("Requester Name: " + requesterName);
		System.out.println("Responder Name: " + responderName);
		System.out.println("Request Type: " + type);
		System.out.println("Request Status: " + status);
		System.out.println("Requet to deregister from project ID " + projectID + "\n");

	}

	/**
	 * This is the method that checks whether our deregister fyp request is approved or rejected. 
	 * If approved, will update the request status and make use of another class methods to make the necessary changes.
	 * If rejected, will update the request status.
	 */
	public void processRequest() {
		if(super.handleRequest()) {
			super.setStatus(RequestStatus.APPROVED);
			ProcessDeregisterFYPRequest.manageRequest(requesterName, projectID);
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
