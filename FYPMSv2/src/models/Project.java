package models;

import enumclass.ProjectStatus;
/**
 * This class implements a project that can be taken up by supervisors and students in the FYP management system
 * @author Dennis Chen
 * @version 1.0
 */
public class Project {

	/**
	 * The username of the student that is taking this project
	 */
	private String studentName;
	
	/**
	 * The email of the student that is taking this project
	 */
	private String studentEmail;
	
	/**
	 * The username of the supervisor that is taking this project
	 */
	private String supervisorName;
	
	/**
	 * The email of the supervisor that is taking this project
	 */
	private String supervisorEmail;
	
	/**
	 * The project id of the project
	 */
	private int projectID;
	
	/**
	 * The project status of the project.
	 * The project can have 4 different status which is available, reserved, allocated, unavailable.
	 */
	private ProjectStatus status;
	
	/**
	 * The project title of the project.
	 */
	private String projectTitle;
	
	
	/**
	 * This constructs a project with a specified project id, supervisor name, supervisor email, student name, student email,
	 * project title, and status.
	 * @param projectID the project id of the project
	 * @param supervisorName the supervisor's username of the project
	 * @param supervisorEmail the supervisor's email of the project
	 * @param studentName the student's username of the project
	 * @param studentEmail the student's email of the project
	 * @param projectTitle the project title of the project
	 * @param status the status of the project
	 */
	public Project(int projectID, String supervisorName, String supervisorEmail, String studentName, String studentEmail, String projectTitle, ProjectStatus status) {
		this.projectID = projectID;
		this.supervisorName = supervisorName;
		this.supervisorEmail = supervisorEmail;
		this.studentName = studentName;
		this.studentEmail = studentEmail;
		this.projectTitle = projectTitle;
		this.status = status;
	}
	
	/**
	 * This method prints all relevant details of this project. When the project status is allocated, it will print out everything
	 * When the project status is not allocated, it will print everything but the student's username and email.
	 */
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
	
	/**
	 * This method overwrites the student's username and email to be nothing. When the student is removed from the
	 * project, his particulars needs to be erased as well.
	 */
	public void removeStudent() {
		studentName = null;
		studentEmail = null;
	}
	
	/**
	 * This method gets the student's username of the project
	 * @return this project's student's username
	 */
	public String getStudentName() {
		return studentName;
	}
	
	/**
	 * This method overwrites the existing student's name of the project and changes it to what is specified 
	 * @param studentName this is the project's new student's username
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	/**
	 * This method gets the supervisor's username of the project
	 * @return this project's supervisor's username
	 */
	public String getSupervisorName() {
		return supervisorName;
	}

	/**
	 * This method overwrites the existing supervisor's name of the project and changes it to what is specified 
	 * @param supervisorName this is the project's new supervisor's username
	 */
	public void setSupervisorName(String supervisorName) {
		this.supervisorName = supervisorName;
	}

	/**
	 * This method get the current status of the project 
	 * @return this project's status 
	 */
	public ProjectStatus getStatus() {
		return status;
	}

	/**
	 * This method overwrites the existing status of the project and changes it to what is specified
	 * @param status this is the project's new status
	 */
	public void setStatus(ProjectStatus status) {
		this.status = status;
	}

	/**
	 * This method get the project title of the project
	 * @return this project's project title
	 */
	public String getProjectTitle() {
		return projectTitle;
	}

	/**
	 * This method overwrites the existing project title of the project and changes it to what is specifed
	 * @param projectTitle this is the project's new project title
	 */
	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}
	
	/**
	 * This method get the project id of the project
	 * @return this project's project id
	 */
	public int getProjectID() {
		return projectID;
	}

	/**
	 * This method gets the student's email of the project
	 * @return this project's student's email
	 */
	public String getStudentEmail() {
		return studentEmail;
	}

	/**
	 * This method overwrites the existing student's email of the project and changes it to what is specified 
	 * @param studentEmail this is the project's new student's email
	 */
	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}
	
	/**
	 * This method gets the supervisor's email of the project
	 * @return this project's supervisor's email
	 */
	public String getSupervisorEmail() {
		return supervisorEmail;
	}

	/**
	 * This method overwrites the existing supervisor's email of the project and changes it to what is specified 
	 * @param supervisorEmail this is the project's new supervisor's email
	 */
	public void setSupervisorEmail(String supervisorEmail) {
		this.supervisorEmail = supervisorEmail;
	}
	
	
}
