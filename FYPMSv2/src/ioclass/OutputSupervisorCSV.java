package ioclass;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

import models.Supervisor;

/**
 * This class exports a new csv file based on the information attained from a list of supervisors
 * @author Dennis Chen
 * @version 1.0
 *
 */
public class OutputSupervisorCSV {
	/**
	 * This stores the filePath to get to the supervisor csv file
	 */
	private static String filePath = System.getProperty("user.dir") + "\\CSVFiles\\supervisor.csv";
	
	/**
	 * This method deleted the old csv file in the filepath and makes a new one based on the information attained 
	 * from a list of supervisors
	 * @param supervisors the information based on this list of supervisors that is to be saved in a csv file
	 */
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
