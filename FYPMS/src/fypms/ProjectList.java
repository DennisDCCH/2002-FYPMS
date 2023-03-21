package fypms;

import java.util.ArrayList;
import fypms.Project.Status;

public class ProjectList {
	static int projectID = 16;
	ArrayList<Project> projectList;
	SupervisorList ss = new SupervisorList();
	
	public ProjectList() {
		projectList = new ArrayList<Project>(); 
		
		Project p1 = new Project(1, ss.getSupervisor(0), "Machine Learning-Based Interference Mitigation in a Multi-tier Networks");
		Project p2 = new Project(1, ss.getSupervisor(0), "Deep Learning-Driven Edge Caching for 5G-and-Beyond Industrial IoT Networks");
		Project p3 = new Project(1, ss.getSupervisor(1), "Sonification of Geometry 1");
		Project p4 = new Project(1, ss.getSupervisor(2), "Edge/Cloud Resource Management for Time-Sensitive Applications (2)");
		Project p5 = new Project(1, ss.getSupervisor(3), "Deep Reinforcement Learning for Complex Environment");
		Project p6 = new Project(1, ss.getSupervisor(3), "Build Software Agents for Power Trading Agent Competition");
		Project p7 = new Project(1, ss.getSupervisor(3), "Designing Negotiation Agents to Parcitipate in International Competition");
		Project p8 = new Project(1, ss.getSupervisor(4), "Creation of Meta-model for Agent-based Simulation Using Machine Learning Approach");
		Project p9 = new Project(1, ss.getSupervisor(5), "Encoding Images to Text Prompts with CLIP");
		Project p10 = new Project(1, ss.getSupervisor(6), "Smart Monitor for Studio Photographer");
		Project p11 = new Project(1, ss.getSupervisor(7), "Developing a demonstration system for spatial data exploration and visualization");
		Project p12 = new Project(1, ss.getSupervisor(7), "Deep Learning Supported Location-aware Keyword Query");
		Project p13 = new Project(1, ss.getSupervisor(8), "An AI based Li-ion fast battery charger for power tools");
		Project p14 = new Project(1, ss.getSupervisor(8), "A Li-ion fast battery charger");
		Project p15 = new Project(1, ss.getSupervisor(9), "Metaverse for virtual education 1");
		Project p16 = new Project(1, ss.getSupervisor(10), "Graph-based Deep Models for Image Semantic Segmentation");
		
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
	
	//Creating Project
	public void addProject(Project project) {
		projectList.add(project);
	}
	
	//Printing Methods
	public void printStatusProject(Status s) {
		for(Project p: projectList) {
			if(p.getStatus() == s) {
				System.out.println("Project ID:" + p.getProjectID());
				System.out.println("Project Title: " + p.getProjectTitle());
				System.out.println("Supervisor: " + p.getSs().getUserName());
				System.out.println("Email: " + p.getSs().email());
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
}
