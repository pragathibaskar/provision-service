package com.cg.provisionService.domain;

import java.util.List;

public class Customresponse {

	private List<Provision> provision;

	private int totalElements;

	public List<Provision> getProvision() {
		return provision;
	}

	public void setProvision(List<Provision> provision) {
		this.provision = provision;
	}

	public int getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(int totalElements) {
		this.totalElements = totalElements;
	}

}
