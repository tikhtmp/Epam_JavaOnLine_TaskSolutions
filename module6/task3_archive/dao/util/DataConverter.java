package by.epam_training.java_online.module6.task3_archive.dao.util;

import java.util.List;

import by.epam_training.java_online.module6.task3_archive.bean.Client;
import by.epam_training.java_online.module6.task3_archive.bean.Student;

public class DataConverter {

	public static String convertStudentsIntoString(List<Student> students) {
		StringBuilder result = new StringBuilder();
		String currentLine;

		for (Student s : students) {
			currentLine = convertStudentIntoString(s);
			result.append(currentLine);
		}

		return result.toString();
	}

	public static String convertStudentIntoString(Student student) {
		String result;
		result = String.format("%4s | %s]", student.getId(), student.getName());
		return result;
	}

	public static String convertClientsIntoString(List<Client> clients) {
		StringBuilder result = new StringBuilder();
		String currentLine;
		String access;

		for (Client c : clients) {

			access = c.isAdmin() ? "Admin:" : "User:";
			currentLine = String.format("%7s %-15spassword:%s\n", access, c.getLogin(), c.getPassword());
			result.append(currentLine);
		}

		return result.toString();
	}

}
