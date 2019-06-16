package com.model;

public class Exam {
	private int exam_id;
	private int patient_id;
	private String time;
	private String height;
	private String weight;
	private String pulserate;
	private String bloodpressure;
	private String spo;//ÑªÑõ
	private String temperature;
	private String bwh;//ÈýÎ§
	private String result;
	private String patientname;
	private String sex;
	private String age;
	
	public int getExam_id() {
		return exam_id;
	}
	public void setExam_id(int exam_id) {
		this.exam_id = exam_id;
	}
	public int getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getPulserate() {
		return pulserate;
	}
	public void setPulserate(String pulserate) {
		this.pulserate = pulserate;
	}
	public String getBloodpressure() {
		return bloodpressure;
	}
	public void setBloodpressure(String bloodpressure) {
		this.bloodpressure = bloodpressure;
	}
	public String getSpo() {
		return spo;
	}
	public void setSpo(String spo) {
		this.spo = spo;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public String getBwh() {
		return bwh;
	}
	public void setBwh(String bwh) {
		this.bwh = bwh;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getPatientname() {
		return patientname;
	}
	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	public void set(
			int exam_id,

			String time,
			String height,
			String weight,
			String pulserate,
			String bloodpressure,
			String spo,
			String temperature,
			String bwh,

			String patientname,
			String sex,
			String age)
		 {
			this.exam_id = exam_id;
			this.time = time;
			this.height = height;
			this.weight = weight;
			this.pulserate = pulserate;
			this.bloodpressure = bloodpressure;
			this.spo = spo;
			this.temperature = temperature;
			this.bwh = bwh;
			this.patientname = patientname;
			this.sex = sex;
			this.age = age;
		 }
	
}
