package com.dns.challenge.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.dns.challenge.model.dto.DnsRecordDTO;
import com.dns.challenge.validator.HostnameValidator;
import com.dns.challenge.validator.IpValidator;

@Entity
@Table(name = "dnsrecord")
public class DnsRecord implements Serializable {

	
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "dnsRecord", cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "ipId")
	private Ip ip;

	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "dnsRecord", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Hostname> hostnames = new ArrayList<>();

	
	public Long getId() {
		return id;
	}

	
	public void setId(Long id) {
		this.id = id;
	}

	
	public Ip getIp() {
		return ip;
	}

	
	public void setIp(Ip ip) {
		this.ip = ip;
	}

	
	public List<Hostname> getHostnames() {
		return hostnames;
	}

	
	public void setHostnames(List<Hostname> hostnames) {
		this.hostnames = hostnames;
	}
	
	
	@Transient
	public DnsRecord dnsRecordBuilder(DnsRecordDTO dnsRecordDTO) throws Exception {
		IpValidator.validate(dnsRecordDTO.getIp());

		DnsRecord dnsRecord = new DnsRecord();

		dnsRecord.setIp(new Ip(dnsRecordDTO.getIp(), dnsRecord));

		for (String name : dnsRecordDTO.getHostnames()) {
			HostnameValidator.validate(name);
			dnsRecord.getHostnames().add(new Hostname(name, dnsRecord));
		}

		return dnsRecord;
	}

}
