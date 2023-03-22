package fypms;

import java.util.ArrayList;
import fypms.Request.requestType;

public class RequestList {
	private int requestID = 1;
	ArrayList<Request> requestList;
	
	public RequestList() {
		requestList = new ArrayList<Request>();
	}
	
	//Adding new request to array
	public void addChangeTitleRequest(Student s, Supervisor ss, String projectTitle) {
		Request r = new Request(requestID, s, ss, requestType.CHANGE_TITLE, projectTitle);
		requestID++;
		
		requestList.add(r);
	}
	
	public void addRegisterFYPRequest(Student s, Coordinator c, Project p) {
		Request r = new Request(requestID, s, c, requestType.REGISTER_FYP, p);
		requestID++;
		
		requestList.add(r);
	}
	
	public void addDeregisterFYPRequest(Student s, Coordinator c, Project p) {
		Request r = new Request(requestID, s, c, requestType.DEREGISTER_FYP, p);
		requestID++;
		
		requestList.add(r);
	}
	
	public void addChangeStudentRequest(Supervisor ss, Coordinator c, Supervisor replacementSS) {
		Request r = new Request(requestID, ss, c, requestType.TRANSFER_STUDENT, replacementSS);
		requestID++;
		
		requestList.add(r);
	}
}
