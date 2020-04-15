package com.dns.challenge.validator;

import com.dns.challenge.exceptionhandler.InvalidInputException;

public abstract class IpValidator {

	public static void validate(String ipAddress) throws Exception {

		if (!isValidIpAddress(ipAddress))
			throw new InvalidInputException("Must have a valid Ip Address.");
	}

	private static boolean isValidIpAddress(String ipAddress) {
		String pattern = "^((0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)\\.){3}(0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)$";
		return ipAddress.matches(pattern);
	}

}