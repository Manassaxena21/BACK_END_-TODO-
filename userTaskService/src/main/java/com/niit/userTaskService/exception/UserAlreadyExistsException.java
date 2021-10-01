package com.niit.userTaskService.exception;

import java.util.Arrays;

public class UserAlreadyExistsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "TaskAlreadyExistsException [getMessage()=" + getMessage() + ", getLocalizedMessage()="
				+ getLocalizedMessage() + ", getCause()=" + getCause() + ", toString()=" + super.toString()
				+ ", fillInStackTrace()=" + fillInStackTrace() + ", getStackTrace()=" + Arrays.toString(getStackTrace())
				+ ", getSuppressed()=" + Arrays.toString(getSuppressed()) + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}
	
	

}
