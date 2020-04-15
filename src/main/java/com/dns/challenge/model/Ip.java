package com.dns.challenge.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "ip")
public class Ip implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@NotNull
	@Size(min = 7, max = 15)
	private String address;
	
	
	public Ip(String address, DnsRecord dnsRecord) {
		this.address = address;
		this.dnsRecord = dnsRecord;
	}


	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dnsRecordId", referencedColumnName = "id")
	private DnsRecord dnsRecord;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public DnsRecord getDnsRecord() {
		return dnsRecord;
	}


	public void setDnsRecord(DnsRecord dnsRecord) {
		this.dnsRecord = dnsRecord;
	}
	
}
