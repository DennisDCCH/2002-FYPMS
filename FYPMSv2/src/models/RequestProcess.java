package models;

import java.util.Scanner;

import enumclass.RequestStatus;

public class RequestProcess {
	
	public static void process(Request r) {
		if(handleRequest()) {
			r.setStatus(RequestStatus.APPROVED);
			switch(r.getType()) {
				case CHANGE_TITLE:
					ProcessChangeTitleRequest.manageRequest(r);
					break;
					
				case DEREGISTER_FYP:
					ProcessDeregisterFYPRequest.manageRequest(r);
					break;
					
				case REGISTER_FYP:
					ProcessRegisterFYPRequest.manageRequest(r);
					break;
					
				case TRANSFER_STUDENT:
					ProcessTransferStudentRequest.manageRequest(r);
					break;
			}
			System.out.println("The request have been accepted!");
			System.out.println("Returning back to the request menu...\n");
		}
		else {
			r.setStatus(RequestStatus.REJECTED);
			System.out.println("The request have been rejected!");
			System.out.println("Returning back to the request menu...\n");
		}

	}
	
	
	private static boolean handleRequest() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("======================");
			System.out.println("|1. Approve          |");
			System.out.println("|2. Reject           |");
			System.out.println("======================");
			int choice = sc.nextInt();
			switch(choice) {
				case 1:
					return true;
					
				case 2:
					return false;
					
				default:
					System.out.println("Please choose a valid option\n");
					break;
			}
		}
	}
}
