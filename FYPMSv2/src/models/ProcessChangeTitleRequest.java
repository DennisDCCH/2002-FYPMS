package models;
/**
 * This class is one that does the necessary steps to update all the relevant details when a change title request is 
 * proccessed. 
 * @author Dennis Chen
 * @version 1.0
 */
public class ProcessChangeTitleRequest {

	/**
	 * This method takes the specified project id to get back the project object from another class method. With this
	 * project object, it will now update the new title into it.
	 * @param projectID is the project id of the project that requires processing.
	 * @param additionalInfo is the new project title of the porject.
	 */
	public static void manageRequest(int projectID, String additionalInfo) {
		
		// Set new project title
		ProjectList.getSpecificProject(projectID).setProjectTitle(additionalInfo);
		
	}
}
