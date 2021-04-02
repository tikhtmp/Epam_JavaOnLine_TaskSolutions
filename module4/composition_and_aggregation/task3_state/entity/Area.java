package by.epam_training.java_online.module4.composition_and_aggregation.task3_state.entity;

import java.io.Serializable;
import java.util.List;

public class Area implements Comparable<Area>, Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private List<City> cities;

	public Area() {
		name = null;
		cities = null;
	}

	public Area(String name, List<City> cities) {
		this.name = name;
		this.cities = cities;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	public List<City> getCities() {
		return cities;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		Area other = (Area) obj;

		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;

		if (cities == null) {
			if (other.cities != null)
				return true;
		} else if (!cities.equals(other.cities))
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = result * prime + ((name == null) ? 0 : name.hashCode());
		result = result * prime + ((cities == null) ? 0 : cities.hashCode());
		return result;
	}

	@Override
	public String toString() {
		Class<Area> clazz = Area.class;
		return clazz.getSimpleName() + " [name=" + name + ", cities=" + cities + "]";
	}

	@Override
	public int compareTo(Area other) {
		return name.compareTo(other.name);
	}
}
