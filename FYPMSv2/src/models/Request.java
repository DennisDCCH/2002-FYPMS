package models;

import enumclass.RequestStatus;
import enumclass.RequestType;

public abstract class Request {
	protected int requestID;
	protected String requesterName;
	protected String responderName;
	protected int projectID;
	protected RequestType type;
	protected RequestStatus status;
	
	//This will change based on what is the request type
	protected String additionalInfo;
	
	public Request(int requestID, String requesterName, String responderName, int projectID, RequestType type, RequestStatus status, String additionalInfo){
		this.requestID = requestID;
		this.requesterName = requesterName;
		this.responderName = responderName;
		this.projectID = projectID;
		this.type = type;
		this.status = status;
		this.additionalInfo = additionalInfo;
	}
	
	public abstract void printRequestDetails();

	public int getRequestID() {
		return requestID;
	}

	public String getRequesterName() {
		return requesterName;
	}

	public String getResponderName() {
		return responderName;
	}

	public int getProjectID() {
		return projectID;
	}

	public RequestType getType() {
		return type;
	}

	public RequestStatus getStatus() {
		return status;
	}

	public void setStatus(RequestStatus status) {
		this.status = status;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	} 
}
