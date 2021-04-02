/*
Модуль 4. Простейшие классы и объекты. 
Задача 10.
Создать класс Airline, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы
и метод toString(). Создать второй класс, агрегирующий массив типа Airline, с подходящими конструкторами
и методами. Задать критерии выбора данных и вывести эти данные на консоль.
Airline: пункт назначения, номер рейса, тип самолета, время вылета, дни недели.
Найти и вывести:
а) список рейсов для заданного пункта назначения;
b) список рейсов для заданного дня недели;
c) список рейсов для заданного дня недели, время вылета для которых больше заданного.
*/
package by.epam_training.java_online.module4.simple_classes.task10_airline.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;

import by.epam_training.java_online.module4.simple_classes.task10_airline.entity.Airline;
import by.epam_training.java_online.module4.simple_classes.task10_airline.entity.Airport;
import by.epam_training.java_online.module4.simple_classes.task10_airline.entity.DayOfWeek;
import by.epam_training.java_online.module4.simple_classes.task10_airline.entity.PlaneType;
import by.epam_training.java_online.module4.simple_classes.task10_airline.logic.AirportLogic;
import by.epam_training.java_online.module4.simple_classes.task10_airline.view.AirportView;

public class Main {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, SecurityException {
		Airline line1 = new Airline("Gaaga", 15, PlaneType.JUMBOJET, new GregorianCalendar(0, 0, 0, 7, 25),
				DayOfWeek.TUESDAY);
		Airline line2 = new Airline("Gaaga", 7, PlaneType.JUMBOJET, new GregorianCalendar(0, 0, 0, 11, 40),
				DayOfWeek.SUNDAY);
		Airline line3 = new Airline("Abudabi", 17, PlaneType.LIGHTJET, new GregorianCalendar(0, 0, 0, 23, 5),
				DayOfWeek.MONDAY);
		Airline line4 = new Airline("Paris", 13, PlaneType.TURBOPROPS, new GregorianCalendar(0, 0, 0, 3, 10),
				DayOfWeek.WEDNESDAY);
		Airline line5 = new Airline("Gaaga", 88, PlaneType.MIDSIZEJET, new GregorianCalendar(0, 0, 0, 0, 45),
				DayOfWeek.THUSDAY);

		AirportLogic process = new AirportLogic();
		List<Airline> lines = new ArrayList<>(Arrays.asList(line1, line2, line3, line4, line5));
		Airport minskAirport = new Airport("Minsk", lines);
		System.out.println("All airlines:");
		AirportView.display(minskAirport);

		System.out.println("Airlines sorted by number:");
		process.sortAirlines(minskAirport);
		AirportView.display(minskAirport);

		Airline line6 = new Airline("London", 71, PlaneType.MIDSIZEJET, new GregorianCalendar(0, 0, 0, 4, 20),
				DayOfWeek.TUESDAY);
		Airline line7 = new Airline("New York", 14, PlaneType.JUMBOJET, new GregorianCalendar(0, 0, 0, 8, 55),
				DayOfWeek.TUESDAY);

		minskAirport.addAirline(line6);
		minskAirport.deleteAirline(line4);
		minskAirport.addAirline(line7);

		System.out.println("Airlines after adding and removing some lines:");
		AirportView.display(minskAirport);

		
		AirportView.display(process.findAirlines(minskAirport, "London"));
		AirportView.display(process.findAirlines(minskAirport, "tuesday")); 
		AirportView.display(process.findAirlines(minskAirport, "juMBOJET"));
		AirportView.display(process.findAirlines(minskAirport, "juMBOET"));
		
		AirportView.display(process.findAirlines(minskAirport, "tuesday", new GregorianCalendar(0,0,0,7,0))); 
	}

}
