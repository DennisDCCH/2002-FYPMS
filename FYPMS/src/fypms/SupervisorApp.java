package fypms;

import java.util.Scanner;

public class SupervisorApp {
	Scanner sc = new Scanner(System.in);
	private Supervisor sup;
	private ProjectList projectList;
	private RequestList requestList;
	
	public SupervisorApp(Supervisor ss, ProjectList projectList, RequestList requestList) {
		this.sup = ss;
		this.projectList = projectList;
		this.requestList = requestList;
	}
	
	public void supervisorInterface(boolean pendingRequest) {
		int option = 0;
		if(pendingRequest) {
			System.out.println("========================================");
			System.out.println("|1. Change Password                    |");
			System.out.println("|2. Projects                           |");
			System.out.println("|3. Request (New)                      |");
			System.out.println("|4. Request to Transfer Student        |");
			System.out.println("|5. Logout                             |");
			System.out.println("========================================");
			System.out.println("Enter your choice: ");
			option = sc.nextInt();
			
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
			option = sc.nextInt();
		}
	}
}
