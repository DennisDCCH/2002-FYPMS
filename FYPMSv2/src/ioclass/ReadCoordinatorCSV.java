package ioclass;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import models.Coordinator;
import models.ProjectList;
import models.User;

public class ReadCoordinatorCSV {
	private static String filePath = System.getProperty("user.dir") + "\\CSVFiles\\coordinator.csv";
	
	public static List<Coordinator> readCSV(ProjectList projectList) {
		BufferedReader reader = null;
		
		try {
			List<Coordinator> coordinatorList = new ArrayList<Coordinator>();
			String line = ",";
			
			reader = new BufferedReader(new FileReader(filePath));
			reader.readLine();
			
			while((line = reader.readLine()) != null) {
				 String[] fields = line.split(",");
				 
				 if(fields.length > 0) {
					 Coordinator s = new Coordinator(fields[0], fields[1], fields[2], projectList); 
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
