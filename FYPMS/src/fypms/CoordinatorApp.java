package fypms;

import java.util.Scanner;

import fypms.Project.Status;

public class CoordinatorApp {
	Scanner sc = new Scanner(System.in);
	private Coordinator c;
	private ProjectList projectList;
	private RequestList requestList;
	private SupervisorList supervisorList;
	
	public CoordinatorApp(Coordinator c, ProjectList projectList, RequestList requestList, SupervisorList supervisorList) {
		this.c = c;
		this.projectList = projectList;
		this.requestList = requestList;
		this.supervisorList = supervisorList;
	}
	
	public void coordinatorInterface() {
		int option = 0;
		do {
			mainInterface();
			option = sc.nextInt();
			switch(option) {
				case 1:
					System.out.println("Enter new password: ");
					String password = sc.next();
					c.changePassword(password);
					System.out.println("Password changed\n");
					break;
					
				case 2:
					coordinatorProjectInterface();
					break;
					
				case 3:
					coordinatorRequestInterface();
					break;
					
				case 4:
					System.out.println("Logging out...\n");
					break;
					
				default:
					System.out.println("Please choose a valid option\n");
					break;
			}
		}while(option != 4);
	}
	
	private void mainInterface() {
		if(requestList.checkCoordinatorPendingRequest(c)) {
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
	
	private void coordinatorProjectInterface() {
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
			case 1:
				break;
				
			case 2:
				projectStatusInterface();
				break;
				
			case 3:
				projectSupervisorInterface();
				break;
				
			case 4:
				System.out.println("Returning...\n");
				break;
				
			default:
				System.out.println("Please choose a valid option\n");
				break;
			}
		}while(option != 4);
	}
	
	private void coordinatorRequestInterface(){
		int option = 0;
		do {
			System.out.println("========================================");
			System.out.println("|1. Pending Request                    |");
			System.out.println("|2. Incoming Request History and Status|");
			System.out.println("|3. Return                             |");
			System.out.println("========================================");
			System.out.println("Enter your choice: ");
			option = sc.nextInt();
			switch(option) {
				case 1:
					//not done!
					break;
					
				case 2:
					requestList.printCoordinatorReceiveRequest(c);
					break;
					
				case 3:
					System.out.println("Returning... \n");
					break;
					
				default:
					System.out.println("Please choose a valid option\n");
					break;	
			}
		}while(option != 3);
	}
	
	private void projectStatusInterface() {
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
					projectList.printStatusProject(Status.AVAILABLE);
					break;
					
				case 2:
					projectList.printStatusProject(Status.RESERVED);
					break;
					
				case 3:
					projectList.printStatusProject(Status.ALLOCATED);
					break;
					
				case 4:
					projectList.printStatusProject(Status.UNAVAILABLE);
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
	
	private void projectSupervisorInterface() {
		int choice = 0;
		do {
			System.out.println("==============================");
			System.out.println("|1. A S Madhukumar           |");
			System.out.println("|2. Alexei Sourin            |");
			System.out.println("|3. Arvind Easwaran          |");
			System.out.println("|4. Bo An                    |");
			System.out.println("|5. Cai Wentong              |");
			System.out.println("|6. Chen Change Loy          |");
			System.out.println("|7. Chia Liang Tien          |");
			System.out.println("|8. Cong Gao                 |");
			System.out.println("|9. Douglas Leslie Maskell   |");
			System.out.println("|10. Dusit Niyato            |");
			System.out.println("|11. Ke Yiping, Kelly        |");
			System.out.println("|12. Return                  |");
			System.out.println("==============================");
			System.out.println("Enter the supervisor: ");
			choice = sc.nextInt();
			switch(choice) {
				case 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11:
					projectList.printSupervisorProject(supervisorList.getSupervisor(choice));
					break;
					
				case 12:
					System.out.println("Returning...\n");
					System.out.println();
					break;
					
				default:
					System.out.println("Please choose a valid option\n");
					System.out.println();
					break;
			}
		}while(choice != 12);
	}
}
