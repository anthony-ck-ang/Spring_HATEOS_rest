package com.anthonyang.exception;

public class TeamNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -1226439803994500725L;

	public TeamNotFoundException(String msg){
		super(msg);
	}
	
}