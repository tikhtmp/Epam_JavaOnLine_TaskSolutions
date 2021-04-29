package by.epam_training.java_online.module6.task1_library.service.validation;

import java.util.Calendar;

public class Validator {
// Валидацию проходят: имя человека, логин, пароль, год издания книги, адрес эл. почты.
// Тип книги жестко задается еще на этапе формирования запроса, а ее название
// в наш просвещенный век может включать любые символы в любом порядке.

	public static boolean validateName(String name) {
		return name.matches("^[a-zA-Z\\s\\.\\']*$"); //буквы латинского алфавита, пробелы, точки, апострофы
	}

	public static boolean validateYear(String year) {
		int validatedYear = Integer.parseInt(year);

		return (validatedYear >= 1445 && validatedYear <= Calendar.getInstance().get(Calendar.YEAR)); // 1445 г. - первая печатная книга Гутенберга
	}

	public static boolean validateLogin(String login) {

		return login.matches("\\w+"); // буквенно-цифровой символ или знак подчёркивания
	}

	public static boolean validatePassword(String password) {
		return password.matches("\\w+"); // буквенно-цифровой символ или знак подчёркивания
	}

	public static boolean validateEmail(String email) {
		return email
				.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	}

}
