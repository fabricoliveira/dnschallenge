package com.dns.challenge.model.dto;

public class HostnameResultDTO {

	private String hostname;

	private String numberOfMatchingDnsRecords;

	public HostnameResultDTO(String hostname, String getNumberOfMatchingDnsRecords) {
		this.hostname = hostname;
		this.numberOfMatchingDnsRecords = getNumberOfMatchingDnsRecords;
	}

	public String getHostname() {
		return hostname;
	}

	public String getNumberOfMatchingDnsRecords() {
		return numberOfMatchingDnsRecords;
	}

}
