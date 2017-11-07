package com.medical.exception.custom;

public class MsgErrorException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public MsgErrorException(){
        super();
    }
    public MsgErrorException(String msg){
        super(msg);
    }

}
