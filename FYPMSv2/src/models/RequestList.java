package models;

import java.util.ArrayList;
import java.util.List;

import ioclass.ReadRequestCSV;

public class RequestList {
	private static List<Request> requestList;
	
	public static void intialise() {
		requestList = ReadRequestCSV.readCSV();
	}
	
	public static void addRequest(Request r) {
		requestList.add(r);
	}
	
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
	
	public static int getNextRequestID() {
		return requestList.size() + 1;
	}

	public static List<Request> getRequestList() {
		return requestList;
	}
	
	
}
