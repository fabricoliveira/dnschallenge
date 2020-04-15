package com.dns.challenge.resource;

import java.net.URI;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dns.challenge.model.DnsRecord;
import com.dns.challenge.model.dto.DnsRecordDTO;
import com.dns.challenge.model.dto.ResultDTO;
import com.dns.challenge.model.dto.SearchDTO;
import com.dns.challenge.service.DnsRecordService;

@RestController
@RequestMapping
public class DnsRecordResource {

	
	@Autowired
	private DnsRecordService dnsRecordService;
	
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<DnsRecordDTO> save(@RequestBody DnsRecordDTO dnsRecordDTO, HttpServletResponse response) throws Exception {
		
		DnsRecord dnsRecordStored = dnsRecordService.save(dnsRecordDTO);
		
		dnsRecordDTO.setId(dnsRecordStored.getId());

		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
											 .path("/{id}")	
								   			 .buildAndExpand(dnsRecordStored.getId())
								   			 .toUri();
		response.setHeader("Location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(dnsRecordDTO);
	}
	
	
	@GetMapping(consumes = "application/json")
	public ResponseEntity<ResultDTO> find(@RequestBody SearchDTO searchDTO) throws Exception {
		
		ResultDTO result = dnsRecordService.find(searchDTO);
		
		if(result != null) {
			
			return ResponseEntity.ok(result);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	
}
