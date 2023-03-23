package fypms;

import java.util.Scanner;

import fypms.Project.Status;
import fypms.Request.requestStatus;
import fypms.Request.requestType;

public class RequestProcessing {
	Scanner sc = new Scanner(System.in);
	private Request r;
	private ProjectList projectList;
	
	public RequestProcessing(Request r, ProjectList projectList) {
		this.r = r;
		this.projectList = projectList;
		
		requestReview();
	}
	
	private void requestReview(){
		int choice = 0;
		System.out.println("======================");
		System.out.println("|1. Approve          |");
		System.out.println("|2. Reject           |");
		System.out.println("======================");
		do {
			System.out.println("Enter your choice: ");
			choice = sc.nextInt();
			switch(choice) {
				case 1:
					System.out.println("The request have been approved!\n");
					r.setStatus(requestStatus.APPROVED);
					if(r.getType() == requestType.CHANGE_TITLE) 
						r.getP().setProjectTitle(r.getProjectTitle());
					else  if(r.getType() == requestType.DEREGISTER_FYP) 
						registerFYP();
					else if(r.getType() == requestType.REGISTER_FYP) 
						deregisterFYP();
					else if(r.getType() == requestType.TRANSFER_STUDENT) 
						changeStudent();
					break;
					
				case 2:
					System.out.println("The request have been rejected!\n");
					if(r.getType() == requestType.REGISTER_FYP)
						r.getP().setStatus(Status.AVAILABLE);
					r.setStatus(requestStatus.REJECTED);
					break;
					
				default:
					System.out.println("Please choose a valid option\n");
					break;
			}
		}while(choice != 1 && choice != 2);
	}
	
	private void registerFYP() {
		//Set student
		if(r.getP().getStatus() == Status.RESERVED) {
			r.getP().setS(r.getsSender());
			
			//Set project status
			r.getP().setStatus(Status.ALLOCATED);
			
			//Update supervisor ongoing project
			r.getP().getSs().addProject();
			
			//Check supervisor total allocated project
			if(r.getP().getSs().getProjectOngoing() == 2) 
				projectList.setUnavail(r.getP().getSs());
		}
		else {
			System.out.println("The supervisor already have 2 allocated projects.");
			System.out.println("This request cannot be approved!");
			System.out.println("This request will automatically be rejected!");
			r.setStatus(requestStatus.REJECTED);
		}
	}
	
	private void deregisterFYP() {
		//Set student as null
		r.getP().setS(null);
		
		//Set project status
		r.getP().setStatus(Status.AVAILABLE);
		
		//Update supervisor ongoing project
		r.getP().getSs().minusProject();
		
		//Check supervisor total allocated project
		if(r.getP().getSs().getProjectOngoing() == 1) 
			projectList.setAvail(r.getP().getSs());
	}
	
	private void changeStudent() {
		//Update old supervisor total allocated project
		r.getP().getSs().minusProject();
		
		if(r.getP().getSs().getProjectOngoing() == 1) 
			projectList.setAvail(r.getP().getSs());
		
		//Set replacement supervisor to project
		r.getP().setSs(r.getReplacementSS());
		
		//Update new supervisor total allocated project
		r.getP().getSs().addProject();
		
		if(r.getP().getSs().getProjectOngoing() == 2) 
			projectList.setUnavail(r.getP().getSs());
	}
}
