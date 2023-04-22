package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND) //404

//Whenever resource does not exist in DB then we can throw this exception from the API Layer
public class ResourceNotFoundException extends RuntimeException{
//Runtime Exception Internally implements Serializable Interface
//Serializable Interface is used to serialize/deserialize class instances
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(String message)
	{
		super(message); //calling super class implementation
	}

	
}
