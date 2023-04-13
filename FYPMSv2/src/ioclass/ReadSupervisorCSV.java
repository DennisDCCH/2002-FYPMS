package ioclass;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import models.Supervisor;

/**
 * This class reads from the data file and using the information in the data file make a list of supervisor object
 * @author Dennis Chen
 * @version 1.0
 *
 */
public class ReadSupervisorCSV {
	/**
	 * This stores the filePath to get to the supervisor csv file
	 */
	private static String filePath = System.getProperty("user.dir") + "\\CSVFiles\\supervisor.csv";
	
	/**
	 * This method reads from the csv file and it will make a supervisor object based on the information stored in 
	 * each row of the csv file. Each of this supervisor object is appended into a list to make a list of supervisors
	 * @return the list of supervisors that is made from the information in the csv file
	 */
	public static List<Supervisor> readCSV(){
		BufferedReader reader = null;
		
		try {
			List<Supervisor> supervisorList = new ArrayList<Supervisor>();
			String line = ",";
			
			reader = new BufferedReader(new FileReader(filePath));
			reader.readLine();
			
			while((line = reader.readLine()) != null) {
				 String[] fields = line.split(",");
				 
				 if(fields.length > 0) {
					 Supervisor s = new Supervisor(fields[0], fields[1], fields[2]); 
					 supervisorList.add(s);
				 }
			}
			return supervisorList;
			
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



