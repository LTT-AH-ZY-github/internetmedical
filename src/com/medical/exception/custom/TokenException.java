package com.medical.exception.custom;

public class TokenException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public TokenException(){
        super();
    }
    public TokenException(String msg){
        super(msg);
    }

}
