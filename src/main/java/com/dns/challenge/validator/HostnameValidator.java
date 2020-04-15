package com.dns.challenge.validator;

import com.dns.challenge.exceptionhandler.InvalidInputException;

public abstract class HostnameValidator {


	public static void validate(String hostname) throws Exception {
		
		if(!isValidHostname(hostname))
			throw new InvalidInputException("Must have a valid hostname.");
	}
	
	
	private static boolean isValidHostname(String hostname) {
		String pattern = "\\A([a-z0-9]+(-[a-z0-9]+)*\\.)+[a-z]{2,}\\Z";
		return hostname.matches(pattern);
	}



}
