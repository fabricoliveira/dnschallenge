package com.dns.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dns.challenge.model.DnsRecord;

public interface DnsRecordRepository extends JpaRepository<DnsRecord, Long> {

}
