package models;

import enumclass.RequestStatus;
import enumclass.RequestType;
/**
 * This class is a change title request which is a subclass of the request class. The change title request class
 * inherits attributes and methods from the request class.
 * The change title request is a specific request made by a student to a supervisor in order to change the 
 * project tile of the project that they are part of.
 * @author Dennis Chen
 * @version 1.0
 */
public class ChangeTitleRequest extends Request{

	/**
	 * This contructs a change title request with a specified request id, requester's username, responder's username,
	 * project id of the project that requires processing, request status and additional information.
	 * 
	 * All of this information and the request type: change title will be feed into the super class request.
	 * 
	 * @param requestID the request id of the change title request.
	 * @param requesterName the requester's username of the change title request.
	 * @param responderName the responder's username of the change title request.
	 * @param projectID the project id of the project that requires processing in the change title request.
	 * @param status the request status of the change title request.
	 * @param additionalInfo the additional information of the change title request.
	 */
	public ChangeTitleRequest(int requestID, String requesterName, String responderName, int projectID, RequestStatus status, String additionalInfo) {
		super(requestID, requesterName, responderName, projectID, RequestType.CHANGE_TITLE, status, additionalInfo);
	}

	/**
	 * This will print all relevant details of the change title request.
	 */
	public void printRequestDetails() {
		System.out.println("Request ID: " + requestID);
		System.out.println("Requester Name: " + requesterName);
		System.out.println("Responder Name: " + responderName);
		System.out.println("Request Type: " + type);
		System.out.println("Request Status: " + status);
		System.out.println("Request to change project title of project ID " + projectID + " to \"" + additionalInfo + "\"\n" );
	}
	
	/**
	 * This is the method that checks whether our change title request is approved or rejected. 
	 * If approved, will update the request status and make use of another class methods to make the necessary changes.
	 * If rejected, will update the request status.
	 */
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
