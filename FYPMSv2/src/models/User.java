package models;

import java.util.List;

import enumclass.RequestStatus;
/**
 * This class implements a user of the FYP management system. 
 * @author Dennis Chen
 * @version 1.0
 *
 */
public class User {
	
	/**
	 * The username of the user
	 */
	protected String userName;
	
	/**
	 * The email of the user
	 */
	protected String email;
	
	/**
	 * The userid of the user
	 */
	protected String userID;
	
	/**
	 * The password of the user
	 */
	protected String password;
	
	/**
	 * This is a list of request that is directed to or send out by the user. Request is a object class.
	 * So this is a list of objects
	 */
	protected List<Request> requestList;
	
	/**
	 * This constructs a user with a specified username, email and password. 
	 * Afterwards, from the email of the user, we will attain the user's userid which is the component in the email before '@'.
	 * We also attain all of the request that is directed or send out by the user based on his username 
	 * through the use of another class method and put it in user's request list.
	 * 
	 * @param userName the username of the user.
	 * @param email the email of the user.
	 * @param password the password of the user.
	 */
	public User(String userName, String email, String password) {
		this.userName = userName;
		this.email = email;
		String[] parts = email.split("@");
		userID = parts[0];
		this.password = password;
		
		requestList = RequestList.getUserSpecificRequestList(userName);
	}
	
	/**
	 * This method will print out all the details of every request in the user's list of request.
	 */
	public void printMyRequest() {
		for(Request r: requestList)
			r.printRequestDetails();
	}
	
	/**
	 * This method will print out all the details of only the request with a request status of pending in the user's list of request.
	 */
	public void printPendingRequest() {
		for(Request r: requestList) {
			if(r.getStatus() == RequestStatus.PENDING) {
				if(r.getResponderName().equals(userName))
					r.printRequestDetails();
			}
		}
	}
	
	/**
	 * This method will add a new request object into the user's request list.
	 * @param r This is the new request object.
	 */
	public void addRequest(Request r) {
		requestList.add(r);
	}
	
	/**
	 * This method checks for in the user's request list, does the user have any pending request that is requires his attention and 
	 * input. Note that this is only applicable to the requests that is directed to the user, not send out by the user.
	 * @return true of false boolean value depending on if there is any pending request directed to the user.
	 */
	public boolean pendingRequest() {
		for(Request r: requestList) {
			if(r.getStatus() == RequestStatus.PENDING) {
				if(r.getResponderName().equals(userName))
					return true;
			}
		}
		return false;
	}
	
	/**
	 * This method gets the request that is in the user's request list based on what is the request id inputted. If such a request 
	 * id is not found in the user's request list, it will get nothing.
	 * @param requestID This is the value of the request id that you want to get back.
	 * @return the request object of the specificed request id.
	 */
	public Request getRequest(int requestID) {
		for(Request r: requestList) {
			if(r.getRequestID() == requestID) {
				if(r.getStatus() == RequestStatus.PENDING)
					return r;
			}
		}
		return null;
	}

	/**
	 * This method gets the username of the user
	 * @return this user's username
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * This method gets the email of the user
	 * @return this user's email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * This method gets the userid of the user
	 * @return this user's userid
	 */
	public String getUserID() {
		return userID;
	}

	/**
	 * This method gets the password of the user
	 * @return this user's password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * This method overwrite the existing password the user and changes it to what is specified
	 * @param password this is the user's new password.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * This method gets the entire list of request of the user
	 * @return this user's list of request
	 */
	public List<Request> getRequestList() {
		return requestList;
	}
}
