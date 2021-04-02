package by.epam_training.java_online.module4.simple_classes.task10_airline.logic;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;

import by.epam_training.java_online.module4.simple_classes.task10_airline.entity.Airline;
import by.epam_training.java_online.module4.simple_classes.task10_airline.entity.Airport;

public class AirportLogic {
	
	public void sortAirlines(Airport airPort) {
		Collections.sort(airPort.getLines());
	}

	public List<Airline> findAirlines(Airport airport, String param)
			throws IllegalArgumentException, IllegalAccessException, SecurityException {

		List<Airline> result = new ArrayList<Airline>();
		List<Airline> lines = airport.getLines();

		for (Airline line : lines) {
			if (hasParameter(line, param))
				result.add(line);
		}

		if (result.size() <= 0) {
			System.out.println("Nothing has been found on request: \"" + param + "\"\n");
		} else {
			System.out.println("These flights have been found on request \"" + param + "\":");
		}

		return result;
	}

	public boolean hasParameter(Airline line, String param)
			throws IllegalArgumentException, IllegalAccessException, SecurityException {
		
		Field fields[] = line.getClass().getDeclaredFields();

		for (Field field : fields) {

			boolean isAccesiableFlag = true;

			if (!field.isAccessible()) {
				field.setAccessible(true);
				isAccesiableFlag = false;
			}

			if (field.get(line).toString().equalsIgnoreCase(param)) {
				field.setAccessible(isAccesiableFlag);
				return true;
			}

			field.setAccessible(isAccesiableFlag);
		}
		return false;
	}

	public List<Airline> findAirlines(Airport airport, String param, GregorianCalendar depTime)
			throws IllegalArgumentException, IllegalAccessException, SecurityException {
		
		List<Airline> lines = airport.getLines();
		List<Airline> result = new ArrayList<Airline>();
		int time = depTime.get(11) * 60 + depTime.get(12);

		for (Airline line : lines) {

			if (hasParameter(line, param)
					&& line.getDepartureTime().get(11) * 60 + line.getDepartureTime().get(12) > time)
				result.add(line);
		}

		if (result.size() <= 0) {
			System.out.format("%s %s %s %02d:%02d %s", "Nothing has been found on request: \"", param, "\" after ",
					depTime.get(11), depTime.get(12), "\n" );
		} else {
			System.out.format("%s%s %s %02d:%02d%S", "These flights have been found on request: \"", param, "after",
					depTime.get(11), depTime.get(12), "\"\n");
		}

		return result;
	}
}
