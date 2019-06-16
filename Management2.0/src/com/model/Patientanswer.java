package com.model;

public class Patientanswer {
	private int patientanswer_id;
	private int question_id;
	private int patient_id;
	private String answer_content;
	private String time;
	private int sta;
	private String question_content;//其实从这往下不用计，但我就是要计
	private String typedisease;//病种类型
	private String patientname;
	private String department;
	private int recep_id;//注意这里是int类型!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	
	public int getPatientanswer_id() {
		return patientanswer_id;
	}
	public void setPatientanswer_id(int patientanswer_id) {
		this.patientanswer_id = patientanswer_id;
	}
	public int getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}
	public int getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}
	public String getAnswer_content() {
		return answer_content;
	}
	public void setAnswer_content(String answer_content) {
		this.answer_content = answer_content;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	public int getSta() {
		return sta;
	}
	public void setSta(int sta) {
		this.sta = sta;
	}
	
	public String getQuestion_content() {
		return question_content;
	}
	public void setQuestion_content(String question_content) {
		this.question_content = question_content;
	}
	public String getTypedisease() {
		return typedisease;
	}
	public void setTypedisease(String typedisease) {
		this.typedisease = typedisease;
	}
	public String getPatientname() {
		return patientname;
	}
	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getRecep_id() {
		return recep_id;
	}
	public void setRecep_id(int recep_id) {
		this.recep_id = recep_id;
	}
	
	public void setByTypedisease(

			int patient_id,
			String time

			){
		this.patient_id=patient_id;
		this.time=time;

	}
	public void set(
			int patientanswer_id,
			int question_id,
			int patient_id,
			String answer_content,
			String time,
			String question_content,//其实从这往下不用计，但我就是要计
			String typedisease,//病种类型
			String patientname,
			String department,
			int recep_id){
		this.patient_id=patient_id;
		this.time=time;
		
		this.patientanswer_id=patientanswer_id;
		this.question_id=question_id;
		this.answer_content=answer_content;
		this.question_content=question_content;
		this.typedisease=typedisease;
		this.patientname=patientname;
		this.department=department;
		this.recep_id=recep_id;
	}
	
}
