package com.medical.exception.custom;

public class UserLoginException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public UserLoginException(){
        super();
    }
    public UserLoginException(String msg){
        super(msg);
    }

}
