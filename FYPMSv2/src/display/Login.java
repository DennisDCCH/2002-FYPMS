package display;

import java.util.Scanner;

import models.Coordinator;
import models.CoordinatorList;
import models.ProjectList;
import models.Student;
import models.StudentList;
import models.Supervisor;
import models.SupervisorList;

/**
 * This class is the login screen of the FYP management system
 * @author Dennis
 * @version 1.0
 *
 */
public class Login {
	
	/**
	 * This method is the login screen of the FYP management system. It will ask for the user's id and password and 
	 * check whether it is valid. If valid it will send this user to a menu depending on whether this user is a student,
	 * supervisor or coordinator. 
	 */
	public static void login() {
		Scanner sc = new Scanner(System.in);
			
		while (true) {
			//Login System
			System.out.println("Enter USERID: ");
			String userID = sc.next();
			System.out.println("Enter PASSWORD: ");
			String password = sc.next();
			
			Student student = StudentList.checkDomain(userID);
			Supervisor supervisor = SupervisorList.checkDomain(userID);
			Coordinator coordinator = CoordinatorList.checkDomain(userID);
			
			if(student != null) {
				if(student.getPassword().equals(password)) {
					if(student.getDeregisteredFYP() == 1) {
						System.out.println("You have been deregistered from FYP and can no longer login!");
						return;
					}
					else {
						System.out.println("Login successfully!");
						StudentApp.display(student);
						return;
					}
				}
				else {
					System.out.println("You have entered the wrong PASSWORD!");
					System.out.println("Please try again!");
					System.out.println();
				}
			}
			else if(coordinator != null) {
				if(coordinator.getPassword().equals(password)) {
					System.out.println("Login successfully!");
					CoordinatorApp.display(SupervisorList.getSpecificSupervisor(coordinator.getUserName()));
					return;
				}
				else {
					System.out.println("You have entered the wrong PASSWORD!");
					System.out.println("Please try again!");
					System.out.println();
				}
			}
			else if (supervisor != null) {
				if(supervisor.getPassword().equals(password)) {
					System.out.println("Login successfully!");
					SupervisorApp.display(supervisor);
					return;
				}
				else {
					System.out.println("You have entered the wrong PASSWORD!");
					System.out.println("Please try again!");
					System.out.println();
				}
			}
			else {
				System.out.println("You have entered the wrong USERID!");
				System.out.println("Please try again!");
				System.out.println();
			}		
		}
	}
}
