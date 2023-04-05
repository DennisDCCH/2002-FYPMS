package display;

import java.util.Scanner;

import models.Coordinator;
import models.CoordinatorList;
import models.Student;
import models.StudentList;
import models.Supervisor;
import models.SupervisorList;

public class StartingDisplay {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		StudentList studentList = new StudentList();
		SupervisorList supervisorList = new SupervisorList();
		CoordinatorList coordinatorList = new CoordinatorList();
		
		int choice = 0;
		while (true) {
			//First Interface
			do{
			System.out.println("Welcome to the FYPMS");
			System.out.println("====================");
			System.out.println("|1. Login          |");
			System.out.println("|2. Quit           |");
			System.out.println("====================");
			System.out.println("Enter your choice: ");
			choice = sc.nextInt();
			
				switch(choice) {
				case 1:
					//Login
					break;
				case 2:
					System.out.println("Quiting...");
					System.exit(0);
				default:
					System.out.println("Please choose a valid option");
					System.out.println();
					break;
				}
			}while(choice != 1);
			
			while (true) {
				//Login System
				System.out.println("Enter USERID: ");
				String userID = sc.next();
				System.out.println("Enter PASSWORD: ");
				String password = sc.next();
				
				Student student = studentList.checkDomain(userID);
				Supervisor supervisor = supervisorList.checkDomain(userID);
				Coordinator coordinator = coordinatorList.checkDomain(userID);
				
				if(student != null) {
					if(student.getPassword().equals(password)) {
						System.out.println("Login successfully!");
						StudentApp studentApp = new StudentApp(student, studentList);
						studentApp.display();
						break;
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
						break;
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
						break;
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
}
