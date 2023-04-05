package ioclass;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

import models.Supervisor;

public class OutputSupervisorCSV {
	private static String filePath = System.getProperty("user.dir") + "\\CSVFiles\\supervisor.csv";
	
	public static void writeCSV(List<Supervisor> supervisors) {
		File oldFile = new File(filePath);
		oldFile.delete();
		
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(filePath);
			
			fileWriter.append("Name, Email, Password");
			fileWriter.append("\n");
			for(Supervisor s: supervisors) {
				fileWriter.append(s.getUserName());
				fileWriter.append(",");
				fileWriter.append(s.getEmail());
				fileWriter.append(",");
				fileWriter.append(s.getPassword());
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
