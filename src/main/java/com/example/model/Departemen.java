package com.example.model;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Departemen {
	private long id;
    private String namaDepartemen;
    private List<Karyawan> karyawans;
    public Departemen() {
		// TODO Auto-generated constructor stub
	}
	public Departemen(long id, String namaDepartemen, List<Karyawan> karyawans) {
		this.id = id;
		this.namaDepartemen = namaDepartemen;
		this.karyawans = karyawans;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNamaDepartemen() {
		return namaDepartemen;
	}
	public void setNamaDepartemen(String namaDepartemen) {
		this.namaDepartemen = namaDepartemen;
	}
	public List<Karyawan> getKaryawans() {
		return karyawans;
	}
	public void setKaryawans(List<Karyawan> karyawans) {
		this.karyawans = karyawans;
	}
	
	
    
}
