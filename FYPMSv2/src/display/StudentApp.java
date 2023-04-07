package display;

import java.util.Scanner;

import ioclass.OutputStudentCSV;
import models.ProjectList;
import models.Student;
import models.StudentList;

public class StudentApp {
	
	public static void display(Student student, ProjectList projectList) {
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		if(student.isHaveProject()) {
			do {
				mainDisplay(student);
				System.out.println("Enter your choice: ");
				choice = sc.nextInt();
				switch(choice) {
					case 1:
						System.out.println("Enter new password: ");
						String password = sc.next();
						student.setPassword(password);
						System.out.println("Password changed\n");
						break;
						
					case 2:
						break;
						
					case 3:
						break;
						
					case 4:
						break;
						
					case 5:
						break;
						
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
				case 1:
					System.out.println("Enter new password: ");
					String password = sc.next();
					student.setPassword(password);
					System.out.println("Password changed\n");
					break;
					
				case 2:
					break;
					
				case 3:
					break;
					
				case 4:
					break;
					
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
