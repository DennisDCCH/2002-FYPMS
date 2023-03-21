package fypms;

public class CoordinatorList {
	Coordinator c;;
	
	public CoordinatorList() {
		c = new Coordinator("ASFLI", "Li Fang");
	}

	public Coordinator checkDomain(String userID){
		if(c.getUserID().equals(userID)) 
			return c;
		return null;
	}
}
