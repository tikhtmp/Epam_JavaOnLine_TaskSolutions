package by.epam_training.java_online.module4.composition_and_aggregation.task3_state.entity;

import java.io.Serializable;

public class City implements Comparable<City>, Serializable {
	private static final long serialVersionUID = 1L;
	private String name;

	public City() {
		name = null;
	}

	public City(String name) {
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		City other = (City) obj;

		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = result * prime + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public String toString() {
		Class<City> clazz = City.class;
		return clazz.getSimpleName() + " [name=" + name + "]";
	}

	@Override
	public int compareTo(City other) {
		return name.compareTo(other.name);
	}
}
