package com.LambdaPractise;

public class People {
	
	public String firstname;
	public String lastname;
	public int age;
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLasttname() {
		return lastname;
	}
	public void setLasttname(String lasttname) {
		this.lastname = lasttname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public People(String firstname,String lastname,int age) {
		super();
		this.firstname=firstname;
		this.lastname=lastname;
		this.age=age;
		
	}
	@Override
	public String toString() {
		return "People [firstname=" + firstname + ", lastname=" + lastname + ", age=" + age + "]";
	}
	
	

}
