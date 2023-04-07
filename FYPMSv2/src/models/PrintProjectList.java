package models;

import enumclass.ProjectStatus;

public class PrintProjectList {
	public static void printSupervisorSpecificProjects(String userName) {
		for(Project p: ProjectList.getUserSpecificProjectList(userName))
			p.printProjectDetails();
	}
	
	public static void printStatusSpecificProjects(ProjectStatus status) {
		for(Project p: ProjectList.getStatusSpecificProjectList(status))
			p.printProjectDetails();
	}
}
     