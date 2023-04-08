package ioclass;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

import models.Coordinator;

public class OutputCoordinatorCSV {
	private static String filePath = System.getProperty("user.dir") + "\\CSVFiles\\coordinator.csv";
	
	public static void writeCSV(List<Coordinator> coordinators) {
		File oldFile = new File(filePath);
		oldFile.delete();
		
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(filePath);
			
			fileWriter.append("Name, Email, Password");
			fileWriter.append("\n");
			for(Coordinator c: coordinators) {
				fileWriter.append(c.getUserName());
				fileWriter.append(",");
				fileWriter.append(c.getEmail());
				fileWriter.append(",");
				fileWriter.append(c.getPassword());
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
