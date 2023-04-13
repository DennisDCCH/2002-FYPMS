package ioclass;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

import models.Request;

/**
 * This class exports a new csv file based on the information attained from a list of requests
 * @author Dennis Chen
 * @version 1.0
 *
 */
public class OutputRequestCSV {
	/**
	 * This stores the filePath to get to the request csv file
	 */
	private static String filePath = System.getProperty("user.dir") + "\\CSVFiles\\request.csv";
	
	/**
	 * This method deleted the old csv file in the filepath and makes a new one based on the information attained 
	 * from a list of requests
	 * @param requestList the information based on this list of requests that is to be saved in a csv file
	 */
	public static void writeCSV(List<Request> requestList) {
		File oldFile = new File(filePath);
		oldFile.delete();
		
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(filePath);
			
			fileWriter.append("Request ID, Requester Name, Responder Name, Project ID, Request Type, Request Status, Additional Info");
			fileWriter.append("\n");
			for(Request r: requestList) {
				fileWriter.append(String.valueOf(r.getRequestID()));
				fileWriter.append(",");
				fileWriter.append(r.getRequesterName());
				fileWriter.append(",");
				fileWriter.append(r.getResponderName());
				fileWriter.append(",");
				fileWriter.append(String.valueOf(r.getProjectID()));
				fileWriter.append(",");
				fileWriter.append(r.getType().toString());
				fileWriter.append(",");
				fileWriter.append(r.getStatus().toString());
				fileWriter.append(",");
				fileWriter.append(r.getAdditionalInfo());
				fileWriter.append("\n");
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
