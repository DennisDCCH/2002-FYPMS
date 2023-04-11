package display;

import java.util.Scanner;

import enumclass.ProjectStatus;
import enumclass.RequestStatus;
import models.Coordinator;
import models.PrintProjectList;
import models.Project;
import models.ProjectList;
import models.Request;
import models.RequestList;
import models.Supervisor;
import models.SupervisorList;
import models.TransferStudentRequest;

public class CoordinatorApp {
	
	public static void display(Supervisor coordinator) {
		Scanner sc = new Scanner(System.in);
		
		int choice = 0;
		do {
			mainDisplay(coordinator);
			choice = sc.nextInt();
			sc.nextLine();
			switch(choice) {
			// Change Password
			case 1:
				String password;
				while(true) {
					System.out.println("Enter new password: ");
					password = sc.nextLine();
					if(password.contains(",")) 
						System.out.println("Password cannot contain commas (,)");
					else
						break;
				}
				coordinator.setPassword(password);
				System.out.println("Password changed\n");
				break;
				
			// My Projects
			case 2:
				coordinatorProjectDisplay(coordinator);
				break;
				
			// Request
			case 3:
				coordinatorRequestDisplay(coordinator);
				break;
				
			// Logout
			case 4:
				System.out.println("Logging out...\n");
				break;
				
			default:
				System.out.println("Please choose a valid option\n");
				break;
			}
		}while(choice != 4);
		
	}
	
	private static void mainDisplay(Supervisor coordinator) {
		if(coordinator.pendingRequest()) {
			System.out.println("========================================");
			System.out.println("|1. Change Password                    |");
			System.out.println("|2. Projects                           |");
			System.out.println("|3. Request (New)                      |");
			System.out.println("|4. Logout                             |");
			System.out.println("========================================");
			System.out.println("Enter your choice: ");
		}
		else {
			System.out.println("========================================");
			System.out.println("|1. Change Password                    |");
			System.out.println("|2. Projects                           |");
			System.out.println("|3. Request                            |");
			System.out.println("|4. Logout                             |");
			System.out.println("========================================");
			System.out.println("Enter your choice: ");
		}
	}
	
	private static void coordinatorProjectDisplay(Supervisor coordinator) {
		Scanner sc = new Scanner(System.in);
		int option = 0;
		do {
			System.out.println("========================================");
			System.out.println("|1. Create Projects                    |");
			System.out.println("|2. Update Projects                    |");
			System.out.println("|3. View My Projects                   |");
			System.out.println("|4. Request to Transfer Student        |");
			System.out.println("|5. View System Projects               |");
			System.out.println("|6. Return                             |");
			System.out.println("========================================");
			System.out.println("Enter your choice: ");
			option = sc.nextInt();
			sc.nextLine();
			switch(option) {
				// Create Projects
				case 1:
					String projectTitle;
					while (true) {
						System.out.println("Enter Project Title: ");
						projectTitle = sc.nextLine();
						if(projectTitle.contains(",")) 
							System.out.println("The project title cannot contain commas!");
						else
							break;
					}
					
					Project p = new Project(ProjectList.getNextProjectID(), coordinator.getUserName(), coordinator.getEmail(), 
							null, null, projectTitle, ProjectStatus.AVAILABLE);
					
					// Adding to supervisor list of projects
					coordinator.addProject(p);
					// Adding to the overall list of projects
					ProjectList.addProject(p);
					
					System.out.println("Project created!\n");
					break;
					
				// Update Projects
				case 2:
					if(coordinator.getProjectList().size() > 0) {
						String title;
						coordinator.printMyProjects();
						System.out.println("Enter the Project ID to update");
						int id = sc.nextInt();
						sc.nextLine();
						if(coordinator.getProject(id) != null) {
							while(true) {
								System.out.println("Enter the new project title: ");
								title = sc.nextLine();
								if(title.contains(",")) 
									System.out.println("The project title cannot contain commas!");
								else
									break;
							}
							coordinator.getProject(id).setProjectTitle(title);
							System.out.println("Your project have been updated!");
						}
						else {
							System.out.println("You have entered a invalid project ID!");
							System.out.println("Returning back to main menu...\n");
						}
					}
					else
						System.out.println("You have no projects\n");
					break;
					
				// View Projects
				case 3:
					if(coordinator.getProjectList().size() > 0)
						coordinator.printMyProjects();
					else
						System.out.println("You have no projects\n");
					break;
					
					// Request to transfer Student
				case 4:
					int projectID;
					String userID;
					if(coordinator.getAllocatedProjectList().size() > 0) {
						coordinator.printAllocatedProjects();
						while(true) {
							System.out.println("Enter the projectID that you want to transfer: ");
							projectID = sc.nextInt();
							if(coordinator.getProject(projectID) != null) {
								break;
							}
							else {
								System.out.println("You have entered a invalid project ID!");
								System.out.println("Please try again!\n");
							}
						}
						while(true) {
							System.out.println("Enter the new supervisor USERID");
							userID = sc.next();
							if(SupervisorList.getSpecificSupervisorID(userID) != null) {
								if(SupervisorList.getSpecificSupervisorID(userID).getSupervisingProjectCount() < 2) {
									//Make the new request
									Request r = new TransferStudentRequest(RequestList.getNextRequestID(), coordinator.getUserName(), "Li Fang", projectID, RequestStatus.PENDING, userID);
									
									//Appened request to overall requestList and supervisor requestList
									coordinator.addRequest(r);
									RequestList.addRequest(r);
									
									System.out.println("The request have been send out.\n");
									break;
								}
								else {
									System.out.println(userID + " cannot take on more projects!");
									System.out.println("Please try again!\n");
								}
							}
							else {
								System.out.println("You have entered a invalid USERID");
								System.out.println("Please try again!\n");
							}
						}
					}
					else 
						System.out.println("You have no projects that is allocated currently\n");
					break;
				
				// View System Projects
				case 5:
					systemProjectDisplay();
					break;
				// Return
				case 6:
					System.out.println("Returning... \n");
					break;
					
				default:
					System.out.println("Please choose a valid option\n");
					break;
			}
		}while(option != 6);
	}
	
