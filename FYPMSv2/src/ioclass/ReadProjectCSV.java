package ioclass;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import enumclass.ProjectStatus;
import models.Project;

public class ReadProjectCSV {
	private static String filePath = System.getProperty("user.dir") + "\\CSVFiles\\project.csv";
	
	public static List<Project> readCSV() {
		BufferedReader reader = null;
		
		try {
			List<Project> projectList = new ArrayList<Project>();
			String line = ",";
			
			reader = new BufferedReader(new FileReader(filePath));
			reader.readLine();
			
			while((line = reader.readLine()) != null) {
				 String[] fields = line.split(",");
				 
				 if(fields.length > 0) {
					 Project s = new Project(Integer.valueOf(fields[0]), fields[1], fields[2], fields[3], fields[4], fields[5], ProjectStatus.valueOf(fields[6])); 
					 projectList.add(s);
				 }
			}
			return projectList;
			
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
