package com.digit.javaTests.week2.CRSWithExceptions;

public class Student {
	private int studentID;
	private String name;
	private int courseEnrolled;
	private int marksSecured;
	private int age;
	private String city;

	public Student(int studentID, String name, int courseEnrolled, int marksSecured, int age, String city) {
		this.studentID = studentID;
		this.name = name;
		this.courseEnrolled = courseEnrolled;
		this.marksSecured = marksSecured;
		this.age = age;
		this.city = city;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCourseEnrolled() {
		return courseEnrolled;
	}

	public void setCourseEnrolled(int courseEnrolled) {
		this.courseEnrolled = courseEnrolled;
	}

	public int getMarksSecured() {
		return marksSecured;
	}

	public void setMarksSecured(int marksSecured) {
		this.marksSecured = marksSecured;
	}
}
