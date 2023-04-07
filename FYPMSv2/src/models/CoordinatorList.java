package models;

import java.util.List;

import ioclass.ReadCoordinatorCSV;

public class CoordinatorList {
	private static List <Coordinator> coordinatorList = ReadCoordinatorCSV.readCSV();
	
	public static Coordinator checkDomain(String userID){
		for (Coordinator c: coordinatorList) {
			if(c.getUserID().equals(userID)) 
				return c;
		}
		return null;
	}

	public static List<Coordinator> getCoordinatorList() {
		return coordinatorList;
	}
}
