package com.digit.javaTests.week2.CRSWithExceptions;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentHelper {
	private static ArrayList<Student> studentList = new ArrayList<Student>();
	private static int studentID = 300;

	/*
	 * Creates and Returns new Student ID every time method is called
	 */
	static int studentIDGenerator() {
		studentID++;
		return studentID;
	}

	/*
	 * Adds student to List of Students - studentList
	 */
	public static void addStudent(Student curStudent) {
		studentList.add(curStudent);
	}

	/*
	 * Returns Student object which has specified ID. Returns Null if there's no
	 * Student associated with that ID.
	 */
	public static Student getStudentFromID(int id) {
		for (Student curStudent : studentList) {
			if (curStudent.getStudentID() == id) {
				return curStudent;
			}
		}
		return null;
	}

	/*
	 * Getter for studentList
	 */
	public static ArrayList<Student> getStudentList() {
		return studentList;
	}

	/*
	 * Prints Marks for specified Student
	 */
	public static void printStudentMarks(Student curStudent) {
		if (curStudent.getMarksSecured() != -1) {
			System.out.println("You Got: " + curStudent.getMarksSecured() + " marks!");
		} else {
			System.out.println("It is yet to be graded");
		}
	}

	/*
	 * Print the student details of Specified Student with specified Message
	 */
	public static void printStudentDetails(Student curStudent, String msg) {
		System.out.println(msg);
		System.out.println("\tStudent ID: " + curStudent.getStudentID());
		System.out.println("\tStudent Name: " + curStudent.getName());
		System.out.println("\tCourse Enrolled: " + curStudent.getCourseEnrolled() + " - "
				+ CourseHelper.getCourseNameFromID(curStudent.getCourseEnrolled()));
		System.out.println("\tStudent Age: " + curStudent.getAge());
		System.out.println("\tStudent City: " + curStudent.getCity());
		System.out.println();
	}

	/*
	 * Prints all Students from studentList
	 */
	public static void printAllStudentDetails() {
		for (Student curStudent : studentList) {
			printStudentDetails(curStudent, "Student Details: ");
		}
	}

	/*
	 * Prints Student marks card for specified Student
	 */
	public static void printStudentMarksCard(Student curStudent) {
		if (curStudent.getMarksSecured() == -1) {
			System.out.println("It is yet to be graded");
			return;
		}
		System.out.println("\t --- Marks Card --- \n");
		System.out.println("Student ID       : " + curStudent.getStudentID());
		System.out.println("Student Name     : " + curStudent.getName());
		System.out.println("Student Age      : " + curStudent.getAge());
		System.out.println("Student City     : " + curStudent.getCity());
		System.out.println("Course Enrolled  : " + curStudent.getCourseEnrolled());
		System.out.println("Course Name      : " + CourseHelper.getCourseNameFromID(curStudent.getCourseEnrolled()));
		System.out.println("Score out of 100 : " + curStudent.getMarksSecured());
		System.out.println();
	}
}
