package com.action;

import java.util.Vector;
import com.model.Department_question;
import com.model.User;
import com.sql.MySQL;

public class QuestionSelectFunction {

	private int userid;
	private User user;
	private int page;
	private String Aim;
	
	private Vector<Department_question> QuestionVect;
	private Department_question Ques;
	private int question_id;
	
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
	public Vector<Department_question> getQuestionVect() {
		return QuestionVect;
	}
	public void setQuestionVect(Vector<Department_question> questionVect) {
		QuestionVect = questionVect;
	}
	public Department_question getQues() {
		return Ques;
	}
	public void setQues(Department_question ques) {
		Ques = ques;
	}
	public int getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}
	
	public String  QuestionVectSelect() {//
		MySQL sql=new MySQL();
		user=sql.userInfor(userid);//userid是从HomeAdmin.jsp中传过来的
		if(user.getType().equals("0") || user.getType().equals("1")) {
			String unit=user.getUnit();
			QuestionVect=sql.selectQuestionVect(page, unit, 0);
			sql.close();
			return "success";
		}
		else if(user.getType().equals("2")) {
			QuestionVect=sql.selectQuestionVect(page,"",1);//
			sql.close();
			return "admin";
		}
		return "success";
	}
	public String QuestionQuery() {
		MySQL sql=new MySQL();
		user=sql.userInfor(userid);
		if(user.getType().equals("0") || user.getType().equals("1")) {
			QuestionVect=sql.QuestionSelectAll(Aim,user.getUnit(),0,page);
			sql.close();
			return "success";
		}
		else if(user.getType().equals("2")) {
			QuestionVect=sql.QuestionSelectAll(Aim,"",1,page);
			sql.close();
			return "success";
		}
	    return "error";
	}
}
