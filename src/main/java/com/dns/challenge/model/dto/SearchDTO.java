package com.dns.challenge.model.dto;

import java.util.ArrayList;
import java.util.List;

public class SearchDTO {

	private List<String> included = new ArrayList<>();

	private List<String> excluded = new ArrayList<>();

	private int page;

	public List<String> getIncluded() {
		return included;
	}

	public void setIncluded(List<String> included) {
		this.included = included;
	}

	public List<String> getExcluded() {
		return excluded;
	}

	public void setExcluded(List<String> excluded) {
		this.excluded = excluded;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

}
