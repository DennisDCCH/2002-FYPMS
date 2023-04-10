package models;

import enumclass.ProjectStatus;

public class ProcessRegisterFYPRequest {
	
	public static void manageRequest(int projectID, String requesterName, String additionalInfo) {
		// r request id, requester name, responder name, project id, additonal info
		
		// Add project to student projectList
		// StudentList.getSpecificStudent(r.getRequesterName()).addProject(ProjectList.getSpecificProject(r.getProjectID()));
		
		// Set student name to project
		ProjectList.getSpecificProject(projectID).setStudentName(requesterName);
		// ProjectList.getSpecificProject(r.getProjectID()).setStudentName(r.getRequesterName());
		
		// Set student email to project
		ProjectList.getSpecificProject(projectID).setStudentEmail(additionalInfo);
		
		// Set project status
		ProjectList.getSpecificProject(projectID).setStatus(ProjectStatus.ALLOCATED);
		// ProjectList.getSpecificProject(r.getProjectID()).setStatus(ProjectStatus.ALLOCATED);
		
		//Update status of supervisor project list
		SupervisorList.getSpecificSupervisor(ProjectList.getSpecificProject(projectID).getSupervisorName()).checkAndSetProjectStatus();
		// SupervisorList.getSpecificSupervisor(ProjectList.getSpecificProject(r.getProjectID()).getSupervisorName()).checkAndSetProjectStatus();		
	}
	
	public static void rejectRequest(int projectID) {
		// Set project status
		ProjectList.getSpecificProject(projectID).setStatus(ProjectStatus.AVAILABLE);
		
		// Update status of supervisor project list
		SupervisorList.getSpecificSupervisor(ProjectList.getSpecificProject(projectID).getSupervisorName()).checkAndSetProjectStatus();
		
	}
}
