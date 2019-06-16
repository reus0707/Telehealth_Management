package com.action;

import com.model.Patientanswer;
import com.model.AnswerStatis;
import com.model.User;
import java.util.Vector;
import com.model.User;
import com.sql.MySQL;

public class AnswerSelectFunction {
	private int userid;
	private User user;
	private int page;
	private String Aim;
	
	private Vector<Patientanswer> AnswerVect;
	private Patientanswer Ans;
	private int patientanswer_id;
	
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
	public Vector<Patientanswer> getAnswerVect() {
		return AnswerVect;
	}
	public void setAnswerVect(Vector<Patientanswer> answerVect) {
		AnswerVect = answerVect;
	}
	public Patientanswer getAns() {
		return Ans;
	}
	public void setAns(Patientanswer ans) {
		Ans = ans;
	}
	public int getPatientanswer_id() {
		return patientanswer_id;
	}
	public void setPatientanswer_id(int patientanswer_id) {
		this.patientanswer_id = patientanswer_id;
	}
	
	
	private Vector<AnswerStatis> AnswerStatisVect;//用于统计问题的无效次数
	public Vector<AnswerStatis> getAnswerStatisVect() {
		return AnswerStatisVect;
	}
	public void setAnswerStatisVect(Vector<AnswerStatis> answerStatisVect) {
		AnswerStatisVect = answerStatisVect;
	}
	
	
	public String  AnswerVectSelect() {//
		MySQL sql=new MySQL();
		user=sql.userInfor(userid);//userid是从HomeAdmin.jsp中传过来的
		if(user.getType().equals("0") || user.getType().equals("1")) {
			String unit=user.getUnit();
			AnswerVect=sql.selectAnswer(page, unit, 0);
			sql.close();
			return "success";
		}
		else if(user.getType().equals("2")) {
			AnswerVect=sql.selectAnswer(page,"",1);//
			sql.close();
			return "admin";
		}
		return "success";
	}
	public String AnswerSelect() {//
		MySQL sql=new MySQL();
		user=sql.userInfor(userid);
		Ans=sql.selectAnswerNumber(patientanswer_id);
		sql.close();
		return "success";
	}
	
	public String AnswerQuery() {
		MySQL sql=new MySQL();
		user=sql.userInfor(userid);
		if(user.getType().equals("0") || user.getType().equals("1")) {
			AnswerVect=sql.PatientselectAll(Aim,user.getUnit(),0,page);
			sql.close();
			return "success";
		}
		else if(user.getType().equals("2")) {
			AnswerVect=sql.PatientselectAll(Aim,"",1,page);
			sql.close();
			return "success";
		}
	    return "error";
	}
	public String  AnswerStatis() {//统计sta大于0的题目
		MySQL sql=new MySQL();
		user=sql.userInfor(userid);//userid是从HomeAdmin.jsp中传过来的
		if(user.getType().equals("0") || user.getType().equals("1")) {
			String unit=user.getUnit();
			//AnswerVect=sql.selectAnswer(page, unit, 0);
			sql.close();
			return "success";
		}
		else if(user.getType().equals("2")) {
			AnswerStatisVect=sql.selectAnswerStatis(page,"",1);//
			sql.close();
			return "success";
		}
		return "success";
	}
}
