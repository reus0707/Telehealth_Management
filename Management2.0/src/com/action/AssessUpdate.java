package com.action;

import java.util.Vector;

import com.model.Assess;
import com.model.User;
import com.sql.MySQL;

public class AssessUpdate {
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
	
	private Vector<Assess> AssessVect;
	public Vector<Assess> getAssessVect() {
		return AssessVect;
	}
	public void setAssessVect(Vector<Assess> assessVect) {
		AssessVect = assessVect;
	}
	
	public String AssessAddJump() {
		MySQL sql=new MySQL();
		user=sql.userInfor(userid);
		sql.close();
		return "success";
	}
	public String AssessAdd() {
		MySQL sql=new MySQL();
		user=sql.userInfor(userid);
		Assess Ass = new Assess();
		Ass.set(doctor_id, patient_id, doctorname, patientname, time, content);
		sql.AssessAdd(Ass);
		sql.close();
		return "success";
	}
	public String AssessDelete(){
		MySQL sql=new MySQL();
		user=sql.userInfor(userid);
		sql.AssessDeleteExecute(assess_id);
		AssessVect=sql.selectAssess(0,"",1);
		sql.close();
		return "success";
	}
}
