package by.epam_training.java_online.module5.task3_calendar.view;

import java.util.List;

import by.epam_training.java_online.module5.task3_calendar.entity.Calendar.Date;

public class CalendarView {

	public static void displayDate(Date date) {

		System.out.printf(" %-10s%-10s%02d %4d ", date.getDayOfWeek(), date.getMonth(), date.getDay(), date.getYear());

		StringBuffer dayFeatures = new StringBuffer();
		dayFeatures.append(date.getDescription());

		if (date.isPublicHoliday())
			dayFeatures.append(" PUBLIC Holiday.");

		if (date.isPersonalDayOff())
			dayFeatures.append(" PERSONAL DayOff.");

		System.out.println(dayFeatures);
	}

	public static void displayDateList(List<Date> dates) {

		for (Date d : dates) {
			displayDate(d);
		}
	}

}
