package models;


import java.util.ArrayList;
import java.util.List;

import ioclass.ReadRequestCSV;
/**
 * This class is one that contains a list of request in the fyp management system. It stores all the information
 * of all requests.
 * @author Dennis Chen
 * @version 1.0
 *
 */
public class RequestList {
	
	/**
	 * This is a list of request stored in the requestlist class.
	 */
	private static List<Request> requestList;
	
	/**
	 * This method initialise the list of request through the use of another class method.
	 */
	public static void intialise() {
		requestList = ReadRequestCSV.readCSV();
	}
	
	/**
	 * This method will add a new request object into the requestlist's list of request.
	 * @param r This is the new request object.
	 */
	public static void addRequest(Request r) {
		requestList.add(r);
	}

	/**
	 * This method gets all the request in the list of request that have the username in the request object, be it 
	 * be the request's resquester or request's responder. It will run through all the request and append it into a new
	 * list of request
	 * @param userName this is the specific username of that wants to get back in all request
	 * @return the list of request with this particular username in it.
	 */
	public static List<Request> getUserSpecificRequestList(String userName){
		List<Request> newList = new ArrayList<Request>();
		for(Request r: requestList) {
			if(r.getRequesterName().equals(userName))
				newList.add(r);
			if(r.getResponderName().equals(userName))
				newList.add(r);
		}
		return newList;
	}
	
	/**
	 * This method gets the next request id by tabulating what is the size of the current list of request.
	 * @return the next request id.
	 */
	public static int getNextRequestID() {
		return requestList.size() + 1;
	}

	/**
	 * This method gets the entire list of request of the requestlist class.
	 * @return this requestlist's list of request.
	 */
	public static List<Request> getRequestList() {
		return requestList;
	}
	
	
}
