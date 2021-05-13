package by.epam_training.java_online.module6.task2_notepad.view.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

	public static boolean validateDate(int month, int day, int year) {

		if (month < 1 || month > 12)
			return false;

		if (day < 1 || day > 31)
			return false;

		if (year < 0 || year > 2100)
			return false;
		
		

		return true;
	}

	public static boolean validateTopic(int topic, int numberOfTopic) {

		return (topic > 0 && topic < numberOfTopic + 1);
	}

	public static boolean validateEmail(String email) {
		return email
				.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	}

	public static boolean validateContent(String content) {

		Pattern pattern = Pattern.compile(".*[^\\|\\*\\=]");
		Matcher matcher = pattern.matcher(content);
		return matcher.matches();
	}

}
