package models;

import java.util.List;

import ioclass.ReadCoordinatorCSV;

/**
 * This class is one that contains a list of coordinators in the fyp management system. It stores all the information
 * of all coordinators.
 * @author Dennis Chen
 * @version 1.0
 *
 */
public class CoordinatorList {
	
	/**
	 * This is a list of coordinators stored in the coordinatorlist class.
	 */
	private static List <Coordinator> coordinatorList;
	
	/**
	 * This method initialise the list of coordinator through the use of another class method.
	 */
	public static void initalise() {
		coordinatorList = ReadCoordinatorCSV.readCSV();
	}
	
	/**
	 * This method gets the coordinator that is in the coordinatorlist's list of coordinator based on what is the
	 * userid inputted. If such a userid is not found in the list, it will get nothing.
	 * @param userID this is the specific userid of the coordinator that wants to get back.
	 * @return a specific coordinator in coordinatorlist's list of coordinator.
	 */
	public static Coordinator checkDomain(String userID){
		for (Coordinator c: coordinatorList) {
			if(c.getUserID().equals(userID)) 
				return c;
		}
		return null;
	}

	/**
	 * This method gets the entire list of coordinator of the coordinatorlist class.
	 * @return this coordinatorlist's list of coordinator.
	 */
	public static List<Coordinator> getCoordinatorList() {
		return coordinatorList;
	}
}
