package models;

import java.util.ArrayList;
import java.util.List;

import enumclass.ProjectStatus;
import ioclass.ReadProjectCSV;


public class ProjectList {
	List<Project> projectList = ReadProjectCSV.readCSV();
	
	public ProjectList() {
		projectList = ReadProjectCSV.readCSV();
	}
	
	public void addProject(String supervisorName, String projectTitle) {
		Project p = new Project(projectList.size() + 1, supervisorName, null, projectTitle, ProjectStatus.AVAILABLE);
		projectList.add(p);
	}
	
	public void printStatusProject(ProjectStatus status) {
		for(Project p: projectList) {
			if(p.getStatus() == status)
				p.printProject();
		}
	}

	
	public List<Project> getUserProjectList(String userName) {
		List<Project> newList = new ArrayList<Project>();
		for(Project p: projectList) {
			if(p.getStudentName().equals(userName))
				newList.add(p);
			if(p.getStudentName().equals(userName))
				newList.add(p);
		}
		return newList;
	}

	//Getter Setter
	public List<Project> getProjectList() {
		return projectList;
	}
}
