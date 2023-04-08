package models;

import enumclass.ProjectStatus;

public class PrintProjectList {
	
	public static void printAllProject() {
		for(Project p: ProjectList.getProjectList())
			p.printProjectDetails();
	}
	
	public static void printSupervisorSpecificProjects(String userName) {
		if(ProjectList.getUserSpecificProjectList(userName).size() > 0) {
			for(Project p: ProjectList.getUserSpecificProjectList(userName))
				p.printProjectDetails();
		}
		else {
			System.out.println("This supervisor have no projects");
		}
	}
	
	public static void printStatusSpecificProjects(ProjectStatus status) {
		if(ProjectList.getStatusSpecificProjectList(status).size() > 0) {
			for(Project p: ProjectList.getStatusSpecificProjectList(status))
				p.printProjectDetails();
		}
		else {
			System.out.println("There is no projects with this status");
		}
	}
}
     