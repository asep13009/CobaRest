package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Greeting {
	private final long id;
	private final String content;
	private final String isi;
	
	public Greeting(long id, String content,String isi) {
		this.id=id;
		this.content=content;
		this.isi=isi;
	}
	public long getId() {
		return id;
	}
	public String getContent() {
		return content;
	}
	public String getisi() {
		return isi;
	}
}
