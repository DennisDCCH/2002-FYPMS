package display;

import java.util.Scanner;

import models.ProjectList;
import models.Supervisor;

public class SupervisorApp {
	
	public static void display(Supervisor supervisor, ProjectList projectList) {
		Scanner sc = new Scanner(System.in);
		
		int choice;
		do {
			mainDisplay();
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
					supervisorProjectDisplay(supervisor, projectList);
					break;
					
				// Request
				case 3:
					supervisorRequestDisplay();
					break;
				
				// Request to transfer Student
				case 4:
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
	
	public static void mainDisplay() {
		boolean bool= true;
		if(bool) {
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
	private static void supervisorProjectDisplay(Supervisor supervisor, ProjectList projectList) {
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
					projectList.addProject(supervisor.getUserName(), projectTitle);
					System.out.println("Project created!\n");
					break;
					
				// Update Projects
				case 2:
					
					break;
					
				// View Projects
				case 3:
					supervisor.printProjectDetails();
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
	
	private static void supervisorRequestDisplay() {
		Scanner sc = new Scanner(System.in);
		int option = 0;
		do {
			System.out.println("========================================");
			System.out.println("|1. Pending Request                    |");
			System.out.println("|2. Outgoing Request History and Status|");
			System.out.println("|3. Incoming Request History and Status|");
			System.out.println("|4. Return                             |");
			System.out.println("========================================");
			System.out.println("Enter your choice: ");
			option = sc.nextInt();
			switch(option) {
				case 1:
					break;
					
				case 2:
					break;
					
				case 3:
					break;
					
				case 4:
					System.out.println("Returning... \n");
					break;
					
				default:
					System.out.println("Please choose a valid option\n");
					break;	
			}
		}while(option != 4);
	}
}
