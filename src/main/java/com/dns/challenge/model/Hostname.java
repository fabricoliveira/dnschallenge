package com.dns.challenge.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "hostname")
public class Hostname implements Serializable {

	
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@NotNull
	@Size(min = 3, max = 100)
	private String name;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dnsRecordId", referencedColumnName = "id")
	private DnsRecord dnsRecord;


	public Hostname(String name, DnsRecord dnsRecord) {
		this.name = name;
		this.dnsRecord = dnsRecord;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public DnsRecord getDnsRecord() {
		return dnsRecord;
	}


	public void setDnsRecord(DnsRecord dnsRecord) {
		this.dnsRecord = dnsRecord;
	}
	
}
