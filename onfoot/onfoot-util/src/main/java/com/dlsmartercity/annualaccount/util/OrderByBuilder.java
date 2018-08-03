package com.dlsmartercity.annualaccount.util;

import java.util.ArrayList;
import java.util.List;

public class OrderByBuilder {
	
	private List<String> orderByFields = new ArrayList<>();
	
	public OrderByBuilder orderBy(String orderByField) {
		if(orderByFields.isEmpty()) {
			this.orderByFields.add(orderByField);
		} else {
			this.orderByFields.add("," + orderByField);
		}
		return this;
	}
	
	public OrderByBuilder asc() {
		orderByFields.add(" asc");
		return this;
	}
	
	public OrderByBuilder desc() {
		orderByFields.add(" desc");
		return this;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for(String orderByField : orderByFields) {
			builder.append(orderByField);
		}
		return builder.toString();
	}
	
}
