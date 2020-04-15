package com.dns.challenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dns.challenge.repository.DnsRecordRepository;


@Service
public class DnsRecordService {
	
	
	@Autowired
	private DnsRecordRepository dnsRecordRepository;
	
	
	public String save() {
		return "SAVE";
	}

	
	public String find() {
		return "FIND";
	}
	
}
