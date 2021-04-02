package by.epam_training.java_online.module5.task3_calendar.service;

import by.epam_training.java_online.module5.task3_calendar.service.impl.CalendarServiceImpl;

public class CalendarServiceProvider {

	private static final CalendarServiceProvider instance = new CalendarServiceProvider();;
	private CalendarServiceImpl calendarServiceImpl = new CalendarServiceImpl();

	private CalendarServiceProvider() {
	}

	public static CalendarServiceProvider getInstance() {
		return instance;
	}

	public CalendarServiceImpl getCalendarServiceImpl() {
		return calendarServiceImpl;
	}

}
