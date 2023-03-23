package fypms;

import java.util.ArrayList;
import fypms.Project.Status;

public class ProjectList {
	private int projectID = 1;
	ArrayList<Project> projectList;
	
	public ProjectList() {
		projectList = new ArrayList<Project>();														
	}
	
	//Creating Project and Adding to the array.
	public void addProject(Supervisor s, String projectTitle) {
		Project p = new Project(projectID, s, projectTitle);
		projectID++;
		
		projectList.add(p);
	}
	
	//Checking for student if have project
	public boolean checkStudentProject(Student s) {
		for(Project p: projectList) {
			if(p.getS() == s)
				return true;
		}
		return false;
	}
	
	//Printing Methods
	public void printProject() {
		for(Project p: projectList) {
			System.out.println("Project ID:" + p.getProjectID());
			System.out.println("Project Title: " + p.getProjectTitle());
			System.out.println("Supervisor: " + p.getSs().getUserName());
			System.out.println("Email: " + p.getSs().email());
			if(p.getS() != null) {
				System.out.println("Student: " + p.getS().getUserName());
				System.out.println("Email: " + p.getS().email());
			}
			System.out.println("Status: " + p.getStatus() + "\n");
		}
	}
	public void printStatusProject(Status s) {
		for(Project p: projectList) {
			if(p.getStatus() == s) {
				System.out.println("Project ID:" + p.getProjectID());
				System.out.println("Project Title: " + p.getProjectTitle());
				System.out.println("Supervisor: " + p.getSs().getUserName());
				System.out.println("Email: " + p.getSs().email());
				if(p.getS() != null) {
					System.out.println("Student: " + p.getS().getUserName());
					System.out.println("Email: " + p.getS().email());
				}
				System.out.println();
			}
		}
	}
	
	public void printStudentProject(Student s) {
		for(Project p: projectList) {
			if(p.getS() == s) {
				System.out.println("Project ID:" + p.getProjectID());
				System.out.println("Project Title: " + p.getProjectTitle());
				System.out.println("Supervisor: " + p.getSs().getUserName());
				System.out.println("Email: " + p.getSs().email() + "\n");
				return;
			}
		}
	}
	
	public void printSupervisorProject(Supervisor ss) {
		for(Project p: projectList) {
			if(p.getSs() == ss) {
				System.out.println("Project ID:" + p.getProjectID());
				System.out.println("Project Title: " + p.getProjectTitle());
				if(p.getS() != null) {
					System.out.println("Student: " + p.getS().getUserName());
					System.out.println("Email: " + p.getS().email());
				}
				System.out.println();
			}
		}
	}
	
	public void printSupervisorAllocatedProject(Supervisor ss) {
		for(Project p: projectList) {
			if(p.getSs() == ss) {
				if(p.getStatus() == Status.ALLOCATED) {
					System.out.println("Project ID:" + p.getProjectID());
					System.out.println("Project Title: " + p.getProjectTitle());
					System.out.println("Student: " + p.getS().getUserName());
					System.out.println("Email: " + p.getS().email());
				}
				System.out.println();
			}
		}
	}
	
	//Setting Supervisor available projects as unavailable
	public void setUnavail(Supervisor s) {
		for(Project p: projectList) {
			if(p.getSs() == s) {
				if(p.getStatus() == Status.AVAILABLE || p.getStatus() == Status.RESERVED)
					p.setStatus(Status.UNAVAILABLE);
			}
		}
	}
	//Setting Supervisor unavailable projects as available
	public void setAvail(Supervisor s) {
		for(Project p: projectList) {
			if(p.getSs() == s) {
				if(p.getStatus() == Status.UNAVAILABLE)
					p.setStatus(Status.AVAILABLE);
			}
		}
	}
	
	//Setter Getter
	public Project getProject(int index) {
		for(Project p: projectList) {
			if(p.getProjectID() == index)
				return p;
		}
		return null;
	}
	
	public Project getStudentProject(Student s) {
		for(Project p: projectList) {
			if(p.getS() == s)
				return p;
		}
		return null;
	}
}
