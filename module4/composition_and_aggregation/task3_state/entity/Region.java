package by.epam_training.java_online.module4.composition_and_aggregation.task3_state.entity;

public class Region implements Comparable<Region> {
	private String name;
	private City mainCity;

	public Region() {
		name = null;
		mainCity = null;
	}

	public Region(String name, City mainCity) {
		this.name = name;
		this.mainCity = mainCity;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setMainCity(City mainCity) {
		this.mainCity = mainCity;
	}

	public City getMainCity() {
		return mainCity;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		Region other = (Region) obj;

		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;

		if (mainCity == null) {
			if (other.mainCity != null)
				return false;
		} else if (!mainCity.equals(other.mainCity))
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = result * prime + ((name == null) ? 0 : name.hashCode());
		result = result * prime + ((mainCity == null) ? 0 : mainCity.hashCode());
		return result;
	}

	@Override
	public String toString() {
		Class<City> clazz = City.class;
		return clazz.getSimpleName() + " [name=" + name + ", mainCity=" + mainCity + "]";
	}

	@Override
	public int compareTo(Region other) {
		return name.compareTo(other.name);
	}
}
