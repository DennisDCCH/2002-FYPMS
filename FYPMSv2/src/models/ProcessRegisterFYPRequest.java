package models;

import enumclass.ProjectStatus;

public class ProcessRegisterFYPRequest {
	
	public static void manageRequest(Request r) {
		// r request id, requester name, responder name, project id, additonal info
		
		// Add project to student projectList
		StudentList.getSpecificStudent(r.getRequesterName()).addProject(ProjectList.getSpecificProject(r.getProjectID()));
		
		// Set student name to project
		ProjectList.getSpecificProject(r.getProjectID()).setStudentName(r.getRequesterName());
		
		// Set project status
		ProjectList.getSpecificProject(r.getProjectID()).setStatus(ProjectStatus.ALLOCATED);
		
		//Update status of supervisor projectlist
		SupervisorList.getSpecificSupervisor(ProjectList.getSpecificProject(r.getProjectID()).getSupervisorName()).checkAndSetProjectStatus();		
	}
}
