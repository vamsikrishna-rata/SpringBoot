package com.example.demo.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String resourcename;

	private String fieldname;

	private Object fieldvalue;

	public ResourceNotFoundException(String resourcename, String fieldname, Object fieldvalue) {
		super(String.format("%s is not found with %s:'%s'", resourcename, fieldname, fieldvalue));
		this.resourcename = resourcename;
		this.fieldname = fieldname;
		this.fieldvalue = fieldvalue;
	}

	public String getResourcename() {
		return resourcename;
	}

	public String getFieldname() {
		return fieldname;
	}

	public Object getFieldvalue() {
		return fieldvalue;
	 }

}
