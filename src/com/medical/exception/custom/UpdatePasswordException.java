package com.medical.exception.custom;

public class UpdatePasswordException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public UpdatePasswordException(){
        super();
    }
    public UpdatePasswordException(String msg){
        super(msg);
    }

}
