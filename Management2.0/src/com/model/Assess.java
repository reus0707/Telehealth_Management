package com.model;

public class Assess {
	private int assess_id;
	private int doctor_id;
	private int patient_id;
	private String doctorname;
	private String patientname;
	private String time;
	private String content;
	
	public int getAssess_id() {
		return assess_id;
	}
	public void setAssess_id(int assess_id) {
		this.assess_id = assess_id;
	}
	public int getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}
	public int getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}
	public String getDoctorname() {
		return doctorname;
	}
	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}
	public String getPatientname() {
		return patientname;
	}
	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public void set(
			int doctor_id,
			int patient_id,
			String doctorname,
			String patientname,
			String time,
			String content)
		 {
			this.doctor_id = doctor_id;
			this.patient_id = patient_id;
			this.doctorname = doctorname;
			this.patientname = patientname;
			this.time = time;
			this.content = content;
		 }
}
