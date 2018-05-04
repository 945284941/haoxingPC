package com.qlzy.exception;

/**
 * 异常类
 * @author WangHuifeng
 * 2012-12-29 上午11:52:31
 * TODO
 */
public class SystemException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	public SystemException(){
		super();
	}
	public SystemException(String mesg){
		super(mesg);
	}
	public SystemException(String mesg, Throwable rootCause) {
        super(mesg);
        rootCause.printStackTrace();
	}
}
