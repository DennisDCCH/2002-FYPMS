package models;

import java.util.List;

import ioclass.ReadCoordinatorCSV;

public class CoordinatorList {
	List <Coordinator> coordinatorList;
	
	public CoordinatorList() {
		coordinatorList = ReadCoordinatorCSV.readCSV();
	}
	
	public Coordinator checkDomain(String userID){
		for (Coordinator c: coordinatorList) {
			if(c.getUserID().equals(userID)) 
				return c;
		}
		return null;
	}

	public List<Coordinator> getCoordinatorList() {
		return coordinatorList;
	}
}
