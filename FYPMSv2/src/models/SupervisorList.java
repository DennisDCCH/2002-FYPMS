package models;

import java.util.List;

import ioclass.ReadSupervisorCSV;

public class SupervisorList {
	List <Supervisor> supervisorList;
	
	public SupervisorList() {
		ReadSupervisorCSV csv = new ReadSupervisorCSV();
		supervisorList = csv.readCSV();
	}
}
