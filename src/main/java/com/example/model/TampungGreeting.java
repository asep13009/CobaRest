package com.example.model;


public class TampungGreeting {
	private  long id;
	private  String content;
	private  String isi;
	public TampungGreeting() {
		// TODO Auto-generated constructor stub
	}
	public TampungGreeting(long id, String content,String isi) {
		this.id=id;
		this.content=content;
		this.isi=isi;
	}
	
	public void setId(long id) {
		this.id=id;
	}
	public void setContent(String content) {
		this.content=content;
	}
	public void setIsi(String isi) {
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
