package fypms;

public class Coordinator extends User{
	
	public Coordinator(String coordinatorID, String coordinatorEmail) {
		super(coordinatorID, coordinatorEmail);
	}
	
	public String email() {
		return super.getUserID() + "@ntu.edu.sg";
	}
}

