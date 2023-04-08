package models;

import java.util.List;

import ioclass.ReadSupervisorCSV;

public class SupervisorList {
	private static List <Supervisor> supervisorList;
	
	public static void initialise() {
		supervisorList = ReadSupervisorCSV.readCSV();
	}
	
	public static Supervisor checkDomain(String userID){
		for (Supervisor s: supervisorList) {
			if(s.getUserID().equals(userID)) 
				return s;
		}
		return null;
	}
	
	public static Supervisor getSpecificSupervisor(String supervisorName) {
		for(Supervisor s: supervisorList) {
			if(s.getUserName().equals(supervisorName))
				return s;
		}
		return null;
	}
	
	public static Supervisor getSpecificSupervisorID(String supervisorID) {
		for(Supervisor s: supervisorList) {
			if(s.getUserID().equals(supervisorID))
				return s;
		}
		return null;
	}

	public static List<Supervisor> getSupervisorList() {
		return supervisorList;
	}
}
