package com.example.springbootdemoapp02.controller;

import java.util.function.Supplier;

public class ResourceNotFoundException extends Exception {

	public ResourceNotFoundException(String s) {
		super(s);
	}

}
