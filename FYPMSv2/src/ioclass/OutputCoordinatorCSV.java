package ioclass;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

import models.Coordinator;

/**
 * This class exports a new csv file based on the information attained from a list of coordinators
 * @author Dennis Chen
 * @version 1.0
 *
 */
public class OutputCoordinatorCSV {
	/**
	 * This stores the filePath to get to the coordinator csv file
	 */
	private static String filePath = System.getProperty("user.dir") + "\\CSVFiles\\coordinator.csv";
	
	/**
	 * This method deleted the old csv file in the filepath and makes a new one based on the information attained 
	 * from a list of coordinators
	 * @param coordinators the information based on this list of coordinators that is to be saved in a csv file
	 */
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
