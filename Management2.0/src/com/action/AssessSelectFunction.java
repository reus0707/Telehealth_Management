package com.action;

import java.util.Vector;

import com.model.Assess;
import com.model.User;
import com.sql.MySQL;

public class AssessSelectFunction {
	private int userid;
	private User user;
	private int page;
	private String Aim;
	
	private Vector<Assess> AssessVect;
	private Assess Ass;
	private int assess_id;
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
	public Vector<Assess> getAssessVect() {
		return AssessVect;
	}
	public void setAssessVect(Vector<Assess> assessVect) {
		AssessVect = assessVect;
	}
	public Assess getAss() {
		return Ass;
	}
	public void setAss(Assess ass) {
		Ass = ass;
	}
	public int getAssess_id() {
		return assess_id;
	}
	public void setAssess_id(int assess_id) {
		this.assess_id = assess_id;
	}
	
	public String  AssessVectSelect() {//
		MySQL sql=new MySQL();
		user=sql.userInfor(userid);
		if(user.getType().equals("0") || user.getType().equals("1")) {
			String unit=user.getUnit();
			AssessVect=sql.selectAssess(page, unit, 0);
			sql.close();
			return "success";
		}
		else if(user.getType().equals("2")) {
			AssessVect=sql.selectAssess(page,"",1);//
			sql.close();
			return "admin";
		}
		return "success";
	}
	
	public String AssessQuery() {
		MySQL sql=new MySQL();
		user=sql.userInfor(userid);
		if(user.getType().equals("0") || user.getType().equals("1")) {
			AssessVect=sql.AssessSelectAll(Aim,user.getUnit(),0,page);
			sql.close();
			return "success";
		}
		else if(user.getType().equals("2")) {
			AssessVect=sql.AssessSelectAll(Aim,"",1,page);
			sql.close();
			return "success";
		}
	    return "error";
	}
}
