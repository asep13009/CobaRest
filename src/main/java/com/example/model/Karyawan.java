package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Karyawan {
    private long id;
	private String namaKaryawan;
	private Departemen departemen;
	public Karyawan() {
		// TODO Auto-generated constructor stub
	}
    public Karyawan(long id, String namaKaryawan, Departemen departemen) {
		this.id = id;
		this.namaKaryawan = namaKaryawan;
		this.departemen = departemen;
	}
    public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNamaKaryawan() {
		return namaKaryawan;
	}
	public void setNamaKaryawan(String namaKaryawan) {
		this.namaKaryawan = namaKaryawan;
	}
	public Departemen getDepartemen() {
		return departemen;
	}
	public void setDepartemen(Departemen departemen) {
		this.departemen = departemen;
	}
}
