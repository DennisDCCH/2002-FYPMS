package Program;

public class Coordinator extends Supervisor {

	public Coordinator(UserReadFile file) {
		super(file);
	}
	
	public boolean approveRegister()
	{
		return true;
	}
	
	public boolean approveDeregister()
	{
		return true;
	}
	
	public boolean approveHandOver()
	{
		return true;
	}

}
