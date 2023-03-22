package fypms;

import java.util.ArrayList;
import fypms.Project.Status;

public class ProjectList {
	private int projectID = 17;
	ArrayList<Project> projectList;
	private SupervisorList ss;
	
	public ProjectList(SupervisorList ss) {
		this.ss = ss;
		
		projectList = new ArrayList<Project>(); 
		
		Project p1 = new Project(1, ss.getSupervisor(1), "Machine Learning-Based Interference Mitigation in a Multi-tier Networks");
		Project p2 = new Project(2, ss.getSupervisor(1), "Deep Learning-Driven Edge Caching for 5G-and-Beyond Industrial IoT Networks");
		Project p3 = new Project(3, ss.getSupervisor(2), "Sonification of Geometry 1");
		Project p4 = new Project(4, ss.getSupervisor(3), "Edge/Cloud Resource Management for Time-Sensitive Applications (2)");
		Project p5 = new Project(5, ss.getSupervisor(4), "Deep Reinforcement Learning for Complex Environment");
		Project p6 = new Project(6, ss.getSupervisor(4), "Build Software Agents for Power Trading Agent Competition");
		Project p7 = new Project(7, ss.getSupervisor(4), "Designing Negotiation Agents to Parcitipate in International Competition");
		Project p8 = new Project(8, ss.getSupervisor(5), "Creation of Meta-model for Agent-based Simulation Using Machine Learning Approach");
		Project p9 = new Project(9, ss.getSupervisor(6), "Encoding Images to Text Prompts with CLIP");
		Project p10 = new Project(10, ss.getSupervisor(7), "Smart Monitor for Studio Photographer");
		Project p11 = new Project(11, ss.getSupervisor(8), "Developing a demonstration system for spatial data exploration and visualization");
		Project p12 = new Project(12, ss.getSupervisor(8), "Deep Learning Supported Location-aware Keyword Query");
		Project p13 = new Project(13, ss.getSupervisor(9), "An AI based Li-ion fast battery charger for power tools");
		Project p14 = new Project(14, ss.getSupervisor(9), "A Li-ion fast battery charger");
		Project p15 = new Project(15, ss.getSupervisor(10), "Metaverse for virtual education 1");
		Project p16 = new Project(16, ss.getSupervisor(11), "Graph-based Deep Models for Image Semantic Segmentation");
		
		projectList.add(p1);
		projectList.add(p2);
		projectList.add(p3);
		projectList.add(p4);
		projectList.add(p5);
		projectList.add(p6);
		projectList.add(p7);
		projectList.add(p8);
		projectList.add(p9);
		projectList.add(p10);
		projectList.add(p11);
		projectList.add(p12);
		projectList.add(p13);
		projectList.add(p14);
		projectList.add(p15);
		projectList.add(p16);															
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
			System.out.println("Email: " + p.getSs().email() + "\n");
			if(p.getS() != null) {
				System.out.println("Student: " + p.getS().getUserName());
				System.out.println("Email: " + p.getS().email());
			}
			System.out.println("Status: " + p.getStatus());
		}
	}
	public void printStatusProject(Status s) {
		for(Project p: projectList) {
			if(p.getStatus() == s) {
				System.out.println("Project ID:" + p.getProjectID());
				System.out.println("Project Title: " + p.getProjectTitle());
				System.out.println("Supervisor: " + p.getSs().getUserName());
				System.out.println("Email: " + p.getSs().email() + "\n");
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
