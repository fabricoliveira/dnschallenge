package com.dns.challenge.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class DnsRecordResource {

	
	@PostMapping(consumes = "application/json")
	public String save() {
		return "SAVE test";
	}
	
	
	@GetMapping(consumes = "application/json")
	public String find() {
		return "FIND test";
	}
	
	
}
