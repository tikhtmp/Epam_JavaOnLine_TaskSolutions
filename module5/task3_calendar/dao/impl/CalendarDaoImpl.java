package by.epam_training.java_online.module5.task3_calendar.dao.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import by.epam_training.java_online.module5.task3_calendar.dao.CalendarDao;
import by.epam_training.java_online.module5.task3_calendar.dao.DAOException;
import by.epam_training.java_online.module5.task3_calendar.entity.Calendar;
import by.epam_training.java_online.module5.task3_calendar.entity.DayOfWeek;
import by.epam_training.java_online.module5.task3_calendar.entity.Month;
import by.epam_training.java_online.module5.task3_calendar.entity.Calendar.Date;
import by.epam_training.java_online.module5.task3_calendar.entity.Calendar.Date.DateBuilder;

public class CalendarDaoImpl implements CalendarDao {

	// создание календаря при первом запуске приложения
	@Override
	public void createNewCalendar() throws DAOException {
		initializeCalendar();
		saveCalendarFile();
	}

	// установка параметров избранной даты
	@Override
	public void setDateParametres(Month month, int day, int year, boolean publicHoliday, boolean personalDayOff,
			String description) throws DAOException {

		int dayOfYear = calculateDayOfYear(month, day);
		Date choosenDate = Calendar.getInstance().getDates2021().get(dayOfYear - 1);
		String currentDescription = choosenDate.getDescription();

		if (choosenDate.isPublicHoliday()) {
			publicHoliday = true;
			currentDescription = currentDescription.split(" / ")[0];

			if (description.isEmpty()) {
				choosenDate.setDescription(currentDescription.split(" / ")[0]);
				choosenDate.setPersonalDayOff(false);
			} else {
				choosenDate.setDescription(currentDescription + " / " + description);
				choosenDate.setPersonalDayOff(personalDayOff);

			}
		} else {
			choosenDate.setDescription(description);
			choosenDate.setPersonalDayOff(personalDayOff);
		}

		choosenDate.setPublicHoliday(publicHoliday);
		saveCalendarFile();
	}

	public DayOfWeek specifyDayOfWeek(Month month, int day) {

		DayOfWeek[] daysOfWeek = DayOfWeek.values();
		int yearDay = calculateDayOfYear(month, day);
		int weekDay = (yearDay + 4 - 1) % 7;
		return daysOfWeek[weekDay];
	}

	private int calculateDayOfYear(Month month, int day) {

		int dayOfYear = 0;

		for (Map.Entry<Month, Integer> entry : Calendar.getInstance().getMonthes().entrySet()) {

			if (entry.getKey().equals(month)) {
				dayOfYear = dayOfYear + day;
				break;
			} else {
				dayOfYear = dayOfYear + entry.getValue();
			}
		}

		return dayOfYear;
	}

	@Override
	public List<Date> selectDates(String parameter) {

		List<Date> result = new ArrayList<Date>();

		for (Date d : Calendar.getInstance().getDates2021()) {

			if (d.isPersonalDayOff() && parameter.equalsIgnoreCase("PersonalDayOff")) {
				result.add(d);
			} else if (d.isPublicHoliday() && parameter.equalsIgnoreCase("PublicHoliday")) {
				result.add(d);
			} else if ((d.isPublicHoliday() || d.isPersonalDayOff())
					&& parameter.equalsIgnoreCase("PublicHoliday&PersonalDayOff")) {
				result.add(d);
			}
		}

		return result;
	}

