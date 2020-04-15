package com.dns.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dns.challenge.model.DnsRecord;

public interface DnsRecordRepository extends JpaRepository<DnsRecord, Long> {

	
	@Query(value = "SELECT hn.dnsRecordId as id, ip.address as address, COUNT(*) as count "
				 + "FROM hostname hn "
				 + "INNER JOIN ip ip "
			     + "ON hn.dnsRecordId = ip.dnsRecordId "
			     + "WHERE hn.name in ?1 "
			     + "AND hn.dnsRecordId NOT IN (SELECT dnsRecordId FROM hostname hn WHERE hn.name in ?2) "
			     + "GROUP BY hn.dnsRecordId, ip.address "
			     + "HAVING COUNT(*) > ?3", nativeQuery = true)
	Object[][] findAllDnsRecordAndIpByHostnames(List<String> included, List<String> excluded, int counter);
	
	
	
	@Query(value = "SELECT name, count(*) "
				 + "FROM hostname "
				 + "WHERE dnsRecordId in ?1 "
				 + "AND name not in ?2 "
				 + "group by name", nativeQuery = true)
	Object[][] mapHostnamesWithDnsRecordsBySelectedHostnames(List<String> dnsRecordIds, List<String> excluded);

}
