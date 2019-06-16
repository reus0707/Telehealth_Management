package com.action;

import java.sql.Date;

import com.sql.MySQL;
import java.util.Random;
import java.util.Vector;
import com.model.*;
import java.text.SimpleDateFormat;

public class QuestionUpdate {
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
	
	private int question_id;
	private String question_pre;
	private String department;
	private String typedisease;
	
	
	public int getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}
	public String getQuestion_pre() {
		return question_pre;
	}
	public void setQuestion_pre(String question_pre) {
		this.question_pre = question_pre;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getTypedisease() {
		return typedisease;
	}
	public void setTypedisease(String typedisease) {
		this.typedisease = typedisease;
	}
	
	private Vector<Department_question> QuestionVect;
	public Vector<Department_question> getQuestionVect() {
		return QuestionVect;
	}
	public void setQuestionVect(Vector<Department_question> questionVect) {
		QuestionVect = questionVect;
	}
	
	public String QuestionAddJump() {
		MySQL sql=new MySQL();
		user=sql.userInfor(userid);
		sql.close();
		return "success";
	}
	public String QuestionAdd() {
		MySQL sql=new MySQL();
		user=sql.userInfor(userid);
		Department_question Ques = new Department_question();
		Ques.set(question_pre, typedisease);
		sql.QuestionAdd(Ques);
		sql.close();
		return "success";
	}
	public String QuestionDelete(){
		MySQL sql=new MySQL();
		user=sql.userInfor(userid);
		sql.QuestionDeleteExecute(question_id);
		QuestionVect=sql.selectQuestion(0,"",1);
		sql.close();
		return "success";
	}
	
	
}
