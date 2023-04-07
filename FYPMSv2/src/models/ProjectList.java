package models;

import java.util.ArrayList;
import java.util.List;

import enumclass.ProjectStatus;
import ioclass.ReadProjectCSV;


public class ProjectList {
	private static List<Project> projectList = ReadProjectCSV.readCSV();
	
	public static void addProject(Project p) {
		projectList.add(p);
	}
	
	public static List<Project> getUserSpecificProjectList(String userName){
		List<Project> newList = new ArrayList<Project>();
		for(Project p: projectList) {
			if(p.getStudentName().equals(userName))
				newList.add(p);
			if(p.getSupervisorName().equals(userName))
				newList.add(p);
		}
		return newList;
	}
	
	public static List<Project> getStatusSpecificProjectList(ProjectStatus status){
		List<Project> newList = new ArrayList<Project>();
		for(Project p: projectList) {
			if(p.getStatus() == status)
				newList.add(p);
		}
		return newList;
	}

	//Getter Setter
	public static List<Project> getProjectList() {
		return projectList;
	}
	
	public static int getNextProjectID() {
		return projectList.size() + 1;
	}
}
