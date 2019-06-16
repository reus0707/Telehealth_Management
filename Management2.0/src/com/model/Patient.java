package com.model;

public class Patient {
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
	public void set(int id,
		String name,
		String datebirth,
		String sex,
		String address,
		String telephone,
		String emergency_person,
		String emergency_person_telephone,
		String username,
		String password,
		String mail,
		String age,
		String addresscode,
		String language,
		String insurance)
	 {
		 this.id = id;
		 this.name = name;
		 this.datebirth = datebirth;
		 this.sex = sex;
		 this.address = address;
		 this.telephone = telephone;
		 this.emergency_person = emergency_person;
		 this.emergency_person_telephone = emergency_person_telephone;
		 this.username = username;
		 this.password = password;
		 this.mail = mail;
		 this.addresscode = addresscode;
		 this.language = language;
		 this.insurance = insurance;
		 this.age = age;
	 }
	
}
