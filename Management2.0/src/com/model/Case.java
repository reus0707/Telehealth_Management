package com.model;

public class Case {
	private int case_id;
	private int doctor_id;
	private int patient_id;
	private int recep_id;
	private String description;
	private String diagnose;
	private String department;//ฟฦสา
	private String date;
	
	private String patientname;
	private String patientsex;
	private String patientage;
	private String doctorname;
	private String doctorsex;
	private String doctorage;
	
	public int getCase_id() {
		return case_id;
	}
	public void setCase_id(int case_id) {
		this.case_id = case_id;
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
	public int getRecep_id() {
		return recep_id;
	}
	public void setRecep_id(int recep_id) {
		this.recep_id = recep_id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDiagnose() {
		return diagnose;
	}
	public void setDiagnose(String diagnose) {
		this.diagnose = diagnose;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPatientname() {
		return patientname;
	}
	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}
	public String getPatientsex() {
		return patientsex;
	}
	public void setPatientsex(String patientsex) {
		this.patientsex = patientsex;
	}
	public String getPatientage() {
		return patientage;
	}
	public void setPatientage(String patientage) {
		this.patientage = patientage;
	}
	public String getDoctorname() {
		return doctorname;
	}
	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}
	public String getDoctorsex() {
		return doctorsex;
	}
	public void setDoctorsex(String doctorsex) {
		this.doctorsex = doctorsex;
	}
	public String getDoctorage() {
		return doctorage;
	}
	public void setDoctorage(String doctorage) {
		this.doctorage = doctorage;
	}
	
	public void set(
			int case_id,
			int doctor_id,
			int patient_id,
			
			String description,
			String diagnose,
			String department,//ฟฦสา
			String date
			
			)
		 {
			this.case_id = case_id;
			this.doctor_id = doctor_id;
			this.patient_id = patient_id;
			
			this.description = description;
			this.diagnose = diagnose;
			this.department = department;
			this.date = date;

		 }
	

}
