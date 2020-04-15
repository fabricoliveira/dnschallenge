package com.dns.challenge.model.dto;

public class DnsRecordsResultDTO {

	private String id;

	private String ip;

	public DnsRecordsResultDTO(String id, String ip) {
		this.id = id;
		this.ip = ip;
	}

	public String getId() {
		return id;
	}

	public String getIp() {
		return ip;
	}

}
