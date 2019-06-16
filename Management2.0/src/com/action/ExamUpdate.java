package com.action;

import java.sql.Date;
import com.model.User;
import com.sql.MySQL;
import java.util.Random;
import java.util.Vector;
import com.model.*;
import java.text.SimpleDateFormat;

public class ExamUpdate {
	private int userid;
	private User user;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
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

	public String execute() {
		MySQL sql=new MySQL();
		user=sql.userInfor(userid);
		sql.ExamUpdate(exam_id, patient_id, patientname, time, height, weight, pulserate, bloodpressure, spo, temperature, bwh);
		sql.close();
		return "success";
	}
	public String ExamAddJump() {
		MySQL sql=new MySQL();
		user=sql.userInfor(userid);
		sql.close();
		return "success";
	}
	public String ExamAdd() {
		MySQL sql=new MySQL();
		user=sql.userInfor(userid);
		Exam Ex = new Exam();
		Ex.set(exam_id, time, height, weight, pulserate, bloodpressure, spo, temperature, bwh, patientname, sex, age);
		sql.ExamAdd(Ex);
		sql.close();
		return "success";
	}
	public String ExamDelete(){
		MySQL sql=new MySQL();
		user=sql.userInfor(userid);
		sql.ExamDeleteExecute(exam_id);
		sql.close();
		return "success";
	}
	
}
