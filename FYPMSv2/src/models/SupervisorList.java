package models;

import java.util.List;

import ioclass.ReadSupervisorCSV;

public class SupervisorList {
	List <Supervisor> supervisorList;
	
	public SupervisorList() {
		ReadSupervisorCSV csv = new ReadSupervisorCSV();
		supervisorList = csv.readCSV();
	}
	
	public Supervisor checkDomain(String userID){
		for (Supervisor s: supervisorList) {
			if(s.getUserID().equals(userID)) 
				return s;
		}
		return null;
	}
}
