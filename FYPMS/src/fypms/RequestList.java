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
	public void addRequest(Student s, Supervisor ss, requestType type) {
		Request r = new Request(requestID, s, ss, type);
		requestID++;
		
		requestList.add(r);
	}
}
