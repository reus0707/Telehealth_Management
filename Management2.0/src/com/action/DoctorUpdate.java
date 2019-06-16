package com.action;

import java.sql.Date;

import com.sql.MySQL;
import java.util.Random;
import java.util.Vector;
import com.model.*;
import java.text.SimpleDateFormat;

public class DoctorUpdate {
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
	
	private Vector<Doctor> DoctorVect;
	public Vector<Doctor> getDoctorVect() {
		return DoctorVect;
	}
	public void setDoctorVect(Vector<Doctor> doctorVect) {
		DoctorVect = doctorVect;
	}

	private int doctor_id;
	private String username;
	private String password;
	private String real_id;
	private String real_name;
	private String sex;
	private String age;
	private String safe_question;
	private String std_answer;
	private String clinic;//科所名称
	private String department;//科室 如骨科内科牙科
	private String address;
	private String email;
	private String phone;
	private String insuranceget;
	private String birthday;
	private String introduction;
	private String licence1;
	private String licence2;
	private String picture;
	private String verificationcode;
	private int sta;
	
	public int getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getReal_id() {
		return real_id;
	}
	public void setReal_id(String real_id) {
		this.real_id = real_id;
	}
	public String getReal_name() {
		return real_name;
	}
	public void setReal_name(String real_name) {
		this.real_name = real_name;
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
	public String getSafe_question() {
		return safe_question;
	}
	public void setSafe_question(String safe_question) {
		this.safe_question = safe_question;
	}
	public String getStd_answer() {
		return std_answer;
	}
	public void setStd_answer(String std_answer) {
		this.std_answer = std_answer;
	}
	public String getClinic() {
		return clinic;
	}
	public void setClinic(String clinic) {
		this.clinic = clinic;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getInsuranceget() {
		return insuranceget;
	}
	public void setInsuranceget(String insuranceget) {
		this.insuranceget = insuranceget;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getLicence1() {
		return licence1;
	}
	public void setLicence1(String licence1) {
		this.licence1 = licence1;
	}
	public String getLicence2() {
		return licence2;
	}
	public void setLicence2(String licence2) {
		this.licence2 = licence2;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getVerificationcode() {
		return verificationcode;
	}
	public void setVerificationcode(String verificationcode) {
		this.verificationcode = verificationcode;
	}
	public int getSta() {
		return sta;
	}
	public void setSta(int sta) {
		this.sta = sta;
	}
	
	public String execute() {
		MySQL sql=new MySQL();
		user=sql.userInfor(userid);
		sql.DoctorUpdate(doctor_id, username, password, real_id, real_name, sex, age, safe_question, std_answer, clinic, department, address, email, phone, insuranceget, birthday, introduction, licence1, licence2, picture, verificationcode, sta);
		sql.close();
		return "success";
	}
	public String DoctorVerify(){//审核医生信息
		MySQL sql=new MySQL();
		user=sql.userInfor(userid);
		sql.DoctorUpdateSta(doctor_id);
		DoctorVect=sql.selectDoctor(0,"",1);//doctorvect 为了返回doctor大表界面
		sql.close();
		return "success";
	}
	public String ExamAddJump() {//没写呢！！！！！！！！！！！！！！！！！！！！！！！！
		MySQL sql=new MySQL();
		user=sql.userInfor(userid);
		sql.close();
		return "success";
	}
	public String ExamAdd() {//没写呢！！！！！！！！！！！！！！！！！！！！！！！！
		MySQL sql=new MySQL();
		user=sql.userInfor(userid);
		Exam Ex = new Exam();
		//Ex.set(exam_id, time, height, weight, pulserate, bloodpressure, spo, temperature, bwh, patientname, sex, age);
		sql.ExamAdd(Ex);
		sql.close();
		return "success";
	}
	public String DoctorDelete(){
		MySQL sql=new MySQL();
		user=sql.userInfor(userid);
		sql.DoctorDeleteExecute(doctor_id);
		sql.close();
		return "success";
	}
	
}
