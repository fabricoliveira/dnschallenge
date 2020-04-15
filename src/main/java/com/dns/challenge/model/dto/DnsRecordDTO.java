package com.dns.challenge.model.dto;

import java.util.ArrayList;
import java.util.List;

public class DnsRecordDTO {

	private Long id;

	private String ip;

	private List<String> hostnames = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public List<String> getHostnames() {
		return hostnames;
	}

	public void setHostnames(List<String> hostnames) {
		this.hostnames = hostnames;
	}

}
