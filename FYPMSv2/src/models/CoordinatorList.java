package models;

import java.util.List;

import ioclass.ReadCoordinatorCSV;

public class CoordinatorList {
	List <Coordinator> coordinatorList;
	
	public CoordinatorList() {
		ReadCoordinatorCSV csv = new ReadCoordinatorCSV();
		coordinatorList = csv.readCSV();
		
		for(Coordinator c: coordinatorList)
			System.out.println(c.getUserID());
	}
	
	public Coordinator checkDomain(String userID){
		for (Coordinator c: coordinatorList) {
			if(c.getUserID().equals(userID)) 
				return c;
		}
		return null;
	}
}
