package models;

public class User {
	protected String userName;
	protected String email;
	protected String userID;
	
	//Constructor
	public User(String userName, String email) {
		this.userName = userName;
		this.email = email;
		String[] parts = email.split("@");
		userID = parts[0];
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
}
