package display;

import java.util.Scanner;

import enumclass.ProjectStatus;
import enumclass.RequestStatus;
import ioclass.OutputStudentCSV;
import models.ChangeTitleRequest;
import models.DeregisterFYPRequest;
import models.PrintProjectList;
import models.ProjectList;
import models.RegisterFYPRequest;
import models.Request;
import models.RequestList;
import models.Student;
import models.StudentList;

public class StudentApp {
	
	public static void display(Student student) {
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		if(student.isHaveProject()) {
			do {
				mainDisplay(student);
				System.out.println("Enter your choice: ");
				choice = sc.nextInt();
				switch(choice) {
					// Change Password
					case 1:
						System.out.println("Enter new password: ");
						String password = sc.next();
						student.setPassword(password);
						System.out.println("Password changed\n");
						break;
						
					// View Registered Project
					case 2:
						student.printMyProjects();
						break;
						
					// View Request History and Status
					case 3:
						if(student.getRequestList().size() > 0)
							student.printMyRequest();
						else
							System.out.println("You have no request history\n");
						break;
						
					// Request to Change Project Title
					case 4:
						System.out.println("Enter the new project title");
						String title = sc.next();
						Request changeTitleRequest = new ChangeTitleRequest(RequestList.getNextRequestID(), student.getUserName(), student.getProject().getSupervisorName(),
								student.getProject().getProjectID(), RequestStatus.PENDING, title);
						
						//Appened request to overall requestList and student requestList
						student.addRequest(changeTitleRequest);
						RequestList.addRequest(changeTitleRequest);
						
						System.out.println("The request have been send out.\n");
						break;
						
					// Request to Deregister FYP
					case 5:
						Request deregisterRequest = new DeregisterFYPRequest(RequestList.getNextRequestID(), student.getUserName(), "Li Fang", student.getProject().getProjectID(),
								RequestStatus.PENDING, null);
						
						//Appened request to overall requestList and student requestList
						student.addRequest(deregisterRequest);
						RequestList.addRequest(deregisterRequest);
						
						System.out.println("The request have been send out.\n");
						break;
						
					// Logout
					case 6:
						System.out.println("Logging out...\n");
						break;
						
					default:
						System.out.println("Please choose a valid option\n");
						break;
				}
			}while(choice != 6);
		}
		else {
			do {
				mainDisplay(student);
				System.out.println("Enter your choice: ");
				choice = sc.nextInt();
				switch(choice) {	
				// Change Password
				case 1:
					System.out.println("Enter new password: ");
					String password = sc.next();
					student.setPassword(password);
					System.out.println("Password changed\n");
					break;
					
				// View Available Project
				case 2:
					PrintProjectList.printStatusSpecificProjects(ProjectStatus.AVAILABLE);
					break;
					
				// View Request History and Status
				case 3:
					if(student.getRequestList().size() > 0)
						student.printMyRequest();
					else
						System.out.println("You have no request history\n");
					break;
					
				// Request to Register FYP
				case 4:
					PrintProjectList.printStatusSpecificProjects(ProjectStatus.AVAILABLE);
					System.out.println("Enter the project ID to register for: ");
					int id = sc.nextInt();
					
					if(ProjectList.getSpecificAvailableProject(id) != null) {
						ProjectList.getSpecificAvailableProject(id).setStatus(ProjectStatus.RESERVED);
						Request registerRequest = new RegisterFYPRequest(RequestList.getNextRequestID(), student.getUserName(), "Li Fang", id, RequestStatus.PENDING, null);
					
						//Appened request to overall requestList and student requestList
						student.addRequest(registerRequest);
						RequestList.addRequest(registerRequest);
						
						System.out.println("The request have been send out.\n");
					}
					else {
						System.out.println("You have entered a invalid project ID!");
						System.out.println("Returning back to main menu...\n");
					}
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
	}
	
	private static void mainDisplay(Student student)
	{
		if (student.isHaveProject()){
			// Have Project
			System.out.println("========================================");
			System.out.println("|1. Change Password                    |");
			System.out.println("|2. View Registered Project            |");
			System.out.println("|3. View Request History and Status    |");
			System.out.println("|4. Request to Change Project Title    |");
			System.out.println("|5. Request to Deregister FYP          |");
			System.out.println("|6. Logout                             |");
			System.out.println("========================================");
			
		}
		else{
			// No Project
			System.out.println("========================================");
			System.out.println("|1. Change Password                    |");
			System.out.println("|2. View Available Projects            |");
			System.out.println("|3. View Request History and Status    |");
			System.out.println("|4. Request to Register FYP            |");
			System.out.println("|5. Logout                             |");
			System.out.println("========================================");
		
	
		}
	}
}
