package com.medical.exception.custom;

public class MyException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer code;
	
	public MyException(){
		super();
        code=500;
    }
    public MyException(String msg){
        super(msg);
        code=500;
    }
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}

}
