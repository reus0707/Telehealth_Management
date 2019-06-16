package com.action;

import java.sql.Date;

import com.sql.MySQL;

import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;
import com.model.*;
import java.text.SimpleDateFormat;

public class AnswerUpdate {
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
	
	private Vector<Patientanswer> AnswerVect;
	public Vector<Patientanswer> getAnswerVect() {
		return AnswerVect;
	}
	public void setAnswerVect(Vector<Patientanswer> answerVect) {
		AnswerVect = answerVect;
	}

	private int patientanswer_id;
	private int question_id;
	private int patient_id;
	private String answer_content;
	private String time;
	private String question_content;//其实从这往下不用计，但我就是要计
	private String typedisease;//病种类型
	private String patientname;
	private String department;
	private int recep_id;//注意这里是int类型!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	
	ArrayList<String> Description = new ArrayList<String>();//获取题目描述
	
	public int getPatientanswer_id() {
		return patientanswer_id;
	}
	public void setPatientanswer_id(int patientanswer_id) {
		this.patientanswer_id = patientanswer_id;
	}
	public int getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}
	public int getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}
	public String getAnswer_content() {
		return answer_content;
	}
	public void setAnswer_content(String answer_content) {
		this.answer_content = answer_content;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getQuestion_content() {
		return question_content;
	}
	public void setQuestion_content(String question_content) {
		this.question_content = question_content;
	}
	public String getTypedisease() {
		return typedisease;
	}
	public void setTypedisease(String typedisease) {
		this.typedisease = typedisease;
	}
	public String getPatientname() {
		return patientname;
	}
	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getRecep_id() {
		return recep_id;
	}
	public void setRecep_id(int recep_id) {
		this.recep_id = recep_id;
	}
	public ArrayList<String> getDescription() {
		return Description;
	}
	public void setDescription(ArrayList<String> description) {
		Description = description;
	}
	
	public String execute() {
		MySQL sql=new MySQL();
		user=sql.userInfor(userid);
		//sql.ExamUpdate(exam_id, patient_id, patientname, time, height, weight, pulserate, bloodpressure, spo, temperature, bwh);
		sql.close();
		return "success";
	}
	public String AnswerAddJump() {
		MySQL sql=new MySQL();
		user=sql.userInfor(userid);
		sql.close();
		return "success";
	}
	public String ExamAdd() {
		MySQL sql=new MySQL();
		user=sql.userInfor(userid);
		Exam Ex = new Exam();
		//Ex.set(exam_id, time, height, weight, pulserate, bloodpressure, spo, temperature, bwh, patientname, sex, age);
		sql.ExamAdd(Ex);
		sql.close();
		return "success";
	}

	public String AnswerMakeExam(){
		MySQL sql=new MySQL();
		user=sql.userInfor(userid);
		System.out.println("daozhele");
		Description = sql.GetQuestionByType(typedisease);//题目描述
		Patientanswer Ans = new Patientanswer();
		Ans.setByTypedisease(patient_id, time);
		sql.close();
		return "success";
	}
	
	public String AnswerVerify(){//设置判断回答有效与无效
		MySQL sql=new MySQL();
		user=sql.userInfor(userid);
		System.out.println(patientanswer_id+"ssssssss");
		
		sql.AnswerUpdateSta(patientanswer_id);
		AnswerVect=sql.selectAnswer(0,"",1);//
		sql.close();
		return "success";
	}
	
	public String AnswerDelete(){
		MySQL sql=new MySQL();
		user=sql.userInfor(userid);
		sql.AnswerDeleteExecute(patientanswer_id);
		sql.close();
		return "success";
	}
	
}
