package by.epam_training.java_online.module5.task3_calendar.dao;

import by.epam_training.java_online.module5.task3_calendar.dao.impl.CalendarDaoImpl;

public class CalendarDaoProvider {
	
	private static final CalendarDaoProvider instance = new CalendarDaoProvider();
	
	private CalendarDaoImpl calendarDaoImpl = new CalendarDaoImpl();
	
	private CalendarDaoProvider() {}

	public static CalendarDaoProvider getInstance() {
		return instance;
	}

	public CalendarDaoImpl getCalendarDaoImpl() {
		return calendarDaoImpl;
	}
}
