package fypms;

import java.util.Collections;
import java.util.Scanner;

public class SupervisorApp {
	Scanner sc = new Scanner(System.in);
	private Supervisor sup;
	private ProjectList projectList;
	private RequestList requestList;

	private CoordinatorList coordinatorList;

	private SupervisorList supervisorList;
	public SupervisorApp(Supervisor ss, ProjectList projectList, RequestList requestList, SupervisorList supervisorList, CoordinatorList coordinatorList) {
		this.sup = ss;
		this.projectList = projectList;
		this.requestList = requestList;
		this.supervisorList = supervisorList;
		this.coordinatorList = coordinatorList;
	}
	
	public void supervisorDisplay() {
		int option = 0;
		do {
			mainDisplay();
			option = sc.nextInt();
			switch(option) {
				case 1:
					System.out.println("Enter new password: ");
					String password = sc.next();
					sup.changePassword(password);
					System.out.println("Password changed\n");
					break;
						
				case 2:
					supervisorProjectDisplay();
					break;
						
				case 3:
					supervisorRequestDisplay();
					break;
						
				case 4:
					//get project id
					System.out.println("Enter Project ID: ");
					int projId = sc.nextInt();

					//get Replacement supervisor ID
					System.out.println("Enter Replacement Supervisor ID: ");
					String repSupId = sc.next();

					// if supervisor has less than 2 project ongoing send the request
					if(this.supervisorList.checkIfSupervisorExist(repSupId) != null){
						if(this.supervisorList.checkIfSupervisorExist(repSupId).getProjectOngoing() < 2){
							this.requestList.addChangeStudentRequest(this.sup, this.coordinatorList.getC(), this.supervisorList.checkIfSupervisorExist(repSupId));
						} else if (this.supervisorList.checkIfSupervisorExist(repSupId).getProjectOngoing() >= 2) {
							System.out.println("Replacement Supervisor already had more than 2 projects ongoing. Choose another supervisor!!");
						}

						System.out.println("Supervisor does not exist");
					}
					break;
						
				case 5:
					System.out.println("Logging out...\n");
					break;
						
				default:
					System.out.println("Please choose a valid option\n");
					break;
			}
		}while(option != 5);
	}
	
	private void mainDisplay() {
		if(requestList.checkSupervisorPendingRequest(sup)) {
			System.out.println("========================================");
			System.out.println("|1. Change Password                    |");
			System.out.println("|2. Projects                           |");
			System.out.println("|3. Request (New)                      |");
			System.out.println("|4. Request to Transfer Student        |");
			System.out.println("|5. Logout                             |");
			System.out.println("========================================");
			System.out.println("Enter your choice: ");
		}
		else {
			System.out.println("========================================");
			System.out.println("|1. Change Password                    |");
			System.out.println("|2. Projects                           |");
			System.out.println("|3. Request                            |");
			System.out.println("|4. Request to Transfer Student        |");
			System.out.println("|5. Logout                             |");
			System.out.println("========================================");
			System.out.println("Enter your choice: ");
		}
	}
	
	private void supervisorProjectDisplay() {
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
				case 1:
					System.out.println("Enter Project Title: ");
					String projectTitle = sc.next();
					projectList.addProject(sup, projectTitle);
					break;
					
				case 2:
					projectList.printSupervisorProject(sup);
					System.out.println("Enter the Project ID that you want to change title: ");
					int id = sc.nextInt();
					System.out.println("Enter your new Project Title: ");
					String title = sc.next();
					projectList.getProject(id).setProjectTitle(title);
					System.out.println("Project title changed!\n");
					break;
					
				case 3:
					projectList.printSupervisorProject(sup);
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
	
	private void supervisorRequestDisplay() {
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
					//not done!
					break;
					
				case 2:
					requestList.printSupervisorSendRequest(sup);
					break;
					
				case 3:
					requestList.printSupervisorReceiveRequest(sup);
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
