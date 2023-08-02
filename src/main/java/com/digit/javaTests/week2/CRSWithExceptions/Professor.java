package com.digit.javaTests.week2.CRSWithExceptions;

public class Professor {
	private int professorID;
	private String name;
	private int courseID;
	private int age;
	private String city;
	private int yearsOfExpreience;

	public Professor(int professorID, String name, int courseID, int age, String city, int yearsOfExpreience) {
		super();
		this.professorID = professorID;
		this.name = name;
		this.courseID = courseID;
		this.age = age;
		this.city = city;
		this.yearsOfExpreience = yearsOfExpreience;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getYearsOfExpreience() {
		return yearsOfExpreience;
	}

	public void setYearsOfExpreience(int yearsOfExpreience) {
		this.yearsOfExpreience = yearsOfExpreience;
	}

	public int getProfessorID() {
		return professorID;
	}

	public void setProfessorID(int professorID) {
		this.professorID = professorID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCourseID() {
		return courseID;
	}

	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}

}
