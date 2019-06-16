package com.action;

import java.sql.Date;
import com.model.User;
import com.sql.MySQL;
import java.util.Random;
import java.util.Vector;
import com.model.*;
import java.text.SimpleDateFormat;

public class UpdatePatient {
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
	private int page;
	
	private int id;
	private String name;
	private String datebirth;
	private String sex;
	private String address;
	private String telephone;
	private String emergency_person;
	private String emergency_person_telephone;
	private String username;
	private String password;
	private String mail;
	private String age;
	private String addresscode;
	private String language;
	private String insurance;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDatebirth() {
		return datebirth;
	}
	public void setDatebirth(String datebirth) {
		this.datebirth = datebirth;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmergency_person() {
		return emergency_person;
	}
	public void setEmergency_person(String emergency_person) {
		this.emergency_person = emergency_person;
	}
	public String getEmergency_person_telephone() {
		return emergency_person_telephone;
	}
	public void setEmergency_person_telephone(String emergency_person_telephone) {
		this.emergency_person_telephone = emergency_person_telephone;
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
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	 public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getAddresscode() {
		return addresscode;
	}
	public void setAddresscode(String addresscode) {
		this.addresscode = addresscode;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getInsurance() {
		return insurance;
	}
	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}
	public String execute() {
		MySQL sql=new MySQL();
		user=sql.userInfor(userid);
		sql.UpdatePatient(id, name, sex, address, telephone, emergency_person, emergency_person_telephone, password, mail, age, addresscode, language, insurance);
		sql.close();
		return "success";
	}
	public String PatientAddJump() {
		MySQL sql=new MySQL();
		user=sql.userInfor(userid);
		sql.close();
		return "success";
	}
	public String PatientAdd() {
		MySQL sql=new MySQL();
		user=sql.userInfor(userid);
		Patient Pat=new Patient();
		Pat.set(id, name, datebirth, sex, address, telephone, emergency_person, emergency_person_telephone, username, password, mail, age, addresscode, language, insurance);
		sql.AddPatient(Pat);
		sql.close();
		return "success";
	}
	public String PatientDelete(){
		MySQL sql=new MySQL();
		user=sql.userInfor(userid);
		sql.PatientDeleteExecute(id);
		sql.close();
		return "success";
	}
	
}
