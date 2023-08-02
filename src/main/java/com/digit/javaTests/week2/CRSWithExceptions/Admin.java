package com.digit.javaTests.week2.CRSWithExceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Admin {

	static String userName = "admin";
	static String password = "admin";

	static void createNewStudent() {
		Scanner sc = new Scanner(System.in);

		while (true) {
			try {
				System.out.println("\n--- Enter Student Details ---");
				System.out.println("Enter Student Name: ");
				String curStudentName = sc.nextLine();

				CourseHelper.printCourseNames();

				System.out.println("Enter Course Enrolled: ");
				int curStudentCourseEnrolledID = Integer.parseInt(sc.nextLine());

				if (!CourseHelper.isValidCourseID(curStudentCourseEnrolledID)) {
					throw new InvalidIDException("Invalid Course ID. Course with ID doesn't exists!");
				}

				System.out.println("Enter Student Age: ");
				int age = Integer.parseInt(sc.nextLine());
				System.out.println("Enter Student City: ");
				String city = sc.nextLine();

				int studID = StudentHelper.studentIDGenerator();

				Student curStudent = new Student(studID, curStudentName, curStudentCourseEnrolledID, -1, age, city);
				StudentHelper.addStudent(curStudent);

				System.out.println("\nStudent Registered Successfully!\n");

				StudentHelper.printStudentDetails(curStudent, "Registered Student Details: ");

				break;

			} catch (InputMismatchException | NumberFormatException e) {
				System.err.println("Invalid Input: " + e.getLocalizedMessage());
			}

			catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}

	}

	static void registerStudent() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("\n --- Student Registration Portal --- \n");
			System.out.println("1. Create New Student\n2. Stop");

			try {
				System.out.println("\nEnter your choice: ");
				int ch = Integer.parseInt(sc.nextLine());
				if (ch == 1) {

					createNewStudent();

				} else if (ch == 2) {
					System.out.println("\nExiting Student Registration Portal...\n");
					return;
				} else {
					System.out.println("Select from Options");
					continue;
				}
			} catch (InputMismatchException | NumberFormatException e) {
				System.err.println("Invalid Input: " + e.getLocalizedMessage());
			}

			catch (Exception e) {
				System.err.println(e.getMessage());
				continue;
			}
		}
	}

	static void createNewProfessor() {
		Scanner sc = new Scanner(System.in);

		while (true) {

			try {
				System.out.println("\n--- Enter Professor Details ---");
				System.out.println("Enter Professor Name: ");
				String curProfName = sc.nextLine();

				CourseHelper.printCourseNames();

				System.out.println("Enter Course ID of Professor Teaching (ID only): ");
				int curProfsCourseID = Integer.parseInt(sc.nextLine());

				if (!CourseHelper.isValidCourseID(curProfsCourseID)) {
					throw new InvalidIDException("Invalid Course ID. Course with ID doesn't exists!");
				}

				System.out.println("Enter Professor Age: ");
				int age = Integer.parseInt(sc.nextLine());
				System.out.println("Enter Professor City: ");
				String city = sc.nextLine();
				System.out.println("Enter Professor's Years of Experience: ");
				int yearsOfExp = Integer.parseInt(sc.nextLine());

				int profID = ProfessorHelper.professorIDGenerator();

				Professor curProfessor = new Professor(profID, curProfName, curProfsCourseID, age, city, yearsOfExp);
				ProfessorHelper.addProfessor(curProfessor);

				System.out.println("\nProfessor Registered Successfully!\n");

				ProfessorHelper.printProfessorDetails(curProfessor);

				break;

			} catch (InputMismatchException | NumberFormatException e) {
				System.err.println("Invalid Input: " + e.getLocalizedMessage());
			} catch (Exception e) {
				System.err.println(e.getMessage());
				continue;
			}
		}
	}

	static void registerProfessors() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("\n --- Professor Registration Portal --- \n");
			System.out.println("1. Create New Professor\n2. Stop");

			try {
				System.out.println("\nEnter your choice: ");
				int ch = Integer.parseInt(sc.nextLine());
				if (ch == 1) {

					createNewProfessor();

				} else if (ch == 2) {
					System.out.println("\nExiting Professor Registration Portal...");
					return;
				} else {
					System.out.println("Select from Options");
					continue;
				}
			} catch (InputMismatchException | NumberFormatException e) {
				System.err.println("Invalid Input: " + e.getLocalizedMessage());
			} catch (Exception e) {
				System.err.println(e.getMessage());
				continue;
			}
		}
	}

	static void createNewCourse() {
		Scanner sc = new Scanner(System.in);

		System.out.println("\n--- Course Details Page ---");
		System.out.println("Enter Course Name: ");
		String curCourseName = sc.nextLine();
		System.out.println("Enter Course Fee: ");
		int curCourseFee = Integer.parseInt(sc.nextLine());
		System.out.println("Enter Course Duration In Hrs: ");
		int curCourseDuration = Integer.parseInt(sc.nextLine());
		System.out.println("Enter Course Description: ");
		String curDesc = sc.nextLine();
		int courseID = CourseHelper.courseIDGenerator();

		Course curCourse = new Course(courseID, curCourseName, curCourseFee, curCourseDuration, curDesc);
		CourseHelper.addCourse(curCourse);

		System.out.println("\nCourse Registered Successfully!\n");

		CourseHelper.printCourseDetails(curCourse);
	}

	static void registerCourses() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("\n --- Course Registration Portal --- \n");
			System.out.println("1. Create New Course\n2. Stop");

			try {
				System.out.println("\nEnter your choice: ");
				int ch = Integer.parseInt(sc.nextLine());
				if (ch == 1) {

					createNewCourse();

				} else if (ch == 2) {
					System.out.println("\nExiting Course Registration Portal...");
					break;
				} else {
					System.out.println("Select from Options");
					continue;
				}
			} catch (InputMismatchException | NumberFormatException e) {
				System.err.println("Invalid Input: " + e.getLocalizedMessage());
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
	}

	static int authenticateAdmin() {
		Scanner sc = new Scanner(System.in);
		int chances = 3;
		boolean authenticated = false;

		try {
			while (true) {
				System.out.println("\n --- Admin Login Page --- \n");

				System.out.println("Enter User Name for Admin: ");
				String inputUserName = sc.nextLine();

				System.out.println("Enter Password for Admin: ");
				String inputPassword = sc.nextLine();

				if (inputUserName.equals(Admin.userName) && inputPassword.equals(Admin.password)) {
					System.out.println("\nWelcome Admin!\n");
					authenticated = true;
					break;
				} else {
					chances--;
					if (chances == 0) {
						throw new InvalidAdminException();
					}
					System.out.println("\nWrong Credentials! Please Try Again.");
					System.out.println("You have " + chances + " left!\n");
					continue;
				}
			}
		} catch (InputMismatchException | NumberFormatException e) {
			System.err.println("Invalid Input: " + e.getLocalizedMessage());
		} catch (Exception e) {
			System.err.println(e.getLocalizedMessage());
		}

		if (authenticated) {
			return 1;
		}
		return -1;
	}

	static void deRegisterStudentGrades() {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter Student ID to Remove: ");
			int curID = Integer.parseInt(sc.nextLine());
			Student curStudent = StudentHelper.getStudentFromID(curID);
			if (curStudent == null) {
				throw new InvalidIDException("Invalid Student ID. Student with ID doesn't exists!");
			}
			
			if (curStudent.getMarksSecured() == -1) {
				System.out.println("Student still not graded yet!");
			} else {
				curStudent.setMarksSecured(-1);
			}

		} catch (InputMismatchException | NumberFormatException e) {
			System.err.println("Invalid Input: " + e.getLocalizedMessage());
		} catch (Exception e) {
			System.err.println(e.getLocalizedMessage());
		}
	}
}
