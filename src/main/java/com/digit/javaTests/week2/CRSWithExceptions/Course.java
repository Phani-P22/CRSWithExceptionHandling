package com.digit.javaTests.week2.CRSWithExceptions;

public class Course {
	private int courseID;
	private String name;
	private int fee;
	private int durationInHrs;
	private String courseDescription;

	public Course(int courseID, String name, int fee, int durationInHrs, String courseDescription) {
		this.courseID = courseID;
		this.name = name;
		this.fee = fee;
		this.durationInHrs = durationInHrs;
		this.courseDescription = courseDescription;
	}

	public int getCourseID() {
		return courseID;
	}

	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public int getDurationInHrs() {
		return durationInHrs;
	}

	public void setDurationInHrs(int durationInHrs) {
		this.durationInHrs = durationInHrs;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

}
