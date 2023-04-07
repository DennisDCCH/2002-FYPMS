package models;

import java.util.List;

import ioclass.ReadSupervisorCSV;

public class SupervisorList {
	private static List <Supervisor> supervisorList = ReadSupervisorCSV.readCSV();
	
	public static Supervisor checkDomain(String userID){
		for (Supervisor s: supervisorList) {
			if(s.getUserID().equals(userID)) 
				return s;
		}
		return null;
	}

	public static List<Supervisor> getSupervisorList() {
		return supervisorList;
	}
}
