package fypms;

import java.util.Scanner;
import fypms.Project.Status;

public class StudentApp {
	Scanner sc = new Scanner(System.in);
	private Student stu;
	private ProjectList projectList;
	private RequestList requestList;
	private Coordinator c;
	
	public StudentApp(Student stu, ProjectList projectList, RequestList requestList, Coordinator c) {
		this.stu = stu;
		this.projectList = projectList;
		this.requestList = requestList;
		this.c = c;
	}
	
	public void studentInterface() {
		int option = 0, id = 0;
		do {
			System.out.println("========================================");
			System.out.println("|1. Change Password                    |");
			System.out.println("|2. View Registered Project            |");
			System.out.println("|3. View Available Projects            |");
			System.out.println("|4. View Request History and Status    |");
			System.out.println("|5. Request to Register FYP            |");
			System.out.println("|6. Request to Change Project Title    |");
			System.out.println("|7. Request to Deregister FYP          |");
			System.out.println("|8. Logout                             |");
			System.out.println("========================================");
			System.out.println("Enter your choice: ");
			option = sc.nextInt();
			switch(option) {
				case 1: //Change Password
					System.out.println("Enter new password: ");
					String password = sc.next();
					stu.changePassword(password);
					System.out.println("Password changed\n");
					break;
					
				case 2: //View Registered Project
					if(projectList.checkStudentProject(stu)) 
						projectList.printStudentProject(stu);
					else
						System.out.println("You have not registered a project!\n");
					break;
					
				case 3: //View Available Project
					projectList.printStatusProject(Status.AVAILABLE);
					break;
					
				case 4: //View Request History and Status
					requestList.printStudentSendRequest(stu);
					break;
					
				case 5: //Request to Register FYP
					if(projectList.checkStudentProject(stu)) 
						System.out.println("You have a project already");
					else {
						projectList.printStatusProject(Status.AVAILABLE);
						System.out.println("Enter the project ID that you want to register to: ");
						id = sc.nextInt();
						requestList.addRegisterFYPRequest(stu, c, projectList.getProject(id));
						System.out.println("Your request have been sent.\n");
					}
					break;
					
				case 6: //Request to Change Project Title
					if(projectList.checkStudentProject(stu)) {
						System.out.println("Enter your new Project Title: ");
						String title = sc.next();
						requestList.addChangeTitleRequest(stu, projectList.getStudentProject(stu).getSs(), title);
						System.out.println("Your request have been sent.\n");
					}
					else 
						System.out.println("You have not registered a project\n");
					break;
					
				case 7: //Request to Deregister FYP
					if(projectList.checkStudentProject(stu)) {
						requestList.addDeregisterFYPRequest(stu, c, projectList.getStudentProject(stu));
						System.out.println("Your request have been sent.\n");
					}
					else 
						System.out.println("You have not registered a project\n");
					break;
					
				case 8: //Logout
					System.out.println("Logging out...\n");
					System.out.println();
					break;
					
				default:
					System.out.println("Please choose a valid option\n");
					System.out.println();
					break;
				
			}
		}while(option != 8);
		
	}
}
