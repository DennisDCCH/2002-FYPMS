package fypms;

public class Coordinator extends User{
	private boolean pendingRequest;
	
	public Coordinator(String coordinatorID, String coordinatorEmail) {
		super(coordinatorID, coordinatorEmail);
	}
	
	public String email() {
		return userID + "@ntu.edu.sg";
	}

	public boolean isPendingRequest() {
		return pendingRequest;
	}

	public void setPendingRequest(boolean pendingRequest) {
		this.pendingRequest = pendingRequest;
	}
}

