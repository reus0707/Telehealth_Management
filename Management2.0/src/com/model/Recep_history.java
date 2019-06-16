package com.model;

public class Recep_history {
	private int recep_id;
	private int patient_id;
	private int doctor_id;
	private String date;
	private String starttine;
	private String endtime;
	private String department;
	
	public int getRecep_id() {
		return recep_id;
	}
	public void setRecep_id(int recep_id) {
		this.recep_id = recep_id;
	}
	public int getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}
	public int getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStarttine() {
		return starttine;
	}
	public void setStarttine(String starttine) {
		this.starttine = starttine;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
}
