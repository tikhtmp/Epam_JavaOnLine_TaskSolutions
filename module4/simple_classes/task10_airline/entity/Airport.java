package by.epam_training.java_online.module4.simple_classes.task10_airline.entity;

import java.util.List;

public class Airport implements Comparable<Airport> {
	private String name;
	private List<Airline> lines;

	public Airport() {
		name = "";
		lines = null;
	}

	public Airport(String name, List<Airline> lines) {
		this.name = name;
		this.lines = lines;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Airline> getLines() {
		return lines;
	}

	public void setLines(List<Airline> lines) {
		this.lines = lines;
	}

	public void addAirline(Airline line) {
		lines.add(line);
	}

	public void deleteAirline(Airline line) {
		lines.remove(line);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = result * prime + ((name == null) ? 0 : name.hashCode());
		result = result * prime + ((lines == null) ? 0 : lines.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		Airport other = (Airport) obj;

		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;

		if (lines == null) {
			if (other.lines != null)
				return false;
		} else if (!lines.equals(other.lines))
			return false;

		return true;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [name=" + name + ", lines=" + lines + "]";
	}

	@Override
	public int compareTo(Airport other) {
		return name.compareTo(other.name);
	}
}
