package fypms;

public class Supervisor extends User{
	private boolean pendingRequest;
	private int supervisorIndex;
	private int projectOngoing = 0;
	
	public Supervisor(int supervisorIndex, String supervisorID, String supervisorName) {
		super(supervisorID, supervisorName);
		this.supervisorIndex = supervisorIndex;
		pendingRequest = false;
	}
	
	public int getSupervisorIndex() {
		return supervisorIndex;
	}
	
	public String email() {
		return super.getUserID() + "@ntu.edu.sg";
	}

	public boolean isPendingRequest() {
		return pendingRequest;
	}

	public void setPendingRequest(boolean pendingRequest) {
		this.pendingRequest = pendingRequest;
	}

	public int getProjectOngoing() {
		return projectOngoing;
	}
	
	public void addProject() {
		projectOngoing++;
	}
	
	public void minusProject() {
		projectOngoing--;
	}
}