	@Override
	public void readCalendarFile() throws DAOException {
		Calendar calendar = Calendar.getInstance();
		calendar.getDates2021().clear();

		XMLInputFactory factory = XMLInputFactory.newInstance();
		InputStream input = null;

		try {
			input = new FileInputStream(new File(Calendar.getLocation()));

			XMLEventReader eventReader = factory.createXMLEventReader(input);

			Month currentMonth = null;
			int currentDay = 0;
			int currentYear = 0;
			DayOfWeek currentDayOfWeek = null;
			boolean currentPublicHoliday = false;
			boolean currentPersonalDayOff = false;
			String currentDescription = null;

			while (eventReader.hasNext()) {
				XMLEvent event = eventReader.nextEvent();

				if (event.isStartElement()) {
					StartElement startElement = event.asStartElement();

					if (startElement.getName().getLocalPart().equals("Date")) {
						event = eventReader.nextEvent();
						continue;
					}

					if (startElement.getName().getLocalPart().equals("Month")) {
						event = eventReader.nextEvent();
						currentMonth = chooseMonth(event.asCharacters().getData());
						continue;
					}

					if (startElement.getName().getLocalPart().equals("Day")) {
						event = eventReader.nextEvent();
						currentDay = Integer.parseInt(event.asCharacters().getData());
						continue;
					}

					if (startElement.getName().getLocalPart().equals("Year")) {
						event = eventReader.nextEvent();
						currentYear = Integer.parseInt(event.asCharacters().getData());
						continue;
					}

					if (startElement.getName().getLocalPart().equals("DayOfWeek")) {
						event = eventReader.nextEvent();
						currentDayOfWeek = chooseDayOfWeek(event.asCharacters().getData());
						continue;
					}

					if (startElement.getName().getLocalPart().equals("PublicHoliday")) {
						event = eventReader.nextEvent();
						currentPublicHoliday = Boolean.parseBoolean(event.asCharacters().getData());
						continue;
					}

					if (startElement.getName().getLocalPart().equals("PersonalDayOff")) {
						event = eventReader.nextEvent();
						currentPersonalDayOff = Boolean.parseBoolean(event.asCharacters().getData());
						continue;
					}

					if (startElement.getName().getLocalPart().equals("Description")) {

						event = eventReader.nextEvent();

						if (!event.isEndElement()) {
							currentDescription = event.asCharacters().getData();
						} else {
							currentDescription = "";
						}
					}

				}

				if (event.isEndElement()) {
					EndElement endElement = event.asEndElement();

					if (endElement.getName().getLocalPart().equals("Date")) {
						Date currentDate = new DateBuilder(currentMonth, currentDay, currentYear)
								.withDayOfWeek(currentDayOfWeek).withPublicHoliday(currentPublicHoliday)
								.withPersonalDayOff(currentPersonalDayOff).withDescription(currentDescription).build();

						calendar.getDates2021().add(currentDate);
					}
				}
			}

		} catch (XMLStreamException e) {
			throw new DAOException(e);
		} catch (FileNotFoundException e) {
			throw new DAOException(e);
		} finally {

			try {
				if (input != null)
					input.close();
			} catch (IOException e) {
				throw new DAOException(e);
			}
		}
	}

	// инициализация календаря при первом запуске приложения
	private void initializeCalendar() throws DAOException {

		DayOfWeek[] daysOfWeek = DayOfWeek.values();
		Calendar calendar = Calendar.getInstance();

		DayOfWeek currentDayOfWeek;
		int currentDay = 5;

		for (Map.Entry<Month, Integer> entry : calendar.getMonthes().entrySet()) {

			for (int i = 0; i < entry.getValue(); i++) {

				currentDayOfWeek = daysOfWeek[currentDay++];
				if (currentDay > 6)
					currentDay = 0;

				Date currentDate = new Date.DateBuilder(entry.getKey(), i + 1, 2021).withDayOfWeek(currentDayOfWeek)
						.withDescription("").build();

				calendar.getDates2021().add(currentDate);
			}
		}
		setDateParametres(Month.JANUARY, 1, 2021, true, false, "New Year.");
		setDateParametres(Month.JANUARY, 7, 2021, true, false, "Christmas (Orthodox).");
		setDateParametres(Month.MARCH, 8, 2021, true, false, "Women's day.");
		setDateParametres(Month.MAY, 1, 2021, true, false, "Labor Day.");
		setDateParametres(Month.MAY, 9, 2021, true, false, "Victory Day.");
		setDateParametres(Month.JULY, 3, 2021, true, false, "Independence Day.");
		setDateParametres(Month.NOVEMBER, 7, 2021, true, false, "October Revolution Day.");
		setDateParametres(Month.DECEMBER, 25, 2021, true, false, "Christmas (Catholic).");

	}

