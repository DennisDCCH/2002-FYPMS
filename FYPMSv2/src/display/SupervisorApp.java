package display;

import java.util.Scanner;

import enumclass.ProjectStatus;
import models.Project;
import models.ProjectList;
import models.RequestProcess;
import models.Supervisor;

public class SupervisorApp {
	
	public static void display(Supervisor supervisor) {
		Scanner sc = new Scanner(System.in);
		
		int choice;
		do {
			mainDisplay(supervisor);
			choice = sc.nextInt();
			switch(choice) {
				// Change Password
				case 1:
					System.out.println("Enter new password: ");
					String password = sc.next();
					supervisor.setPassword(password);
					System.out.println("Password changed\n");
					break;
					
				// My Projects
				case 2:
					supervisorProjectDisplay(supervisor);
					break;
					
				// Request
				case 3:
					supervisorRequestDisplay(supervisor);
					break;
				
				// Request to transfer Student
				case 4:
					// Not done
					break;
					
				// Logout
				case 5:
					System.out.println("Logging out...\n");
					break;
					
				default:
					System.out.println("Please choose a valid option\n");
					break;
			}
		}while(choice != 5);
		
	}
	
	private static void mainDisplay(Supervisor supervisor) {
		if(supervisor.pendingRequest()) {
			System.out.println("========================================");
			System.out.println("|1. Change Password                    |");
			System.out.println("|2. My Projects                        |");
			System.out.println("|3. Request (New)                      |");
			System.out.println("|4. Request to Transfer Student        |");
			System.out.println("|5. Logout                             |");
			System.out.println("========================================");
			System.out.println("Enter your choice: ");
		}
		else{
			System.out.println("========================================");
			System.out.println("|1. Change Password                    |");
			System.out.println("|2. My Projects                        |");
			System.out.println("|3. Request                            |");
			System.out.println("|4. Request to Transfer Student        |");
			System.out.println("|5. Logout                             |");
			System.out.println("========================================");
			System.out.println("Enter your choice: ");
		}
	}
	
	private static void supervisorProjectDisplay(Supervisor supervisor) {
		Scanner sc = new Scanner(System.in);
		int option = 0;
		do {
			System.out.println("========================================");
			System.out.println("|1. Create Projects                    |");
			System.out.println("|2. Update Projects                    |");
			System.out.println("|3. View Projects                      |");
			System.out.println("|4. Return                             |");
			System.out.println("========================================");
			System.out.println("Enter your choice: ");
			option = sc.nextInt();
			switch(option) {
				// Create Projects
				case 1:
					System.out.println("Enter Project Title: ");
					String projectTitle = sc.next();
					Project p = new Project(ProjectList.getNextProjectID(), supervisor.getUserName(), null, projectTitle, ProjectStatus.AVAILABLE);
					
					// Adding to supervisor list of projects
					supervisor.addProject(p);
					// Adding to the overall list of projects
					ProjectList.addProject(p);
					
					System.out.println("Project created!\n");
					break;
					
				// Update Projects
				case 2:
					supervisor.printMyProjects();
					System.out.println("Enter the Project ID to update");
					int id = sc.nextInt();
					if(supervisor.getProject(id) != null) {
						System.out.println("Enter the new project title: ");
						String title = sc.next();
						supervisor.getProject(id).setProjectTitle(title);
						System.out.println("Your project have been updated!");
					}
					else {
						System.out.println("You have entered a invalid project ID!");
						System.out.println("Returning back to main menu...\n");
					}
					break;
					
				// View Projects
				case 3:
					supervisor.printMyProjects();
					break;
					
				// Return
				case 4:
					System.out.println("Returning... \n");
					break;
					
				default:
					System.out.println("Please choose a valid option\n");
					break;
			}
		}while(option != 4);
			
	}
	
	private static void supervisorRequestDisplay(Supervisor supervisor) {
		Scanner sc = new Scanner(System.in);
		int option = 0;
		if(supervisor.pendingRequest()) {
			do {
				System.out.println("========================================");
				System.out.println("|1. Pending Request                    |");
				System.out.println("|2. Request History and Status         |");
				System.out.println("|3. Return                             |");
				System.out.println("========================================");
				System.out.println("Enter your choice: ");
				option = sc.nextInt();
				switch(option) {
					// Pending Request
					case 1:
						supervisor.printPendingRequest();
						System.out.println("Enter the request ID to process: ");
						int id = sc.nextInt();
						if(supervisor.getRequest(id) != null) {
							RequestProcess.process(supervisor.getRequest(id));
						}
						else {
							System.out.println("You have entered a invalid request ID!");
							System.out.println("Returning back to main menu...\n");
						}
						break;
						
					// Request History and Status
					case 2:
						supervisor.printMyRequest();
						break;
						
					// Return
					case 3:
						System.out.println("Returning... \n");
						break;
						
					default:
						System.out.println("Please choose a valid option\n");
						break;	
				}
			}while(option != 3);
		}
		else {
			do {
				System.out.println("========================================");
				System.out.println("|1. Request History and Status         |");
				System.out.println("|2. Return                             |");
				System.out.println("========================================");
				System.out.println("Enter your choice: ");
				option = sc.nextInt();
				switch(option) {
					// Request History and Status
					case 1:
						supervisor.printMyRequest();
						break;
						
					// Return	
					case 2:
						System.out.println("Returning... \n");
						break;
						
					default:
						System.out.println("Please choose a valid option\n");
						break;	
				}
			}while(option != 2);
		}
	}
}
