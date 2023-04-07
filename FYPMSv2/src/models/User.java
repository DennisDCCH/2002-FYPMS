package models;

public class User {
	protected String userName;
	protected String email;
	protected String userID;
	protected String password;
	
	//Constructor
	public User(String userName, String email, String password) {
		this.userName = userName;
		this.email = email;
		String[] parts = email.split("@");
		userID = parts[0];
		this.password = password;
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
}
