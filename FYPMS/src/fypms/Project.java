package fypms;

import java.util.Scanner;

public class Project {
	Scanner sc = new Scanner(System.in);
	public enum Status{
		AVAILABLE,
		RESERVED,
		UNAVAILABLE,
		ALLOCATED,
		NULL,
	}
	private Student s;
	private Supervisor ss;
	private int projectID;
	private String projectTitle;
	private Status status;
	
	
	public Project(int projectID, Supervisor ss, String projectTitle) {
		this.ss = ss;
		this.projectTitle = projectTitle;
		this.projectID = projectID;
		status = Status.AVAILABLE;
	}

	//Getter Setter
	public Status getStatus() {
		return status;
	}

	public int getProjectID() {
		return projectID;
	}

	public String getProjectTitle() {
		return projectTitle;
	}

	public Student getS() {
		return s;
	}

	public Supervisor getSs() {
		return ss;
	}

	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}
}
