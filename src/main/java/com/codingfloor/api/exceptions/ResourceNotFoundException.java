package com.codingfloor.api.exceptions;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException {
	
	String resourceName;
	String resourceFieldName;
	long value;

	public ResourceNotFoundException(String resourceName, String resourceFieldName, long value) {
		super(String.format("%s not found with %s", resourceName, value));
		this.resourceName = resourceName;
		this.resourceFieldName = resourceFieldName;
		this.value = value;
	}

}
