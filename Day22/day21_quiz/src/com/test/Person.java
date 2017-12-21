package com.test;

public class Person {
	private String name;
	private String user;
	private String password;
	private String profession;
	
	public Person() {}
	
	public Person(String name,String user,String password, String profession) {
		this.name = name;
		this.profession = profession;
		this.user = user;
		this.password = password;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}
	
	public void random() {}
	
	public String toString() {
		return "姓名：" + name + " 职业：" + profession+ " ";
	}
	
}
