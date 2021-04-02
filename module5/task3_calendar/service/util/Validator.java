package by.epam_training.java_online.module5.task3_calendar.service.util;

import java.util.Map;

import by.epam_training.java_online.module5.task3_calendar.entity.Calendar;
import by.epam_training.java_online.module5.task3_calendar.entity.Month;

public class Validator {

	public static boolean isDataValid(Month month, int day, int year) {

		if (month == null || day < 1 || year != 2021)
			return false;

		for (Map.Entry<Month, Integer> entry : Calendar.getInstance().getMonthes().entrySet()) {

			if (entry.getKey() == month && (day > entry.getValue())) {
				return false;
			}
		}

		return true;
	}
}
