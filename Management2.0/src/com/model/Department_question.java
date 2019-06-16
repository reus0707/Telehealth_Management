package com.model;

public class Department_question {

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
	
	public void set(

		String question_pre,

		String typedisease
			)
	{

		this.question_pre=question_pre;

		this.typedisease=typedisease;
	}
}