	private static void systemProjectDisplay() {
		Scanner sc = new Scanner(System.in);
		int option = 0;
		do {
			System.out.println("========================================");
			System.out.println("|1. View all Projects                  |");
			System.out.println("|2. View Projects (Status)             |");
			System.out.println("|3. View Projects (Supervisors)        |");
			System.out.println("|4. Return                             |");
			System.out.println("========================================");
			System.out.println("Enter your choice: ");
			option = sc.nextInt();
			switch(option) {
				
				// View all projects
				case 1:
					PrintProjectList.printAllProject();
					break;
					
				case 2:
					systemProjectStatusDisplay();
					break;
				
				case 3:
					System.out.println("Enter the userID of the supervisor you want to check: ");
					String userID = sc.next();
					if(SupervisorList.getSpecificSupervisorID(userID) != null) {
						String name = SupervisorList.getSpecificSupervisorID(userID).getUserName();
						PrintProjectList.printSupervisorSpecificProjects(name);
					}
					else {
						System.out.println("You have entered a invalid userID!");
						System.out.println("Returning back to system project menu.\n");
					}
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
	
	private static void systemProjectStatusDisplay() {
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		do {
			System.out.println("===================");
			System.out.println("|1. Available     |");
			System.out.println("|2. Reserved      |");
			System.out.println("|3. Allocated     |");
			System.out.println("|4. Unavailable   |");
			System.out.println("|5. Return        |");
			System.out.println("===================");
			System.out.println("Enter the status: ");
			choice = sc.nextInt();
			switch(choice) {
				case 1:
					PrintProjectList.printStatusSpecificProjects(ProjectStatus.AVAILABLE);
					break;
					
				case 2:
					PrintProjectList.printStatusSpecificProjects(ProjectStatus.RESERVED);
					break;
					
				case 3:
					PrintProjectList.printStatusSpecificProjects(ProjectStatus.ALLOCATED);
					break;
					
				case 4:
					PrintProjectList.printStatusSpecificProjects(ProjectStatus.UNAVAILABLE);
					break;
					
				case 5: 
					System.out.println("Returning... \n");
					break;
					
				default:
					System.out.println("Please choose a valid option\n");
					break;	
			}
		}while(choice != 5);
	}
	
	private static void coordinatorRequestDisplay(Supervisor coordinator) {
		Scanner sc = new Scanner(System.in);
		int option = 0;
		boolean bool = true;
		do {
			if(coordinator.pendingRequest()) {
				requestDisplay(coordinator);
				option = sc.nextInt();
				switch(option) {
					// Pending Request
					case 1:
						coordinator.printPendingRequest();
						System.out.println("Enter the request ID to process: ");
						int id = sc.nextInt();
						if(coordinator.getRequest(id) != null) {
							coordinator.getRequest(id).processRequest();
						}
						else {
							System.out.println("You have entered a invalid request ID!");
							System.out.println("Returning back to main menu...\n");
						}
						break;
						
					// Request History and Status
					case 2:
						if(coordinator.getRequestList().size() > 0)
							coordinator.printMyRequest();
						else
							System.out.println("You have no request history\n");
						break;
						
					// Return
					case 3:
						System.out.println("Returning... \n");
						bool = false;
						break;
						
					default:
						System.out.println("Please choose a valid option\n");
						break;	
				}
			}
			else {
				requestDisplay(coordinator);
				option = sc.nextInt();
				switch(option) {
					// Request History and Status
					case 1:
						if(coordinator.getRequestList().size() > 0)
							coordinator.printMyRequest();
						else
							System.out.println("You have no request history");
						break;
						
					// Return	
					case 2:
						System.out.println("Returning... \n");
						bool = false;
						break;
						
					default:
						System.out.println("Please choose a valid option\n");
						break;	
				}
			}
		}while(bool);
	}
	
	private static void requestDisplay(Supervisor coordinator) {
		if(coordinator.pendingRequest()) {
			System.out.println("========================================");
			System.out.println("|1. Pending Request                    |");
			System.out.println("|2. Request History and Status         |");
			System.out.println("|3. Return                             |");
			System.out.println("========================================");
			System.out.println("Enter your choice: ");
		}
		else {
			System.out.println("========================================");
			System.out.println("|1. Request History and Status         |");
			System.out.println("|2. Return                             |");
			System.out.println("========================================");
			System.out.println("Enter your choice: ");
		}		
	}
}


