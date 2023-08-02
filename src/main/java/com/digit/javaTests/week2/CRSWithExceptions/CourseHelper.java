package com.digit.javaTests.week2.CRSWithExceptions;

import java.util.ArrayList;

public class CourseHelper {

	private static ArrayList<Course> courseList = new ArrayList<Course>();
	private static int courseID = 100;

	/*
	 * Creates and Returns new Course ID every time method is called
	 */
	static int courseIDGenerator() {
		courseID++;
		return courseID;
	}

	/*
	 * Adds course to List of Courses - courseList
	 */
	public static void addCourse(Course curCourse) {
		courseList.add(curCourse);
	}

	/*
	 * Returns Course object which has specified ID. Returns Null if there's no
	 * course associated with that ID.
	 */
	public static String getCourseNameFromID(int curID) {
		for (Course curCourse : courseList) {
			if (curCourse.getCourseID() == curID) {
				return curCourse.getName();
			}
		}
		return "";
	}

	/*
	 * Prints all the names of Courses Available with ID's
	 */
	public static void printCourseNames() {
		System.out.println("Choose from Courses: ");
		for (Course curCourse : courseList) {
			System.out.println("\t" + curCourse.getCourseID() + " : " + curCourse.getName());
		}
		System.out.println();
	}

	/*
	 * Print the Course details of Specified Course
	 */
	public static void printCourseDetails(Course curCourse) {
		System.out.println("Registered Course Details:");
		System.out.println("\tCourse ID: " + curCourse.getCourseID());
		System.out.println("\tCourse Name: " + curCourse.getName());
		System.out.println("\tCourse Fee: " + curCourse.getFee());
		System.out.println("\tCourse Duration: " + curCourse.getDurationInHrs());
		System.out.println("\tCourse Description: " + curCourse.getCourseDescription());
		System.out.println();
	}

	/*
	 * Prints all Courses from courseList
	 */
	public static void printAllCourseDetails() {
		for (Course curCourse : courseList) {
			printCourseDetails(curCourse);
		}
	}

	/*
	 * Checks whether input ID is valid ID for a Course. Checks whether any course
	 * exists with specified ID.
	 */
	public static boolean isValidCourseID(int curID) {
		for (Course curCourse : courseList) {
			if (curCourse.getCourseID() == curID) {
				return true;
			}
		}
		return false;
	}
}
