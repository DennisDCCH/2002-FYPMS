package models;

import java.util.Scanner;

import enumclass.RequestStatus;

public class RequestProcess {
	
	public static void process(Request r) {
		if(handleRequest()) {
			r.setStatus(RequestStatus.APPROVED);
			switch(r.getType()) {
				case CHANGE_TITLE:
					break;
					
				case DEREGISTER_FYP:
					break;
					
				case REGISTER_FYP:
					break;
					
				case TRANSFER_STUDENT:
					break;
			}
		}
		else {
			r.setStatus(RequestStatus.REJECTED);
		}

	}
	
	
	public static boolean handleRequest() {
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
