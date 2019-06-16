package com.action;

import java.util.Vector;

import com.model.Exam;
import com.model.User;
import com.sql.MySQL;

public class ExamSelectFunction {
	
	private int userid;
	private User user;
	private int page;
	private String Aim;
	
	private Vector<Exam> ExamVect;
	private Exam Ex;
	private int exam_id;
	
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
	public Vector<Exam> getExamVect() {
		return ExamVect;
	}
	public void setExamVect(Vector<Exam> examVect) {
		ExamVect = examVect;
	}
	public Exam getEx() {
		return Ex;
	}
	public void setEx(Exam ex) {
		Ex = ex;
	}
	public int getExam_id() {
		return exam_id;
	}
	public void setExam_id(int exam_id) {
		this.exam_id = exam_id;
	}
	
	public String  ExamVectSelect() {//
		MySQL sql=new MySQL();
		user=sql.userInfor(userid);//userid是从HomeAdmin.jsp中传过来的
		if(user.getType().equals("0") || user.getType().equals("1")) {
			String unit=user.getUnit();
			ExamVect=sql.selectExam(page, unit, 0);
			sql.close();
			return "success";
		}
		else if(user.getType().equals("2")) {
			ExamVect=sql.selectExam(page,"",1);//
			sql.close();
			return "admin";
		}
		return "success";
	}
	public String ExamSelect() {//这个选择是为了修改update信,单个选择,得到
		MySQL sql=new MySQL();
		user=sql.userInfor(userid);
		Ex=sql.selectExamNumber(exam_id);
		sql.close();
		return "success";
	}
	public String ExamQuery() {
		MySQL sql=new MySQL();
		user=sql.userInfor(userid);
		if(user.getType().equals("0") || user.getType().equals("1")) {
			ExamVect=sql.ExamselectAll(Aim,user.getUnit(),0,page);
			sql.close();
			return "success";
		}
		else if(user.getType().equals("2")) {
			ExamVect=sql.ExamselectAll(Aim,"",1,page);
			sql.close();
			return "success";
		}
	    return "error";
	}
	
}
