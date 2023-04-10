package models;

import java.util.List;

import enumclass.RequestStatus;

public class User {
	protected String userName;
	protected String email;
	protected String userID;
	protected String password;
	protected List<Request> requestList;
	
	//Constructor
	public User(String userName, String email, String password) {
		this.userName = userName;
		this.email = email;
		String[] parts = email.split("@");
		userID = parts[0];
		this.password = password;
		
		requestList = RequestList.getUserSpecificRequestList(userName);
	}
	
	public void printMyRequest() {
		for(Request r: requestList)
			r.printRequestDetails();
	}
	
	public void printPendingRequest() {
		for(Request r: requestList) {
			if(r.getStatus() == RequestStatus.PENDING) {
				if(r.getResponderName().equals(userName))
					r.printRequestDetails();
			}
		}
	}
	
	public void addRequest(Request r) {
		requestList.add(r);
	}
	
	public boolean pendingRequest() {
		for(Request r: requestList) {
			if(r.getStatus() == RequestStatus.PENDING) {
				if(r.getResponderName().equals(userName))
					return true;
			}
		}
		return false;
	}
	
	public Request getRequest(int requestID) {
		for(Request r: requestList) {
			if(r.getRequestID() == requestID) {
				if(r.getStatus() == RequestStatus.PENDING)
					return r;
			}
		}
		return null;
	}

	//Getter Setter
	public String getUserName() {
		return userName;
	}

	public String getEmail() {
		return email;
	}

	public String getUserID() {
		return userID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Request> getRequestList() {
		return requestList;
	}
}
