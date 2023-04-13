package ioclass;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import models.Coordinator;
import models.User;

/**
 * This class reads from the data file and using the information in the data file make a list of coordinator object
 * @author Dennis Chen
 * @version 1.0
 *
 */
public class ReadCoordinatorCSV {
	/**
	 * This stores the filePath to get to the coordinator csv file
	 */
	private static String filePath = System.getProperty("user.dir") + "\\CSVFiles\\coordinator.csv";
	
	/**
	 * This method reads from the csv file and it will make a coordinator object based on the information stored in 
	 * each row of the csv file. Each of this coordinator object is appended into a list to make a list of coordinators
	 * @return the list of coordinators that is made from the information in the csv file
	 */
	public static List<Coordinator> readCSV() {
		BufferedReader reader = null;
		
		try {
			List<Coordinator> coordinatorList = new ArrayList<Coordinator>();
			String line = ",";
			
			reader = new BufferedReader(new FileReader(filePath));
			reader.readLine();
			
			while((line = reader.readLine()) != null) {
				 String[] fields = line.split(",");
				 
				 if(fields.length > 0) {
					 Coordinator s = new Coordinator(fields[0], fields[1], fields[2]); 
					 coordinatorList.add(s);
				 }
			}
			return coordinatorList;
			
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
