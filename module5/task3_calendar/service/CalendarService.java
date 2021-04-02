package by.epam_training.java_online.module5.task3_calendar.service;

import java.util.List;

import by.epam_training.java_online.module5.task3_calendar.entity.Month;
import by.epam_training.java_online.module5.task3_calendar.entity.Calendar.Date;

public interface CalendarService {
	
	void createNewCalendar() throws ServiceException;
	
	void setDateParametres(Month month, int day, int year, boolean publicHoliday, boolean personalDayOff,
			String description) throws ServiceException;
	
	List<Date> selectDates(String parameter);

}
