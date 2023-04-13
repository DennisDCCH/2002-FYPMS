package models;

import java.util.List;

import ioclass.ReadSupervisorCSV;

/**
 * This class is one that contains a list of supervisors in the fyp management system. It stores all the information
 * of all supervisors.
 * @author Dennis Chen
 * @version 1.0
 *
 */
public class SupervisorList {
	
	/**
	 * This is a list of supervisors stored in the supervisorlist class.
	 */
	private static List <Supervisor> supervisorList;
	
	/**
	 * This method initialise the list of supervisors through the use of another class method.
	 */
	public static void initialise() {
		supervisorList = ReadSupervisorCSV.readCSV();
	}
	
	/**
	 * This method gets the supervisors that is in the supervisorlist's list of supervisors based on what is the
	 * userid inputted. If such a userid is not found in the list, it will get nothing.
	 * @param userID this is the specific userid of the supervisors that wants to get back.
	 * @return a specific supervisor in supervisorlist's list of supervisors.
	 */
	public static Supervisor checkDomain(String userID){
		for (Supervisor s: supervisorList) {
			if(s.getUserID().equals(userID)) 
				return s;
		}
		return null;
	}
	
	/**
	 * This method gets the supervisors that is in the supervisorlist's list of supervisors based on what is the
	 * username inputted. If such a userid is not found in the list, it will get nothing.
	 * @param supervisorName this is the specific username of the supervisors that wants to get back.
	 * @return a specific supervisor in supervisorlist's list of supervisors.
	 */
	public static Supervisor getSpecificSupervisor(String supervisorName) {
		for(Supervisor s: supervisorList) {
			if(s.getUserName().equals(supervisorName))
				return s;
		}
		return null;
	}
	
	/**
	 * This method gets the supervisors that is in the supervisorlist's list of supervisors based on what is the
	 * username inputted. If such a userid is not found in the list, it will get nothing.
	 * @param supervisorID this is the specific username of the supervisors that wants to get back.
	 * @return a specific supervisor in supervisorlist's list of supervisors.
	 */
	public static Supervisor getSpecificSupervisorID(String supervisorID) {
		for(Supervisor s: supervisorList) {
			if(s.getUserID().equals(supervisorID))
				return s;
		}
		return null;
	}

	/**
	 * This method gets the entire list of supervisors of the supervisorlist class.
	 * @return this supervisorlist's list of supervisor.
	 */
	public static List<Supervisor> getSupervisorList() {
		return supervisorList;
	}
}
