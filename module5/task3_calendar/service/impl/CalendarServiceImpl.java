package by.epam_training.java_online.module5.task3_calendar.service.impl;

import java.util.List;

import by.epam_training.java_online.module5.task3_calendar.dao.CalendarDaoProvider;
import by.epam_training.java_online.module5.task3_calendar.dao.DAOException;
import by.epam_training.java_online.module5.task3_calendar.dao.impl.CalendarDaoImpl;
import by.epam_training.java_online.module5.task3_calendar.entity.Month;
import by.epam_training.java_online.module5.task3_calendar.entity.Calendar.Date;
import by.epam_training.java_online.module5.task3_calendar.service.CalendarService;
import by.epam_training.java_online.module5.task3_calendar.service.ServiceException;
import by.epam_training.java_online.module5.task3_calendar.service.util.Validator;

public class CalendarServiceImpl implements CalendarService {

	private static CalendarDaoImpl calendarDaoImpl = CalendarDaoProvider.getInstance().getCalendarDaoImpl();

	@Override
	public void setDateParametres(Month month, int day, int year, boolean publicHoliday, boolean personalDayOff,
			String description) throws ServiceException {

		if (!Validator.isDataValid(month, day, year)) {
			throw new ServiceException("Wrong date!");
		}

			try {
				calendarDaoImpl.setDateParametres(month, day, year, publicHoliday, personalDayOff, description);
			} catch (DAOException e) {
				throw new ServiceException(e);
			}
	}

	@Override
	public List<Date> selectDates(String parameter) {
		return calendarDaoImpl.selectDates(parameter);
	}

	@Override
	public void createNewCalendar() throws ServiceException {

		try {
			calendarDaoImpl.createNewCalendar();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

}
