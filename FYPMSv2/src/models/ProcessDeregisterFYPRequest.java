package models;

import enumclass.ProjectStatus;

public class ProcessDeregisterFYPRequest {

	public static void manageRequest(Request r) {
		// r request id, requester name, responder name, project id, additonal info
		
		//Remove project from student projectlist
		StudentList.getSpecificStudent(r.getRequesterName()).removeProject(ProjectList.getSpecificProject(r.getProjectID()));
		
		// Remove student name from project
		ProjectList.getSpecificProject(r.getProjectID()).removeStudent();;
		
		// Set project status
		ProjectList.getSpecificProject(r.getProjectID()).setStatus(ProjectStatus.AVAILABLE);
		
		//Update status of supervisor projectlist
		SupervisorList.getSpecificSupervisor(ProjectList.getSpecificProject(r.getProjectID()).getSupervisorName()).checkAndSetProjectStatus();
	}
}
