package by.epam_training.java_online.module5.task3_calendar.dao;

import java.util.List;

import by.epam_training.java_online.module5.task3_calendar.entity.Month;
import by.epam_training.java_online.module5.task3_calendar.entity.Calendar.Date;

public interface CalendarDao {
	
	void createNewCalendar() throws DAOException;
	
	void readCalendarFile() throws DAOException;
		
	void setDateParametres(Month month, int day, int year, boolean publicHoliday, boolean personalDayOff,
			String description) throws DAOException;
	
	List<Date> selectDates(String parameter);

}
