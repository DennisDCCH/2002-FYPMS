package models;

import enumclass.RequestStatus;
import enumclass.RequestType;

/**
 * This class is a register fyp request which is a subclass of the request class. The register fyp request class
 * inherits attributes and methods from the request class.
 * The register fyp request is a specific request made by a student to a coordinator in order to add the student
 * into a fyp project of the student choice.
 * @author Dennis Chen
 * @version 1.0
 */
public class RegisterFYPRequest extends Request{

	/**
	 * This contructs a register fyp request with a specified request id, requester's username, responder's username,
	 * project id of the project that requires processing, request status and additional information.
	 * 
	 * All of this information and the request type: register fyp will be feed into the super class request.
	 * 
	 * @param requestID the request id of the register fyp request.
	 * @param requesterName the requester's username of the register fyp request.
	 * @param responderName the responder's username of the register fyp request.
	 * @param projectID the project id of the project that requires processing in the register fyp request.
	 * @param status the request status of the register fyp request.
	 * @param additionalInfo the additional information of the register fyp request.
	 */
	public RegisterFYPRequest(int requestID, String requesterName, String responderName, int projectID, RequestStatus status, String additionalInfo) {
		super(requestID, requesterName, responderName, projectID, RequestType.REGISTER_FYP, status, additionalInfo);
	}

	/**
	 * This will print all relevant details of the register fyp request.
	 */
	public void printRequestDetails() {
		System.out.println("Request ID: " + requestID);
		System.out.println("Requester Name: " + requesterName);
		System.out.println("Responder Name: " + responderName);
		System.out.println("Request Type: " + type);  
		System.out.println("Request Status: " + status);
		System.out.println("Request to register for project ID " + projectID + "\n");
	}

	/**
	 * This is the method that checks whether our register fyp request is approved or rejected. 
	 * If approved, will update the request status and make use of another class methods to make the necessary changes.
	 * If rejected, will update the request status and make use of another class methods to make the necessary changes.
	 */
	public void processRequest() {
		if(super.handleRequest()) {
			super.setStatus(RequestStatus.APPROVED);
			ProcessRegisterFYPRequest.manageRequest(projectID, requesterName, additionalInfo);
			System.out.println("The request have been accepted!");
			System.out.println("Returning back to the request menu...\n");
		}
		else {
			super.setStatus(RequestStatus.REJECTED);
			ProcessRegisterFYPRequest.rejectRequest(projectID);
			System.out.println("The request have been rejected!");
			System.out.println("Returning back to the request menu...\n");
		}	
	}
}
