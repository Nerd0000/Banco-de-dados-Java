package com.Alan.Senai.services.exceptions;

public class ObjectNotFoundException extends RuntimeException {// puxa a lib que trata o erro
	private static final long serialVersionUID = 1L;// serial

	// recebe a msg
	public ObjectNotFoundException(String msg) {
		super(msg);
	}

	// recebe a msg e a causa
	public ObjectNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
