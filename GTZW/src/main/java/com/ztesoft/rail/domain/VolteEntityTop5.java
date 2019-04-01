package com.ztesoft.rail.domain;

import java.io.Serializable;
import java.util.List;

public class VolteEntityTop5 implements Serializable {
	private String firstQuotaName;
	private String secondQuotaName;
	private List<?> quotaData;

	public VolteEntityTop5() {
		super();
	}

	public String getFirstQuotaName() {
		return firstQuotaName;
	}

	public void setFirstQuotaName(String firstQuotaName) {
		this.firstQuotaName = firstQuotaName;
	}

	public String getSecondQuotaName() {
		return secondQuotaName;
	}

	public void setSecondQuotaName(String secondQuotaName) {
		this.secondQuotaName = secondQuotaName;
	}

	public List<?> getQuotaData() {
		return quotaData;
	}

	public void setQuotaData(List<?> quotaData) {
		this.quotaData = quotaData;
	}

	

}
