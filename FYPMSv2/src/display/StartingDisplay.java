package display;

import java.util.Scanner;

import ioclass.OutputCoordinatorCSV;
import ioclass.OutputProjectCSV;
import ioclass.OutputStudentCSV;
import ioclass.OutputSupervisorCSV;
import models.CoordinatorList;
import models.ProjectList;
import models.StudentList;
import models.SupervisorList;

public class StartingDisplay {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		ProjectList projectList = new ProjectList();
		StudentList studentList = new StudentList(projectList);
		SupervisorList supervisorList = new SupervisorList(projectList);
		CoordinatorList coordinatorList = new CoordinatorList(projectList);
		
		
		int choice = 0;
		while (true) {
			//First Display
			System.out.println("Welcome to the FYPMS");
			System.out.println("====================");
			System.out.println("|1. Login          |");
			System.out.println("|2. Quit           |");
			System.out.println("====================");
			System.out.println("Enter your choice: ");
			choice = sc.nextInt();
			
			switch(choice) {
				case 1:
					Login.login(studentList, supervisorList, coordinatorList, projectList);
					break;
				case 2:
					System.out.println("Quiting...");
					OutputStudentCSV.writeCSV(studentList.getStudentList());
					OutputSupervisorCSV.writeCSV(supervisorList.getSupervisorList());
					OutputCoordinatorCSV.writeCSV(coordinatorList.getCoordinatorList());
					OutputProjectCSV.writeCSV(projectList.getProjectList());
					System.exit(0);
				default:
					System.out.println("Please choose a valid option");
					System.out.println();
					break;
			}
		}
	}
}
