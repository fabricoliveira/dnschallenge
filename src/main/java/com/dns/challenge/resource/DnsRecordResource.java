package com.dns.challenge.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dns.challenge.service.DnsRecordService;

@RestController
@RequestMapping
public class DnsRecordResource {

	
	@Autowired
	private DnsRecordService dnsRecordService;
	
	
	@PostMapping(consumes = "application/json")
	public String save() {
		return dnsRecordService.save();
	}
	
	
	@GetMapping(consumes = "application/json")
	public String find() {
		return dnsRecordService.find();
	}
	
	
}
