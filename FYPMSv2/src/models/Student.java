package models;

/**
 * This class is a student which is a subclass of the user. Student inherits attributes and methods from the user class.
 * A student is able to access the FYP management system.
 * @author Dennis
 * @version 1.0
 */
public class Student extends User {
	
	/**
	 * This attributes check for if the user have a object currently, thus it takes in a boolean value.
	 * True for having a project.
	 * False for not having a project.
	 */
	private boolean haveProject;
	
	/**
	 * This attributes check for if the user have deregistered from a FYP project before. If the student have
	 * not done so, the value of this attribute will be 0. If the student have deregistered from the FYP project, the value 
	 * will be 1, and thus he will be barred from logging into the system.
	 */
	private int deregisteredFYP;
	
	/**
	 * The project of the student. Project is a object.
	 * A student can only have one project.
	 */
	private Project project;
	
	/**
	 * This constructs a student with a specificed username, email, password and a 0 or 1 integer value to see if the student have
	 * deregistered from FYP before.
	 * The username, email and password will be feed into the super class which is user.
	 * Afterwards, we will attain the project of the student based on his username through the use 
	 * of another class method and put it in the project attribute.
	 * 
	 * Then we will proceed to check if the project attribute is null and set the boolean value of having a object accordingly
	 * 
	 * @param userName the username of the student
	 * @param email the email of the student
	 * @param password the password of the student
	 * @param deregisteredFYP 0 or 1 integer value to determine if the student deregisted from fyp before.
	 */
	public Student(String userName, String email, String password, int deregisteredFYP) {
		super(userName, email, password);
		this.deregisteredFYP = deregisteredFYP;
		project = ProjectList.getStudentProject(userName);
		
		if(project == null)
			haveProject = false;
		else 
			haveProject = true;
	}
	
	/**
	 * This method gets the boolean value of whether student have a project.
	 * True for having a project.
	 * False for not having a project.
	 * @return this boolean value of whether student have project
	 */
	public boolean isHaveProject() {
		return haveProject;
	}

	/**
	 * This method overwrites the existing boolean value of whether the student have a project and changes it 
	 * to whatever is specified
	 * @param haveProject this is student's new boolean value of whether student have a project.
	 * 
	 */
	public void setHaveProject(boolean haveProject) {
		this.haveProject = haveProject;
	}
	
	/**
	 * This method gets the project of the student
	 * @return the student's project 
	 */
	public Project getProject() {
			return project;	
	}

	/**
	 * This methods get the integer value of 0 or 1 of whether the student deregistered from fyp
	 * @return the integer value of 0 or 1 of whether the student deregistered from fyp
	 */
	public int getDeregisteredFYP() {
		return deregisteredFYP;
	}

	/**
	 * This method overwrites the exisiting integer value of whether the student deregistered from fyp before with whatever is 
	 * the new specified value.
	 * @param deregisteredFYP the new integer value of whether the student deregistered from fyp
	 */
	public void setDeregisteredFYP(int deregisteredFYP) {
		this.deregisteredFYP = deregisteredFYP;
	}
	
	/**
	 * This method will print out all the details of the student's project
	 */
	public void printMyProjects() {
		project.printProjectDetails();
	}
}
