package models;

import enumclass.ProjectStatus;

public class Project {

	private String studentName;
	private String studentEmail;
	private String supervisorName;
	private String supervisorEmail;
	private int projectID;
	private ProjectStatus status;
	private String projectTitle;
	
	public Project(int projectID, String supervisorName, String supervisorEmail, String studentName, String studentEmail, String projectTitle, ProjectStatus status) {
		this.projectID = projectID;
		this.supervisorName = supervisorName;
		this.supervisorEmail = supervisorEmail;
		this.studentName = studentName;
		this.studentEmail = studentEmail;
		this.projectTitle = projectTitle;
		this.status = status;
	}
	
	public void printProjectDetails() {
		if(status == ProjectStatus.ALLOCATED) {
			System.out.println("Project ID: " + projectID);
			System.out.println("Project Supervisor: " + supervisorName);
			System.out.println("Project Supervisor Email: " + supervisorEmail);
			System.out.println("Project Student: " + studentName);
			System.out.println("Project Student Email: " + studentEmail);
			System.out.println("Project Title: " + projectTitle);
			System.out.println("Project Status: " + status);
			System.out.println();
		}
		else {
			System.out.println("Project ID: " + projectID);
			System.out.println("Project Supervisor: " + supervisorName);
			System.out.println("Project Supervisor Email: " + supervisorEmail);
			System.out.println("Project Title: " + projectTitle);
			System.out.println("Project Status: " + status);
			System.out.println();
		}
		
	}
	
	public void removeStudent() {
		studentName = null;
		studentEmail = null;
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

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public String getSupervisorEmail() {
		return supervisorEmail;
	}

	public void setSupervisorEmail(String supervisorEmail) {
		this.supervisorEmail = supervisorEmail;
	}
	
	
}
