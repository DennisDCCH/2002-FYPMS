package fypms;

import java.util.Scanner;
import fypms.Project.Status;

public class StudentApp {
	Scanner sc = new Scanner(System.in);
	private Student stu;
	private ProjectList projectList;
	
	public StudentApp(Student stu, ProjectList projectList) {
		this.stu = stu;
		this.projectList = projectList;
	}
	
	public void studentInterface() {
		int option = 0;
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
				case 1:
					System.out.println("Enter new password: ");
					String password = sc.next();
					stu.changePassword(password);
					break;
					
				case 2:
					break;
					
				case 3:
					projectList.printStatusProject(Status.AVAILABLE);
					break;
					
				case 4:
					break;
					
				case 5:
					break;
					
				case 6:
					break;
					
				case 7:
					break;
					
				case 8:
					break;
					
				default:
					System.out.println("Please choose a valid option");
					System.out.println();
					break;
				
			}
		}while(option != 8);
		
	}
}
