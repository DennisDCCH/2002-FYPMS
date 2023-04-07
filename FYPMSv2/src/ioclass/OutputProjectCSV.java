package ioclass;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

import models.Project;

public class OutputProjectCSV {
	private static String filePath = System.getProperty("user.dir") + "\\CSVFiles\\project.csv";
	
	public static void writeCSV(List<Project> projectList) {
		File oldFile = new File(filePath);
		oldFile.delete();
		
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(filePath);
			
			fileWriter.append("Project ID, Supervisor Name, Student Name, Project Title, Project Status");
			fileWriter.append("\n");
			for(Project p: projectList) {
				fileWriter.append(String.valueOf(p.getProjectID()));
				fileWriter.append(",");
				fileWriter.append(p.getSupervisorName());
				fileWriter.append(",");
				fileWriter.append(p.getStudentName());
				fileWriter.append(",");
				fileWriter.append(p.getProjectTitle());
				fileWriter.append(",");
				fileWriter.append(p.getStatus().toString());
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
