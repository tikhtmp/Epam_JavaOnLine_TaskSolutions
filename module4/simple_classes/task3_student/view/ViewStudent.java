package by.epam_training.java_online.module4.simple_classes.task3_student.view;

import java.util.Arrays;

import by.epam_training.java_online.module4.simple_classes.task3_student.entity.Student;
import by.epam_training.java_online.module4.simple_classes.task3_student.logic.StudentLogic;

public class ViewStudent {

	public static void display(Student student) {
		System.out.printf("%-5s %-10s %-6s %-2s %-12s %-17s \n", "Name:", student.getName(), "Group:",
				student.getGroup(), "Achievement:", Arrays.toString(student.getAchievement()));
	}

	public static void show(Student[] student) {
		System.out.println("The list of students:");

		for (Student st : student) {
			display(st);
		}
		System.out.println();
	}

	public static void display(Student[] student, int grade) {
		StudentLogic showByAchievement = new StudentLogic();
		
		System.out.println("These students have rating " + grade + " or more:");

		for (Student st : student) {

			if (showByAchievement.isGradeMoreThan(st, grade)) {
				display(st);
			}
		}
		
		System.out.println();
	}
}
