package ioclass;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

import models.Request;

public class OutputRequestCSV {
	private static String filePath = System.getProperty("user.dir") + "\\CSVFiles\\request.csv";
	
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
