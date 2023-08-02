package com.digit.javaTests.week2.CRSWithExceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Welcome To CourseArey!");
		System.out.println("\n------------ Admin Portal ------------");

		int authenticateCode = Admin.authenticateAdmin();
		if (authenticateCode == -1) {
			return;
		}

		Admin.registerCourses();
		Admin.registerProfessors();
		Admin.registerStudent();

		System.out.println("\n\nWelcome to CourseArey");
		System.out.println("\n------------ User Portal ------------");

		UserExecLoop: while (true) {
			System.out.println("\nChoose Portal to Access: ");
			System.out.println("1. Student\n2. Professor\n3. Admin\n4. Quit");

			try {
				System.out.println("\nEnter your choice: ");
				int ch = Integer.parseInt(sc.nextLine());
				if (ch == 1) {
					System.out.println("\n --- Student Portal ---\n");

					System.out.println("\nEnter Student ID for Authentication: ");
					int curStudId = Integer.parseInt(sc.nextLine());

					Student curStudent = StudentHelper.getStudentFromID(curStudId);
					if (curStudent == null) {
						throw new InvalidIDException();
					}

					StudentLoop: while (true) {
						System.out.println("\nChoose Operation: ");
						System.out.println("1. Get Scores\n2. Get Marks Card\n3. View Details\n4. Back to Main");

						System.out.println("\nEnter your choice: ");
						int curCh = Integer.parseInt(sc.nextLine());
						if (curCh == 1) {
							StudentHelper.printStudentMarks(curStudent);
						} else if (curCh == 2) {
							StudentHelper.printStudentMarksCard(curStudent);
						} else if (curCh == 3) {
							StudentHelper.printStudentDetails(curStudent, "\nYour Details: ");
						} else if (curCh == 4) {
							break StudentLoop;
						} else {
							System.out.println("Choose from options\n");
						}
					}

				} else if (ch == 2) {
					System.out.println("\n --- Professor Portal --- \n");

					System.out.println("\nEnter Professor ID for Authentication: ");
					int curProfId = Integer.parseInt(sc.nextLine());

					Professor curProfessor = ProfessorHelper.getProfessorFromID(curProfId);

					if (curProfessor == null) {
						throw new InvalidIDException();
					}

					ProfessorLoop: while (true) {
						System.out.println("\nChoose Operation: ");
						System.out.println("1. Grade Scores\n2. View Details\n3. Back to Main");

						int curCh = Integer.parseInt(sc.nextLine());
						if (curCh == 1) {
							ProfessorHelper.gradeStudentOfProfessor(curProfessor);
						} else if (curCh == 2) {
							ProfessorHelper.printProfessorDetails(curProfessor);
						} else if (curCh == 3) {
							break ProfessorLoop;
						} else {
							System.out.println("Choose from options");
						}
					}

				} else if (ch == 3) {
					System.out.println("\n --- Admin Portal --- \n");
					int authCode = Admin.authenticateAdmin();
					if (authCode == -1) {
						return;
					}

					AdminLoop: while (true) {
						System.out.println("\nChoose Operation: ");
						System.out.println(
								"1. Register New Course\n2. Register New Professor\n3. Register New Student\n4. View All Courses\n5. View All Professors\n6. View All Students\n7. Remove Student Grades\n8. Back To Main\n");
						int curCh = Integer.parseInt(sc.nextLine());
						if (curCh == 1) {
							Admin.createNewCourse();
						} else if (curCh == 2) {
							Admin.registerProfessors();
						} else if (curCh == 3) {
							Admin.registerStudent();
						} else if (curCh == 4) {
							CourseHelper.printAllCourseDetails();
						} else if (curCh == 5) {
							ProfessorHelper.printAllProfessorDetails();
						} else if (curCh == 6) {
							StudentHelper.printAllStudentDetails();
						} else if (curCh == 7) {
							Admin.deRegisterStudentGrades();
						} else if (curCh == 8) {
							break AdminLoop;
						} else {
							System.out.println("Choose From Options\n");
						}
					}

				} else if (ch == 4) {
					System.out.println("\nThanks for Visiting us.");
					System.out.println("Bye!");
					break UserExecLoop;
				} else {
					System.out.println("Wrong Input!");
				}
			} catch (InputMismatchException | NumberFormatException e) {
				System.err.println("Invalid Input: " + e.getLocalizedMessage());
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}

	}
}