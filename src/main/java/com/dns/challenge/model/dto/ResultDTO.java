package com.dns.challenge.model.dto;

import java.util.ArrayList;
import java.util.List;

public class ResultDTO {

	private int totalNumberOfMatchingDnsRecords;

	private List<DnsRecordsResultDTO> matchingDnsRecords = new ArrayList<>();

	private List<HostnameResultDTO> hostnamesAssociatedWithMatchingDnsRecords = new ArrayList<>();

	public int getTotalNumberOfMatchingDnsRecords() {
		return totalNumberOfMatchingDnsRecords;
	}

	public void setTotalNumberOfMatchingDnsRecords(int totalNumberOfMatchingDnsRecords) {
		this.totalNumberOfMatchingDnsRecords = totalNumberOfMatchingDnsRecords;
	}

	public List<DnsRecordsResultDTO> getMatchingDnsRecords() {
		return matchingDnsRecords;
	}

	public void setMatchingDnsRecords(List<DnsRecordsResultDTO> matchingDnsRecords) {
		this.matchingDnsRecords = matchingDnsRecords;
	}

	public List<HostnameResultDTO> getHostnamesAssociatedWithMatchingDnsRecords() {
		return hostnamesAssociatedWithMatchingDnsRecords;
	}

	public void setHostnamesAssociatedWithMatchingDnsRecords(List<HostnameResultDTO> hostnamesAssociatedWithMatchingDnsRecords) {
		this.hostnamesAssociatedWithMatchingDnsRecords = hostnamesAssociatedWithMatchingDnsRecords;
	}

}
