package Program;

public class Supervisor extends User{

	private int requestNum;
	
	public Supervisor(UserReadFile file) {
		super(file);
		this.requestNum = 0;
	}
	
	public boolean approveChangeTitle()
	{
		return true;
	}
	
	public int getRequestNum()
	{
		return this.requestNum;
	}
	
	public int addRequestNum()
	{
		return this.requestNum++;
	}
	
	public int subtractRequestNum()
	{
		return this.requestNum--;
	}

}
