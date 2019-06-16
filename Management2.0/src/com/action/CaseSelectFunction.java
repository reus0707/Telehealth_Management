package com.action;
import java.util.Vector;

import com.model.Case;
import com.model.Exam;
import com.model.User;
import com.sql.MySQL;
//select count(department),department from case_history group by department;
public class CaseSelectFunction {

	private int userid;
	private User user;
	private int page;
	private String Aim;
	
	private Vector<Case> CaseVect;
	private Case Ca;
	private int case_id;
	
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
	public Vector<Case> getCaseVect() {
		return CaseVect;
	}
	public void setCaseVect(Vector<Case> caseVect) {
		CaseVect = caseVect;
	}
	public Case getCa() {
		return Ca;
	}
	public void setCa(Case ca) {
		Ca = ca;
	}
	public int getCase_id() {
		return case_id;
	}
	public void setCase_id(int case_id) {
		this.case_id = case_id;
	}
	
	public String  CaseVectSelect() {//
		MySQL sql=new MySQL();
		user=sql.userInfor(userid);//userid是从HomeAdmin.jsp中传过来的
		if(user.getType().equals("0") || user.getType().equals("1")) {
			String unit=user.getUnit();
			CaseVect=sql.selectCase(page, unit, 0);
			sql.close();
			return "success";
		}
		else if(user.getType().equals("2")) {
			CaseVect=sql.selectCase(page,"",1);//
			sql.close();
			return "admin";
		}
		return "success";
	}
	public String CaseSelect() {//这个选择是为了,单个选择,得到
		MySQL sql=new MySQL();
		user=sql.userInfor(userid);
		Ca=sql.selectCaseNumber(case_id);
		sql.close();
		return "success";
	}
	public String CaseQuery() {
		MySQL sql=new MySQL();
		user=sql.userInfor(userid);
		if(user.getType().equals("0") || user.getType().equals("1")) {
			CaseVect=sql.CaseselectAll(Aim,user.getUnit(),0,page);
			sql.close();
			return "success";
		}
		else if(user.getType().equals("2")) {
			CaseVect=sql.CaseselectAll(Aim,"",1,page);
			sql.close();
			return "success";
		}
	    return "error";
	}
	public String CaseDelete(){
		MySQL sql=new MySQL();
		user=sql.userInfor(userid);
		sql.CaseDeleteExecute(case_id);
		sql.close();
		return "success";
	}
	
}
