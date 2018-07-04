package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Quote {
	private String type;
	private Value value;
	
	public Quote() {
		// TODO Auto-generated constructor stub
	}

	public Quote(String type, Value value) {
		super();
		this.type = type;
		this.value = value;
	}


	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Value getValue() {
		return value;
	}
	public void setValue(Value value) {
		this.value = value;
	}

}
