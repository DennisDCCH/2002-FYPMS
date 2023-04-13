package models;

/**
 * This class is a coordinator which is a subclass of the supervisor. Coordinator inherits attributes and methods from the supervisor class.
 * A coordinator is able to access the FYP management system.
 * @author Dennis
 * @version 1.0
 */
public class Coordinator extends Supervisor{
	
	/**
	 * This contructs a coordinator with a specified username, email and password.
	 * The username, email and password will be feed into the super class which is supervisor.
	 * @param userName the username of the coordinator
	 * @param email the email of the coordinator
	 * @param password the password of the coordinator
	 */
	public Coordinator(String userName, String email, String password) {
		super(userName, email, password);
	}
}
