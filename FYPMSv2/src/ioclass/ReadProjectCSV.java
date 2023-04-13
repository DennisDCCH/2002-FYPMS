package ioclass;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import enumclass.ProjectStatus;
import models.Project;

/**
 * This class reads from the data file and using the information in the data file make a list of project object
 * @author Dennis Chen
 * @version 1.0
 *
 */
public class ReadProjectCSV {
	/**
	 * This stores the filePath to get to the project csv file
	 */
	private static String filePath = System.getProperty("user.dir") + "\\CSVFiles\\project.csv";
	
	/**
	 * This method reads from the csv file and it will make a project object based on the information stored in 
	 * each row of the csv file. Each of this project object is appended into a list to make a list of projects
	 * @return the list of projects that is made from the information in the csv file
	 */
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
