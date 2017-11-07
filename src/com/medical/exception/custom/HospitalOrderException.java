package com.medical.exception.custom;

public class HospitalOrderException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public HospitalOrderException(){
        super();
    }
    public HospitalOrderException(String msg){
        super(msg);
    }

}
