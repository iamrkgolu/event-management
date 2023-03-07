package com.eventmanagement.controller.exception;

public class AlreadyCheckedInException extends RuntimeException {

	public AlreadyCheckedInException(String string) {
		super(string);
	}

}
