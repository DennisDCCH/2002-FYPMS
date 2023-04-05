package ioclass;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import models.Supervisor;

public class ReadSupervisorCSV {
	private static String filePath = System.getProperty("user.dir") + "\\CSVFiles\\supervisor.csv";
	
	public ReadSupervisorCSV() {
		
	}
	
	public List<Supervisor> readCSV(){
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



