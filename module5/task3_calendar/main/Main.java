/*
Модуль 5. Задача 3.
Условие:
Создать класс Календарь с внутренним классом, с помощью объектов которого можно хранить информацию о
выходных и праздничных днях.
*/

package by.epam_training.java_online.module5.task3_calendar.main;

import java.io.File;
import java.util.List;

import by.epam_training.java_online.module5.task3_calendar.dao.CalendarDaoProvider;
import by.epam_training.java_online.module5.task3_calendar.dao.DAOException;
import by.epam_training.java_online.module5.task3_calendar.entity.Calendar;
import by.epam_training.java_online.module5.task3_calendar.entity.Month;
import by.epam_training.java_online.module5.task3_calendar.entity.Calendar.Date;
import by.epam_training.java_online.module5.task3_calendar.service.CalendarServiceProvider;
import by.epam_training.java_online.module5.task3_calendar.service.ServiceException;
import by.epam_training.java_online.module5.task3_calendar.service.impl.CalendarServiceImpl;
import by.epam_training.java_online.module5.task3_calendar.view.CalendarView;

public class Main {

	public static void main(String[] args) throws  DAOException, ServiceException {

		CalendarServiceImpl calendarService = CalendarServiceProvider.getInstance().getCalendarServiceImpl();

		// если файла не существует - создать
		if (!new File(Calendar.getLocation()).exists()) {
			String directory = Calendar.getLocation().split("/")[0] + "/" + Calendar.getLocation().split("/")[1]  + "/";
			new File(directory).mkdir();
			calendarService.createNewCalendar();
		} else {
			// прочитать имеющийся файл
			CalendarDaoProvider.getInstance().getCalendarDaoImpl().readCalendarFile();
		}
		
		// установить личные выходные
		calendarService.setDateParametres(Month.DECEMBER, 28, 2021, false, true, "My cat birthday.");
		calendarService.setDateParametres(Month.NOVEMBER, 7, 2021, false, true, "My dog birthday.");
		//calendarService.setDateParametres(Month.NOVEMBER, 7, 2021, false, true, ""); // отмена личного выходного
		
		// список гос. праздников
		List<Date> publicHolidays = calendarService.selectDates("publicHoliday");
		System.out.println("The list of public holidays:");
		CalendarView.displayDateList(publicHolidays);

		// список личных выходных
		System.out.println("-------------------------");
		List<Date> personalDayOff = calendarService.selectDates("PersonalDayOff");
		System.out.println("The list of personal dayoffs:");
		CalendarView.displayDateList(personalDayOff);

		// общий список выходных
		System.out.println("-------------------------");
		List<Date> holidays = calendarService.selectDates("PublicHoliday&PersonalDayOff");
		System.out.println("The common list of holydays:");
		CalendarView.displayDateList(holidays);
		
	}
}
