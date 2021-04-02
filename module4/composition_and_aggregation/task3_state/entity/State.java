/*
Модуль 4. Агрегация и композиция.
Задача 3.
Условие: Создать объет класса Государство, используя классы Область, Район, Город. Методы: вывести на консоль
столицу, количество областей, площадь, областные центры.
*/

package by.epam_training.java_online.module4.composition_and_aggregation.task3_state.entity;

import java.io.Serializable;
import java.util.List;

public class State implements Comparable<State>, Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private City capital;
	private int area;
	private List<Region> regions;

	public State() {
		name = null;
		capital = null;
		area = 0;
		regions = null;
	}

	public State(String name, City capital, int area, List<Region> regions) {
		this.name = name;
		this.capital = capital;
		this.area = area;
		this.regions = regions;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setCapital(City capital) {
		this.capital = capital;
	}

	public City getCapital() {
		return capital;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public int getArea() {
		return area;
	}

	public void setRegions(List<Region> regions) {
		this.regions = regions;
	}

	public List<Region> getRegions() {
		return regions;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		State other = (State) obj;

		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;

		if (capital == null) {
			if (other.capital != null)
				return false;
		} else if (capital.equals(other.capital))
			return false;

		if (area != other.area)
			return false;

		if (regions == null) {
			if (other.regions != null)
				return false;
		} else if (regions.equals(other.regions))
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = result * prime + ((name == null) ? 0 : name.hashCode());
		result = result * prime + ((capital == null) ? 0 : capital.hashCode());
		result = result * prime + area;
		result = result * prime + ((regions == null) ? 0 : regions.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [name=" + name + ", capital=" + capital + ", area=" + area + ", regions="
				+ regions + "]";
	}

	@Override
	public int compareTo(State other) {
		return name.compareTo(other.name);
	}
}
