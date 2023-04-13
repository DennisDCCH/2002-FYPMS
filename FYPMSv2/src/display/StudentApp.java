package display;

import java.util.Scanner;

import enumclass.ProjectStatus;
import enumclass.RequestStatus;
import enumclass.RequestType;
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
import models.SupervisorList;

/**
 * This class is the student menu for the FYP management system.
 * @author Dennis Chen
 * @version 1.0
 *
 */
public class StudentApp {
	
	/**
	 * This method have all the functions that a student can access in the FYP management system.
	 * @param student this is the student object that that is entered into the system after the user log in.
	 */
	public static void display(Student student) {
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		if(student.isHaveProject()) {
			do {
				mainDisplay(student);
				System.out.println("Enter your choice: ");
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
						boolean bool = true;
						for(Request r: student.getRequestList()) {
							if(r.getStatus() == RequestStatus.PENDING) {
								if(r.getType() == RequestType.CHANGE_TITLE)
									bool = false;
							}
						}
						if(bool) {
							String title;
							while(true) {
								System.out.println("Enter the new project title: ");
								title = sc.nextLine();
								if(title.contains(",")) 
									System.out.println("The project title cannot contain commas (,)");
								else
									break;
							}
							Request changeTitleRequest = new ChangeTitleRequest(RequestList.getNextRequestID(), student.getUserName(), student.getProject().getSupervisorName(),
									student.getProject().getProjectID(), RequestStatus.PENDING, title);
							
							//Append request to overall requestList and student requestList
							student.addRequest(changeTitleRequest);
							RequestList.addRequest(changeTitleRequest);
							
							System.out.println("The request have been send out.\n");
						}
						else
							System.out.println("You have already requested to change project title, please wait for approval!");
						break;
						
					// Request to Deregister FYP
					case 5:
						bool = true;
						for(Request r: student.getRequestList()) {
							if(r.getStatus() == RequestStatus.PENDING) {
								if(r.getType() == RequestType.DEREGISTER_FYP)
									bool = false;
							}
						}
						
						if(bool) {
							Request deregisterRequest = new DeregisterFYPRequest(RequestList.getNextRequestID(), student.getUserName(), "Li Fang", student.getProject().getProjectID(),
									RequestStatus.PENDING, null);
							
							//Append request to overall requestList and student requestList
							student.addRequest(deregisterRequest);
							RequestList.addRequest(deregisterRequest);
							
							System.out.println("The request have been send out.\n");
						}
						else 
							System.out.println("You have already requested to deregistered from FYP, please wait for approval!");
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
					boolean bool = true;
					for(Request r: student.getRequestList()) {
						if(r.getStatus() == RequestStatus.PENDING) {
							if(r.getType() == RequestType.REGISTER_FYP)
								bool = false;
						}
					}
					
					if(bool) {
						PrintProjectList.printStatusSpecificProjects(ProjectStatus.AVAILABLE);
						System.out.println("Enter the project ID to register for: ");
						int id = sc.nextInt();
						
						if(ProjectList.getSpecificAvailableProject(id) != null) {
							ProjectList.getSpecificAvailableProject(id).setStatus(ProjectStatus.RESERVED);
							Request registerRequest = new RegisterFYPRequest(RequestList.getNextRequestID(), student.getUserName(), "Li Fang", 
									id, RequestStatus.PENDING, student.getEmail());
						
							//Append request to overall requestList and student requestList
							student.addRequest(registerRequest);
							RequestList.addRequest(registerRequest);
							
							//Update the project supervisor project list status
							SupervisorList.getSpecificSupervisor(ProjectList.getSpecificProject(id).getSupervisorName()).checkAndSetProjectStatus();
							System.out.println("The request have been send out.\n");
						}
						else {
							System.out.println("You have entered a invalid project ID!");
							System.out.println("Returning back to main menu...\n");
						}
					}
					else
						System.out.println("You have already registered for a project, please wait for approval!");		
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
	
	/**
	 * This method prints the menu screen for the student
	 * @param student this is the student object that that is entered into the system after the user log in.
	 */
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
