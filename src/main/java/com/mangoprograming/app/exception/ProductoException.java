package com.mangoprograming.app.exception;

public class ProductoException extends RuntimeException{


	public ProductoException(String message) {
		super(message);
	}

	public ProductoException(String message, Throwable cause) {
		super(message, cause);
	}


}
