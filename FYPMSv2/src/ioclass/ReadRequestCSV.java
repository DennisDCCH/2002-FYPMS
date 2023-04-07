package ioclass;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import enumclass.RequestStatus;
import enumclass.RequestType;
import models.ChangeTitleRequest;
import models.DeregisterFYPRequest;
import models.RegisterFYPRequest;
import models.Request;
import models.TransferStudentRequest;

public class ReadRequestCSV {
	private static String filePath = System.getProperty("user.dir") + "\\CSVFiles\\request.csv";
	
	public static List<Request> readCSV() {
		BufferedReader reader = null;
		
		try {
			List<Request> requestList = new ArrayList<Request>();
			String line = ",";
			
			reader = new BufferedReader(new FileReader(filePath));
			reader.readLine();
			
			while((line = reader.readLine()) != null) {
				 String[] fields = line.split(",");
				 
				 if(fields.length > 0) {
					 switch(RequestType.valueOf(fields[4])) {
						case CHANGE_TITLE:
							Request r1 = new ChangeTitleRequest(Integer.valueOf(fields[0]), fields[1], fields[2], 
									Integer.valueOf(fields[3]), RequestStatus.valueOf(fields[5]), fields[6]);
							requestList.add(r1);
							break;
						case DEREGISTER_FYP:
							Request r2 = new DeregisterFYPRequest(Integer.valueOf(fields[0]), fields[1], fields[2], 
									Integer.valueOf(fields[3]), RequestStatus.valueOf(fields[5]), fields[6]);
							requestList.add(r2);
							break;
						case REGISTER_FYP:
							Request r3 = new RegisterFYPRequest(Integer.valueOf(fields[0]), fields[1], fields[2], 
									Integer.valueOf(fields[3]), RequestStatus.valueOf(fields[5]), fields[6]);
							requestList.add(r3);
							break;
						case TRANSFER_STUDENT:
							Request r4 = new TransferStudentRequest(Integer.valueOf(fields[0]), fields[1], fields[2], 
									Integer.valueOf(fields[3]), RequestStatus.valueOf(fields[5]), fields[6]);
							requestList.add(r4);
							break;
					 }		 
				 }
			}
			return requestList;
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			try {
				reader.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
