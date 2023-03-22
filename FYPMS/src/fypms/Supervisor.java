package fypms;

public class Supervisor extends User{
	private int supervisorIndex;
	private int projectOngoing = 0;
	
	public Supervisor(int supervisorIndex, String supervisorID, String supervisorName) {
		super(supervisorID, supervisorName);
		this.supervisorIndex = supervisorIndex;
	}
	
	public int getSupervisorIndex() {
		return supervisorIndex;
	}
	
	public String email() {
		return super.getUserID() + "@ntu.edu.sg";
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
