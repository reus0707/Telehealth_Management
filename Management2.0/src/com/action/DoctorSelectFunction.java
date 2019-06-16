package com.action;

import java.util.Vector;

import com.model.Doctor;
import com.model.User;
import com.sql.MySQL;


public class DoctorSelectFunction {

	private int userid;
	private User user;
	private int page;
	private String Aim;
	
	private Vector<Doctor> DoctorVect;
	private Doctor Doct;
	private int doctor_id;
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
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String getAim() {
		return Aim;
	}
	public void setAim(String aim) {
		Aim = aim;
	}
	public Vector<Doctor> getDoctorVect() {
		return DoctorVect;
	}
	public void setDoctorVect(Vector<Doctor> doctorVect) {
		DoctorVect = doctorVect;
	}
	public Doctor getDoct() {
		return Doct;
	}
	public void setDoct(Doctor doct) {
		Doct = doct;
	}
	public int getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}
	
	public String  DoctorVectSelect() {//
		MySQL sql=new MySQL();
		user=sql.userInfor(userid);//userid是从HomeAdmin.jsp中传过来的
		if(user.getType().equals("0") || user.getType().equals("1")) {
			String unit=user.getUnit();
			DoctorVect=sql.selectDoctor(page, unit, 0);
			sql.close();
			return "success";
		}
		else if(user.getType().equals("2")) {
			DoctorVect=sql.selectDoctor(page,"",1);//
			sql.close();
			return "admin";
		}
		return "success";
	}
	public String DoctorSelect() {//这个选择是为了修改update信,单个选择,得到
		MySQL sql=new MySQL();
		user=sql.userInfor(userid);
		Doct=sql.selectDoctorNumber(doctor_id);
		sql.close();
		return "success";
	}
	public String DoctorQuery() {
		MySQL sql=new MySQL();
		user=sql.userInfor(userid);
		if(user.getType().equals("0") || user.getType().equals("1")) {
			DoctorVect=sql.DoctorselectAll(Aim,user.getUnit(),0,page);
			sql.close();
			return "success";
		}
		else if(user.getType().equals("2")) {
			DoctorVect=sql.DoctorselectAll(Aim,"",1,page);
			sql.close();
			return "success";
		}
	    return "error";
	}
	
}
