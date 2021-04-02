package by.epam_training.java_online.module4.simple_classes.task10_airline.view;

import java.util.List;
import by.epam_training.java_online.module4.simple_classes.task10_airline.entity.Airline;
import by.epam_training.java_online.module4.simple_classes.task10_airline.entity.Airport;

public class AirportView {

	public static void display(Airport airport) {

		List<Airline> lines = airport.getLines();
		display(lines);
	}

	public static void display(List<Airline> lines) {

		if (lines.size() > 0) {
			System.out.println("------------------------------------------------------------------------");
			System.out.printf("%7s | %12s | %16s |    %-6s | %14s\n", "Number:", "Destination:", "Time of departure:",
					"Day:", "Type of plane:");
			System.out.println("------------------------------------------------------------------------");

			for (Airline a : lines) {
				displayInfo(a);
			}

			System.out.println("------------------------------------------------------------------------\n");
		}
	}

	private static void displayInfo(Airline line) {
		System.out.printf("%03d %3s | %-11s  |        %02d:%02d       | %-9s | %-10s\n", line.getNumber(), ' ',
				line.getDestination(), line.getDepartureTime().get(11), line.getDepartureTime().get(12),
				line.getDayOfWeek(), line.getType());
	}
}