	private void saveCalendarFile() throws DAOException {

		Calendar calendar = Calendar.getInstance();
		List<Date> list = calendar.getDates2021();

		try {
			XMLOutputFactory output = XMLOutputFactory.newInstance();

			XMLStreamWriter writer = output.createXMLStreamWriter((new FileOutputStream(Calendar.getLocation(), false)),
					"UTF-8");

			writer.writeStartDocument("UTF-8", "1.0");
			writer.writeDTD("\n");
			writer.writeStartElement("Calendar_2021");
			writer.writeDTD("\n");

			for (int i = 0; i < 365; i++) {
				writer.writeDTD("\t");
				writer.writeStartElement("Date");
				writer.writeDTD("\n");

				writer.writeDTD("\t\t");
				writer.writeStartElement("Month");
				writer.writeCharacters(list.get(i).getMonth().toString());
				writer.writeEndElement();
				writer.writeDTD("\n");

				writer.writeDTD("\t\t");
				writer.writeStartElement("Day");
				Integer day = list.get(i).getDay();
				writer.writeCharacters(day.toString());
				writer.writeEndElement();
				writer.writeDTD("\n");

				writer.writeDTD("\t\t");
				writer.writeStartElement("Year");
				Integer year = list.get(i).getYear();
				writer.writeCharacters(year.toString());
				writer.writeEndElement();
				writer.writeDTD("\n");

				writer.writeDTD("\t\t");
				writer.writeStartElement("DayOfWeek");
				writer.writeCharacters(list.get(i).getDayOfWeek().toString());
				writer.writeEndElement();
				writer.writeDTD("\n");

				writer.writeDTD("\t\t");
				writer.writeStartElement("PublicHoliday");
				Boolean publicHoliday = list.get(i).isPublicHoliday();
				writer.writeCharacters(publicHoliday.toString());
				writer.writeEndElement();
				writer.writeDTD("\n");

				writer.writeDTD("\t\t");
				writer.writeStartElement("PersonalDayOff");
				Boolean personalDayOff = list.get(i).isPersonalDayOff();
				writer.writeCharacters(personalDayOff.toString());
				writer.writeEndElement();
				writer.writeDTD("\n");

				writer.writeDTD("\t\t");
				writer.writeStartElement("Description");
				if (list.get(i).getDescription() != null) {
					writer.writeCharacters(list.get(i).getDescription());
				} else {
					writer.writeCharacters("");
				}
				writer.writeEndElement();
				writer.writeDTD("\n");

				writer.writeDTD("\t");
				writer.writeEndElement();
				writer.writeDTD("\n");
			}

			writer.writeDTD("\n");
			writer.writeEndDocument();
			writer.flush();

		} catch (XMLStreamException | IOException ex) {
			throw new DAOException(ex);
		}

	}

	public Month chooseMonth(String month) {

		switch (month) {
		case "JANUARY":
			return Month.JANUARY;
		case "FEBRUARY":
			return Month.FEBRUARY;
		case "MARCH":
			return Month.MARCH;
		case "APRIL":
			return Month.APRIL;
		case "MAY":
			return Month.MAY;
		case "JUNE":
			return Month.JUNE;
		case "JULY":
			return Month.JULY;
		case "AUGUST":
			return Month.AUGUST;
		case "SEPTEMBER":
			return Month.SEPTEMBER;
		case "OCTOBER":
			return Month.OCTOBER;
		case "NOVEMBER":
			return Month.NOVEMBER;
		case "DECEMBER":
			return Month.DECEMBER;
		default:
			return null;
		}
	}

	public DayOfWeek chooseDayOfWeek(String day) {

		switch (day) {
		case "SUNDAY":
			return DayOfWeek.SUNDAY;
		case "MONDAY":
			return DayOfWeek.MONDAY;
		case "TUESDAY":
			return DayOfWeek.TUESDAY;
		case "WEDNESDAY":
			return DayOfWeek.WEDNESDAY;
		case "THURSDAY":
			return DayOfWeek.THURSDAY;
		case "FRIDAY":
			return DayOfWeek.FRIDAY;
		case "SATURDAY":
			return DayOfWeek.SATURDAY;
		default:
			return null;
		}

	}
}
