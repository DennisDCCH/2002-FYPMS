package Program;

import java.util.List;
import java.util.Scanner;

public class User implements UserInterface {
	
	private String userID;
	private String email;
	private String password;
	private String userName;
	private UserReadFile file;
	
	public User(UserReadFile file)
	{
		this.password = "password";
		this.file = file;
	}
	
	// verify password
	public boolean checkPassword(String password)
	{
		return this.password.equals(password);
	}
	
	// verify domain
	public boolean checkDomain(String userID)
	{
		for (List i: file.getUserInfo())
		{
			if (i.get(0).equals(userID))
			{
				this.userID = (String) i.get(0);
				this.userName = (String) i.get(2);
				this.email = (String) i.get(1);
				return true;
			}
		}
		
		return false;
	}
	// change password
	public String changePassword()
	
	{
		Scanner sc = new Scanner(System.in);
		boolean done = false;
		while (!done)
		{
			System.out.println("Please Enter your New Password");
			String newPassword = sc.next();
			if (newPassword.equals(this.password))
			{
				System.out.println("This password is the same as old password. Please use another password!");
				continue;
			}
			this.password = newPassword;
			done = true;
			System.out.println("Your password have been changed!");
			
		}
		
		return this.password;
	}
	
	public String getUserID()
	{
		return this.userID;
	}
	
	public String getEmail()
	{
		return this.email;
	}
	
	public String getName()
	{
		return this.userName;
	}
	

}