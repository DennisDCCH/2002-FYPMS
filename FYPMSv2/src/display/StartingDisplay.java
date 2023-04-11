package display;

import java.io.IOException;
import java.util.Scanner;

import ioclass.OutputCoordinatorCSV;
import ioclass.OutputProjectCSV;
import ioclass.OutputRequestCSV;
import ioclass.OutputStudentCSV;
import ioclass.OutputSupervisorCSV;
import ioclass.RestartCSV;
import models.Coordinator;
import models.CoordinatorList;
import models.ProjectList;
import models.RequestList;
import models.Student;
import models.StudentList;
import models.Supervisor;
import models.SupervisorList;

public class StartingDisplay {
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		int choice = 0;
		while (true) {
			//First Display
			System.out.println("Welcome to the FYPMS");
			System.out.println("====================");
			System.out.println("|1. Login          |");
			System.out.println("|2. Reset System   |");
			System.out.println("|3. Quit           |");
			System.out.println("====================");
			System.out.println("Enter your choice: ");
			choice = sc.nextInt();
			
			switch(choice) {
				case 1:
					ProjectList.intialise();
					RequestList.intialise();
					StudentList.initialise();
					SupervisorList.initialise();
					CoordinatorList.initalise();
					
					Login.login();
					
					OutputStudentCSV.writeCSV(StudentList.getStudentList());
					OutputSupervisorCSV.writeCSV(SupervisorList.getSupervisorList());
					OutputCoordinatorCSV.writeCSV(CoordinatorList.getCoordinatorList());
					OutputProjectCSV.writeCSV(ProjectList.getProjectList());
					OutputRequestCSV.writeCSV(RequestList.getRequestList());
					break;
					
				case 2:
					RestartCSV.restart();
					break;
					
				case 3:
					System.out.println("Quiting...");
					System.exit(0);
				default:
					System.out.println("Please choose a valid option");
					System.out.println();
					break;
			}
		}
	}
}
