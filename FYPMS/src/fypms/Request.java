package fypms;

public class Request {
	public enum requestType{
		REGISTER_FYP,
		CHANGE_TITLE,
		DEREGISTER_FYP,
		TRANSFER_STUDENT,
	}
	public enum requestStatus{
		APPROVED,
		REJECTED,
		PENDING,
	}
	//Who is sending the request
	private Student sSender;
	private Supervisor ssSender;
	
	//Who is receiving the request
	private Supervisor ssReceiver;
	private Coordinator cReceiver;
	
	//General information for request
	private int requestID;
	private requestType type;
	private requestStatus status;
	
	//Specific request type information
	private Supervisor replacementSS;
	private Project p;
	private String projectTitle;
	
	//Change Title Request
	public Request(int requestID, Student s, Supervisor ss, requestType type, String projectTitle) {
		this.requestID = requestID;
		sSender = s;
		ssReceiver = ss;
		this.type = type;
		this.projectTitle = projectTitle;
		status = requestStatus.PENDING;
	}
	
	//Register or Deregister Request
	public Request(int requestID, Student s, Coordinator c, requestType type, Project p) {
		this.requestID = requestID;
		sSender = s;
		cReceiver = c;
		this.type = type;
		this.p = p;
		status = requestStatus.PENDING;
	}
	
	//Change Student Request
	public Request(int requestID, Supervisor ss, Coordinator c, requestType type, Supervisor replacementSS) {
		this.requestID = requestID;
		ssSender = ss;
		cReceiver = c;
		this.type = type;
		this.replacementSS = replacementSS;
		status = requestStatus.PENDING;
	}
	
	//Setter Getter
	public Student getsSender() {
		return sSender;
	}

	public Supervisor getSsSender() {
		return ssSender;
	}

	public Supervisor getSsReceiver() {
		return ssReceiver;
	}

	public Coordinator getcReceiver() {
		return cReceiver;
	}
	
	public Supervisor getReplacementSS() {
		return replacementSS;
	}

	public Project getP() {
		return p;
	}

	public requestStatus getStatus() {
		return status;
	}

	public void setStatus(requestStatus status) {
		this.status = status;
	}

	public requestType getType() {
		return type;
	}

	public int getRequestID() {
		return requestID;
	}

	public String getProjectTitle() {
		return projectTitle;
	}
		
}
