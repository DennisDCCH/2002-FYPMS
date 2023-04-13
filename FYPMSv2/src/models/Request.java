package models;

import java.util.Scanner;

import enumclass.RequestStatus;
import enumclass.RequestType;

/**
 * This class implements a request that is send out be a requestee and received by a responder. This request
 * can than be process by the responder and will make changes when it is processed.
 * @author Dennis Chen
 * @version 1.0
 *
 */
public abstract class Request {
	
	/**
	 * The request id of the request
	 */
	protected int requestID;
	
	/**
	 * The requester username of the request. 
	 * This is the user that send out this request.
	 */
	protected String requesterName;
	
	/**
	 * The responder username of the request.
	 * This is the user that is receiving this request.
	 */
	protected String responderName;
	
	/**
	 * The project id of the request.
	 * This refers to which project based on the project id is the one that needs changes.
	 */
	protected int projectID;
	
	/**
	 * The request type of the request
	 * The request can have 4 different request type which is change title, register fyp, deregister fyp and transfer student
	 */
	protected RequestType type;
	
	/**
	 * The request status of the request
	 * The request can have 3 different request status which is pending, approved and rejected.
	 */
	protected RequestStatus status;
	
	/**
	 * The additional information of the request
	 * This additional information will differ based on each request type but it will generally be a string variable
	 */
	protected String additionalInfo;
	
	/**
	 * This constructs a request with a specified request id, requester username, responder username, the project id of 
	 * the project that require proccessing, the request type, request status and additional info
	 * @param requestID the request id of the request
	 * @param requesterName the requester's username of the request
	 * @param responderName the responder's username of the request
	 * @param projectID the project id of the request
	 * @param type the request type of the request
	 * @param status the request status of the request
	 * @param additionalInfo the additional information of the request
	 */
	public Request(int requestID, String requesterName, String responderName, int projectID, RequestType type, RequestStatus status, String additionalInfo){
		this.requestID = requestID;
		this.requesterName = requesterName;
		this.responderName = responderName;
		this.projectID = projectID;
		this.type = type;
		this.status = status;
		this.additionalInfo = additionalInfo;
	}
	
	/**
	 * This method will print all relevant details of this project. The method here is an abstract method because 
	 * different request type will print different details.
	 */
	public abstract void printRequestDetails();
	
	/**
	 * This method is the one that will process the request. The method here is an abstract method because
	 * different request type will have different processes.
	 */
	public abstract void processRequest();
	
	/**
	 * This method gets a boolean value, and the difference in the boolean value indicates whether the request is
	 * approved or rejected.
	 * True indicates the request is approved
	 * False indicates the request is rejected
	 * @return
	 */
	protected boolean handleRequest() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("======================");
			System.out.println("|1. Approve          |");
			System.out.println("|2. Reject           |");
			System.out.println("======================");
			int choice = sc.nextInt();
			switch(choice) {
				case 1:
					return true;
					
				case 2:
					return false;
					
				default:
					System.out.println("Please choose a valid option\n");
					break;
			}
		}
	}

	/**
	 * This method gets the request id of the request
	 * @return the request's request id
	 */
	public int getRequestID() {
		return requestID;
	}

	/**
	 * This method gets the requester's username of the request
	 * @return the request's requester's username
	 */
	public String getRequesterName() {
		return requesterName;
	}

	/**
	 * This method gets the responder's username of the request
	 * @return the request's responder's username
	 */
	public String getResponderName() {
		return responderName;
	}

	/**
	 * This method get the project id of the project that requires processing in the request
	 * @return the request's project's project id.
	 */
	public int getProjectID() {
		return projectID;
	}

	/**
	 * This method get the request type of the request
	 * @return the request's request type
	 */
	public RequestType getType() {
		return type;
	}

	/**
	 * This method get the request status of the request
	 * @return the request's request status
	 */
	public RequestStatus getStatus() {
		return status;
	}

	/**
	 * This method overwrites the existing request status of the request and changes it to what is specified
	 * @param status this is the request's new request status
	 */
	public void setStatus(RequestStatus status) {
		this.status = status;
	}

	/**
	 * This method get the additional information of the request
	 * @return the request's additional information
	 */
	public String getAdditionalInfo() {
		return additionalInfo;
	} 
}
