package fypms;

import java.util.ArrayList;

import fypms.Project.Status;
import fypms.Request.requestStatus;
import fypms.Request.requestType;

public class RequestList {
	private int requestID = 1;
	ArrayList<Request> requestList;
	
	public RequestList() {
		requestList = new ArrayList<Request>();
	}
	
	//Adding new request to array
	public void addChangeTitleRequest(Student s, Supervisor ss, String projectTitle, Project p) {
		Request r = new Request(requestID, s, ss, requestType.CHANGE_TITLE, projectTitle, p);
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
	
	public void addChangeStudentRequest(Supervisor ss, Coordinator c, Supervisor replacementSS, Project p) {
		Request r = new Request(requestID, ss, c, requestType.TRANSFER_STUDENT, replacementSS, p);
		requestID++;
		
		requestList.add(r);
	}
	
	public Request getRequest(int index) {
		for(Request r: requestList) {
			if(r.getRequestID() == index)
				return r;
		}
		return null;
	}
	
	//Checking for pending request
	public boolean checkSupervisorPendingRequest(Supervisor ss) {
		for(Request r: requestList) {
			if(r.getSsReceiver() == ss) {
				if(r.getStatus() == requestStatus.PENDING)
					return true;
			}
		}
		return false;
	}
	
	public boolean checkCoordinatorPendingRequest(Coordinator c) {
		for(Request r: requestList) {
			if(r.getcReceiver() == c) {
				if(r.getStatus() == requestStatus.PENDING)
					return true;
			}
		}
		return false;
	}
	
	//All Printing methods
	//For student sender only - have 3 kinds of request
	public void printStudentSendRequest(Student s) {
		for(Request r: requestList) {
			if(r.getsSender() == s) {
				System.out.println("Request ID: " + r.getRequestID());
				System.out.println("Requester: " + r.getsSender().getUserName());
				System.out.println("Request Type: " + r.getType());
				System.out.println("Request Status: " + r.getStatus());
				if(r.getType() == requestType.REGISTER_FYP) {
					System.out.println("Request from " + r.getsSender().getUserName() + " to register for ProjectID " + r.getP().getProjectID());
				}
				else if(r.getType() == requestType.DEREGISTER_FYP) {
					System.out.println("Request from " + r.getsSender().getUserName() + " to deregister for ProjectID " + r.getP().getProjectID());
				}
				else if(r.getType() == requestType.CHANGE_TITLE) {
					System.out.println("The proposed new title is: " + r.getProjectTitle());
				}
				System.out.println();
			}
		}
	}
	//For supervisor sender only - only change student request
	public void printSupervisorSendRequest(Supervisor ss) {
		for(Request r: requestList) {
			if(r.getSsSender() == ss) {
				System.out.println("Request ID: " + r.getRequestID());
				System.out.println("Requester: " + r.getSsSender().getUserName());
				System.out.println("Request Type: " + r.getType());
				System.out.println("Request Status: " + r.getStatus());
				System.out.println("Request from " + r.getSsSender().getUserName() + " to transfer ProjectID " + r.getP().getProjectID() + " to " + r.getReplacementSS().getUserName());
				System.out.println();
			}
		}
	}
	//For supervisor receiver only - only have change title request
	public void printSupervisorReceiveRequest(Supervisor ss) {
		for(Request r: requestList) {
			if(r.getSsReceiver() == ss) {
				System.out.println("Request ID: " + r.getRequestID());
				System.out.println("Requester: " + r.getsSender().getUserName());
				System.out.println("Request Type: " + r.getType());
				System.out.println("Request Status: " + r.getStatus());
				System.out.println("The proposed new title is: " + r.getProjectTitle());
				System.out.println();
			}
		}
	}
	
	public void printSupervisorPendingRequest(Supervisor ss) {
		for(Request r: requestList) {
			if(r.getSsReceiver() == ss) {
				if(r.getStatus() == requestStatus.PENDING) {
					System.out.println("Request ID: " + r.getRequestID());
					System.out.println("Requester: " + r.getsSender().getUserName());
					System.out.println("Request Type: " + r.getType());
					System.out.println("Request Status: " + r.getStatus());
					System.out.println("The proposed new title is: " + r.getProjectTitle());
					System.out.println();
				}
			}
		}
	}
	//For coordinator receiver only - have 3 kinds of request
	public void printCoordinatorReceiveRequest(Coordinator c) {
		
		for(Request r: requestList) {
			if(r.getcReceiver() == c) {
				if(r.getType() == requestType.REGISTER_FYP) {
					System.out.println("Request ID: " + r.getRequestID());
					System.out.println("Requester: " + r.getsSender().getUserName());
					System.out.println("Request Type: " + r.getType());
					System.out.println("Request Status: " + r.getStatus());
					System.out.println("Request from " + r.getsSender().getUserName() + " to register for ProjectID " + r.getP().getProjectID());
					
				}
				else if(r.getType() == requestType.DEREGISTER_FYP) {
					System.out.println("Request ID: " + r.getRequestID());
					System.out.println("Requester: " + r.getsSender().getUserName());
					System.out.println("Request Type: " + r.getType());
					System.out.println("Request Status: " + r.getStatus());
					System.out.println("Request from " + r.getsSender().getUserName() + " to deregister for ProjectID " + r.getP().getProjectID());
					
				}
				else if(r.getType() == requestType.TRANSFER_STUDENT) {
					System.out.println("Request ID: " + r.getRequestID());
					System.out.println("Requester: " + r.getSsSender().getUserName());
					System.out.println("Request Type: " + r.getType());
					System.out.println("Request Status: " + r.getStatus());
					System.out.println("Request from " + r.getSsSender().getUserName() + " to transfer ProjectID " + r.getP().getProjectID() + " to " + r.getReplacementSS().getUserName());
				}
				System.out.println();
			}
		}
	}
	
public void printCoordinatorPendingRequest(Coordinator c) {
		
		for(Request r: requestList) {
			if(r.getcReceiver() == c) {
				if(r.getStatus() == requestStatus.PENDING) {
					if(r.getType() == requestType.REGISTER_FYP) {
						System.out.println("Request ID: " + r.getRequestID());
						System.out.println("Requester: " + r.getsSender().getUserName());
						System.out.println("Request Type: " + r.getType());
						System.out.println("Request Status: " + r.getStatus());
						System.out.println("Request from " + r.getsSender().getUserName() + " to register for ProjectID " + r.getP().getProjectID());
						
					}
					else if(r.getType() == requestType.DEREGISTER_FYP) {
						System.out.println("Request ID: " + r.getRequestID());
						System.out.println("Requester: " + r.getsSender().getUserName());
						System.out.println("Request Type: " + r.getType());
						System.out.println("Request Status: " + r.getStatus());
						System.out.println("Request from " + r.getsSender().getUserName() + " to deregister for ProjectID " + r.getP().getProjectID());
						
					}
					else if(r.getType() == requestType.TRANSFER_STUDENT) {
						System.out.println("Request ID: " + r.getRequestID());
						System.out.println("Requester: " + r.getSsSender().getUserName());
						System.out.println("Request Type: " + r.getType());
						System.out.println("Request Status: " + r.getStatus());
						System.out.println("Request from " + r.getSsSender().getUserName() + " to transfer ProjectID " + r.getP().getProjectID() + " to " + r.getReplacementSS().getUserName());
					}
					System.out.println();
				}
			}
		}
	}
}
