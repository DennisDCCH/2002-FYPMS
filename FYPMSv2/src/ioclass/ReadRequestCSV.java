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

/**
 * This class reads from the data file and using the information in the data file make a list of request object
 * @author Dennis Chen
 * @version 1.0
 *
 */
public class ReadRequestCSV {
	/**
	 * This stores the filePath to get to the request csv file
	 */
	private static String filePath = System.getProperty("user.dir") + "\\CSVFiles\\request.csv";
	
	/**
	 * This method reads from the csv file and it will make a request object based on the information stored in 
	 * each row of the csv file. Each of this request object is appended into a list to make a list of requests.
	 * @return the list of requests that is made from the information in the csv file
	 */
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
