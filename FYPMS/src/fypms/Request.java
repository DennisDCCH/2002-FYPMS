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
	
	private Student s;
	private Supervisor ss;
	private Supervisor replacementSS;
	private Coordinator c;
	private Project p;
	private int requestID;
	private requestType type;
	private requestStatus status;
	private String projectTitle;
	
	//Change Title
	public Request(int requestID, Student s, Supervisor ss, requestType type, String projectTitle) {
		this.requestID = requestID;
		this.s = s;
		this.ss = ss;
		this.type = type;
		this.projectTitle = projectTitle;
		status = requestStatus.PENDING;
	}
	
	//Register or Deregister
	public Request(int requestID, Student s, Coordinator c, requestType type, Project p) {
		this.requestID = requestID;
		this.s = s;
		this.c = c;
		this.type = type;
		this.p = p;
		status = requestStatus.PENDING;
	}
	
	//Change Student
	public Request(int requestID, Supervisor ss, Coordinator c, requestType type, Supervisor replacementSS) {
		this.requestID = requestID;
		this.ss = ss;
		this.c = c;
		this.type = type;
		this.replacementSS = replacementSS;
		status = requestStatus.PENDING;
	}
}
