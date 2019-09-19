package domain;

public class States {
	private machState stateT;
	private String message;
	private String sName;
	
	
	//CONSTRUCTORS
	
	//Primary Constructor
	public States(String message, String name, machState stateT)
	{
		this.message = message;
		this.sName = name;
		this.stateT = stateT;
	}
	
	public String getMessage()
	{
		return message;
	}
	
	public void setMessage(String message)
	{
		this.message = message;
	}
	
	public String getName()
	{
		return sName;
	}
	
	public void setName(String name)
	{
		this.sName = name;
	}
	
	public machState getStateT()
	{
		return stateT;
	}
	
	public void setStateT(machState stateT)
	{
		this.stateT = stateT;
	}
	public String toString()
	{
		return new String(getName() + " : " +message + " : " +stateT.toString());
	}
	
}


