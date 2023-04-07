package models;

import enumclass.ProjectStatus;

public class Project {

	private String studentName;
	private String supervisorName;
	private int projectID;
	private ProjectStatus status;
	private String projectTitle;
	
	public Project(int projectID, String supervisorName, String studentName, String projectTitle, ProjectStatus status) {
		this.projectID = projectID;
		this.supervisorName = supervisorName;
		this.studentName = studentName;
		this.projectTitle = projectTitle;
		this.status = status;
	}
	
	public void printProject() {
		System.out.println("Project ID: " + projectID);
		System.out.println("Project Supervisor: " + supervisorName);
		System.out.println("Project Student: " + studentName);
		System.out.println("Project Title: " + projectTitle);
		System.out.println("Project Status: " + status);
	}
	
	//Getter Setter
	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getSupervisorName() {
		return supervisorName;
	}

	public void setSupervisorName(String supervisorName) {
		this.supervisorName = supervisorName;
	}

	public ProjectStatus getStatus() {
		return status;
	}

	public void setStatus(ProjectStatus status) {
		this.status = status;
	}

	public String getProjectTitle() {
		return projectTitle;
	}

	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}

	public int getProjectID() {
		return projectID;
	}
}
