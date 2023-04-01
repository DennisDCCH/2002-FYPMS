package Program;

import java.util.ArrayList;

public class Student extends User {

	private ArrayList<String> deregisteredProject;
	private boolean projectStatus;
	private StudentAppInterface menuDisplay = new StudentHaveProject();

	
	public Student(UserReadFile file) 
	{
		super(file);
		this.deregisteredProject = new ArrayList<String>();
		
	}
	
	public ArrayList<String> getDeregisteredProject()
	{
		return this.deregisteredProject;
	}
	public void menu()
	{
		menuDisplay.menu();
	}
	

	

}