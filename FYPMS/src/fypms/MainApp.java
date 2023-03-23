package fypms;

import java.util.Scanner;
public class MainApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		StudentList stu = new StudentList();
		SupervisorList sup = new SupervisorList();
		CoordinatorList coord = new CoordinatorList();
		ProjectList projectList = new ProjectList();
		RequestList requestList = new RequestList();
		
		//Initializing all projects
		projectList.addProject(sup.getSupervisor(1), "Machine Learning-Based Interference Mitigation in a Multi-tier Networks");
		projectList.addProject(sup.getSupervisor(1), "Deep Learning-Driven Edge Caching for 5G-and-Beyond Industrial IoT Networks");
		projectList.addProject(sup.getSupervisor(2), "Sonification of Geometry 1");
		projectList.addProject(sup.getSupervisor(3), "Edge/Cloud Resource Management for Time-Sensitive Applications (2)");
		projectList.addProject(sup.getSupervisor(4), "Deep Reinforcement Learning for Complex Environment");
		projectList.addProject(sup.getSupervisor(4), "Build Software Agents for Power Trading Agent Competition");
		projectList.addProject(sup.getSupervisor(4), "Designing Negotiation Agents to Parcitipate in International Competition");
		projectList.addProject(sup.getSupervisor(5), "Creation of Meta-model for Agent-based Simulation Using Machine Learning Approach");
		projectList.addProject(sup.getSupervisor(6), "Encoding Images to Text Prompts with CLIP");
		projectList.addProject(sup.getSupervisor(7), "Smart Monitor for Studio Photographer");
		projectList.addProject(sup.getSupervisor(8), "Developing a demonstration system for spatial data exploration and visualization");
		projectList.addProject(sup.getSupervisor(8), "Deep Learning Supported Location-aware Keyword Query");
		projectList.addProject(sup.getSupervisor(9), "An AI based Li-ion fast battery charger for power tools");
		projectList.addProject(sup.getSupervisor(9), "A Li-ion fast battery charger");
		projectList.addProject(sup.getSupervisor(10), "Metaverse for virtual education 1");
		projectList.addProject(sup.getSupervisor(11), "Graph-based Deep Models for Image Semantic Segmentation");
			
		int choice = 0;
		
		while (true){
			//First Interface
			do{
			System.out.println("Welcome to the FYPMS");
			System.out.println("====================");
			System.out.println("|1. Login          |");
			System.out.println("|2. Quit           |");
			System.out.println("====================");
			System.out.println("Enter your choice: ");
			choice = sc.nextInt();
			
				switch(choice) {
				case 1:
					//Login
					break;
				case 2:
					System.out.println("Quiting...");
					System.exit(0);
				default:
					System.out.println("Please choose a valid option");
					System.out.println();
					break;
				}
			}while(choice != 1);
			
			while (true) {
				//Login System
				System.out.println("Enter USERID: ");
				String userID = sc.next();
				System.out.println("Enter PASSWORD: ");
				String password = sc.next();
				
				//To determine what domain of the user
				Student s = stu.checkDomain(userID);
				Supervisor ss = sup.checkDomain(userID);
				Coordinator c = coord.checkDomain(userID);
				
				if(s != null) {
					if(s.checkPassword(password)) {
						System.out.println("Login successfully!");
						StudentApp sapp = new StudentApp(s, projectList, requestList, coord.getC());
						sapp.studentDisplay();
						break;
					}
					else {
						System.out.println("You have entered the wrong PASSWORD!");
						System.out.println("Please try again!");
						System.out.println();
					}
				}
				else if (ss != null) {
					if(ss.checkPassword(password)) {
						System.out.println("Login successfully!");
						SupervisorApp ssapp = new SupervisorApp(ss, projectList, requestList, sup, coord.getC());
						ssapp.supervisorDisplay();
						break;
					}
					else {
						System.out.println("You have entered the wrong PASSWORD!");
						System.out.println("Please try again!");
						System.out.println();
					}
				}
				else if(c != null) {
					if(c.checkPassword(password)) {
						System.out.println("Login successfully!");
						CoordinatorApp capp = new CoordinatorApp(c, projectList, requestList, sup);
						capp.coordinatorDisplay();
						break;
					}
					else {
						System.out.println("You have entered the wrong PASSWORD!");
						System.out.println("Please try again!");
						System.out.println();
					}
				}
				else {
					System.out.println("You have entered the wrong USERID!");
					System.out.println("Please try again!");
					System.out.println();
				}
			}
		}
	}
}
