package fypms;

import java.util.Scanner;
public class MainApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		StudentList stu = new StudentList();
		SupervisorList sup = new SupervisorList();
		CoordinatorList coord = new CoordinatorList();
		ProjectList projectList = new ProjectList();
		
		int choice = 0;
		
		while (true){
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
				
				//To determine what domain of the user
				Student s = stu.checkDomain(userID);
				Supervisor ss = sup.checkDomain(userID);
				Coordinator c = coord.checkDomain(userID);
				
				if(s != null) {
					if(s.checkPassword(password)) {
						System.out.println("Login successfully!");
						StudentApp sapp = new StudentApp(s, projectList);
						sapp.studentInterface();
						break;
					}
					else {
						System.out.println("You have entered the wrong PASSWORD!");
						System.out.println("Please try again!");
						System.out.println();
					}
				}
				else if (ss != null) {
					if(ss.checkPassword(password)) {
						System.out.println("Login successfully!");
						SupervisorApp ssapp = new SupervisorApp(ss, projectList);
						ssapp.supervisorInterface(ss.isPendingRequest());
						break;
					}
					else {
						System.out.println("You have entered the wrong PASSWORD!");
						System.out.println("Please try again!");
						System.out.println();
					}
				}
				else if(c != null) {
					if(c.checkPassword(password)) {
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
