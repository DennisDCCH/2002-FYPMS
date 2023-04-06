package models;

import java.util.List;

import enumclass.ProjectStatus;
import ioclass.ReadProjectCSV;


public class ProjectList {
	List<Project> projectList;
	
	public ProjectList() {
		projectList = ReadProjectCSV.readCSV();
	}
	
	public void addProject(String supervisorName, String projectTitle) {
		Project p = new Project(projectList.size() + 1, supervisorName, null, projectTitle, ProjectStatus.AVAILABLE);
		projectList.add(p);
	}

	//Getter Setter
	public List<Project> getProjectList() {
		return projectList;
	}
}
