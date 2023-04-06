package display;

import java.util.Scanner;

import models.Coordinator;
import models.CoordinatorList;
import models.ProjectList;
import models.Student;
import models.StudentList;
import models.Supervisor;
import models.SupervisorList;

public class Login {
	
	public static void login(StudentList studentList, SupervisorList supervisorList, CoordinatorList coordinatorList, ProjectList projectList) {
		Scanner sc = new Scanner(System.in);
			
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
					StudentApp.display(student, projectList);
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
					SupervisorApp.display(supervisor, projectList);
					return;
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
