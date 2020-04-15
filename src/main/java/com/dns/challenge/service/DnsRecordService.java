package com.dns.challenge.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dns.challenge.model.DnsRecord;
import com.dns.challenge.model.dto.DnsRecordDTO;
import com.dns.challenge.model.dto.DnsRecordsResultDTO;
import com.dns.challenge.model.dto.HostnameResultDTO;
import com.dns.challenge.model.dto.ResultDTO;
import com.dns.challenge.model.dto.SearchDTO;
import com.dns.challenge.repository.DnsRecordRepository;
import com.dns.challenge.validator.HostnameValidator;


@Service
public class DnsRecordService {
	
	
	@Autowired
	private DnsRecordRepository dnsRecordRepository;
	
	
	public DnsRecord save(DnsRecordDTO dnsRecordDTO) throws Exception {
		DnsRecord dnsRecord = new DnsRecord().dnsRecordBuilder(dnsRecordDTO);

		dnsRecordRepository.save(dnsRecord);

		return dnsRecord;
	}

	
	public ResultDTO find(SearchDTO search) throws Exception {
		ResultDTO result = new ResultDTO();
		List<String> dnsRecordIds = new ArrayList<>();
		

		for(String hostname : search.getIncluded()) 
			HostnameValidator.validate(hostname);
		
		for(String hostname : search.getExcluded()) 
			HostnameValidator.validate(hostname);
		
		
		for(Object[] o : dnsRecordRepository.findAllDnsRecordAndIpByHostnames(search.getIncluded(), search.getExcluded(), search.getIncluded().size() - 1)) {
			result.getMatchingDnsRecords().add(new DnsRecordsResultDTO(o[0].toString(), o[1].toString()));
			dnsRecordIds.add(o[0].toString());
		}
		
		result.setTotalNumberOfMatchingDnsRecords(result.getMatchingDnsRecords().size());
		
		if(result.getMatchingDnsRecords().isEmpty()) 
			return null;
		
		for(Object[] o : dnsRecordRepository.mapHostnamesWithDnsRecordsBySelectedHostnames(dnsRecordIds, search.getExcluded())) {
			result.getHostnamesAssociatedWithMatchingDnsRecords().add(new HostnameResultDTO(o[0].toString(), o[1].toString()));
		}
		
		return result; 
	}
	
	
}
