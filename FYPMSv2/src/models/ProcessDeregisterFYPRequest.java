package models;

import enumclass.ProjectStatus;

public class ProcessDeregisterFYPRequest {

	public static void manageRequest(String requesterName, int projectID) {
		// r request id, requester name, responder name, project id, additional info
		
		//Remove project from student project list
		//StudentList.getSpecificStudent(requesterName).removeProject(ProjectList.getSpecificProject(projectID));
		//StudentList.getSpecificStudent(r.getRequesterName()).removeProject(ProjectList.getSpecificProject(r.getProjectID()));
		
		// Remove student name from project
		ProjectList.getSpecificProject(projectID).removeStudent();
		//ProjectList.getSpecificProject(r.getProjectID()).removeStudent();;
		
		// Update that student have been deregistered from FYP
		StudentList.getSpecificStudent(requesterName).setDeregisteredFYP(1);
		
		// Set project status
		ProjectList.getSpecificProject(projectID).setStatus(ProjectStatus.AVAILABLE);
		//ProjectList.getSpecificProject(r.getProjectID()).setStatus(ProjectStatus.AVAILABLE);
		
		//Update status of supervisor project list
		SupervisorList.getSpecificSupervisor(ProjectList.getSpecificProject(projectID).getSupervisorName()).checkAndSetProjectStatus();
		//SupervisorList.getSpecificSupervisor(ProjectList.getSpecificProject(r.getProjectID()).getSupervisorName()).checkAndSetProjectStatus();
	}
}
