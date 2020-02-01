package com.auto.methods;

public class TestCaseFailed extends Exception 
{

	private static final long serialVersionUID = 1L;
	String message=null;
	public TestCaseFailed() 
	{
		super();
	}
	 
	public TestCaseFailed(String message) 
	{
	    super(message);
	    this.message = message;
	}
	 
}
