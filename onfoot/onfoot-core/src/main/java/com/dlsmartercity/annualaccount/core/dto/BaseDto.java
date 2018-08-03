package com.dlsmartercity.annualaccount.core.dto;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class BaseDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private int pageIndex;

	private int pageSize;
	
	private String orderBy;
	
	private String conditionFrom;
	
	private String conditionTo;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateFrom;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateTo;
	
	public BaseDto() {
	}
	
	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public String getConditionFrom() {
		return conditionFrom;
	}

	public void setConditionFrom(String conditionFrom) {
		this.conditionFrom = conditionFrom;
	}

	public String getConditionTo() {
		return conditionTo;
	}

	public void setConditionTo(String conditionTo) {
		this.conditionTo = conditionTo;
	}

	public Date getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Date getDateTo() {
		return dateTo;
	}

	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}

}
