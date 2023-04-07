package models;

import java.util.List;

public class User {
	protected String userName;
	protected String email;
	protected String userID;
	protected String password;
	protected List<Project> myProjectList;
	
	//Constructor
	public User(String userName, String email, String password, ProjectList projectList) {
		this.userName = userName;
		this.email = email;
		String[] parts = email.split("@");
		userID = parts[0];
		this.password = password;
		myProjectList = projectList.getUserProjectList(userName);
	}
	
	public void printProjectDetails() {
		for(Project p: myProjectList)
			p.printProject();
	}

	//Getter Setter
	public String getUserName() {
		return userName;
	}

	public String getEmail() {
		return email;
	}

	public String getUserID() {
		return userID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Project> getProjectList() {
		return myProjectList;
	}
}

