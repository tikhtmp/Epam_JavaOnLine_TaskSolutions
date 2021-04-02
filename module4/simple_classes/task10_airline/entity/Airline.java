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
package by.epam_training.java_online.module4.simple_classes.task10_airline.entity;

import java.util.GregorianCalendar;

public class Airline implements Comparable<Airline> {

	private String destination;
	private int number;
	private PlaneType type;
	private GregorianCalendar departureTime;
	private DayOfWeek day;

	public Airline() {
		destination = "";
		number = 0;
		type = PlaneType.JUMBOJET;
		departureTime = new GregorianCalendar(0, 0, 0, 0, 0);
		day = DayOfWeek.SUNDAY;
	}

	public Airline(String destination, int number, PlaneType type, GregorianCalendar departureTime, DayOfWeek day) {
		this.destination = destination;
		this.number = number;
		this.type = type;
		this.departureTime = departureTime;
		this.day = day;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDestination() {
		return destination;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	public void setType(PlaneType type) {
		this.type = type;
	}

	public PlaneType getType() {
		return type;
	}

	public void setDepartureTime(GregorianCalendar departureTime) {
		this.departureTime = departureTime;
	}

	public GregorianCalendar getDepartureTime() {
		return departureTime;
	}

	public void setDayOfWeek(DayOfWeek day) {
		this.day = day;
	}

	public DayOfWeek getDayOfWeek() {
		return day;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass()) {
			return false;
		}

		Airline other = (Airline) obj;

		if (destination == null) {
			if (other.destination != null)
				return false;
		} else if (destination.equals(other.destination))
			return false;

		if (number != other.number)
			return false;

		if (type != other.type)
			return false;

		if (departureTime == null) {
			if (other.departureTime != null)
				return false;
		} else if (departureTime.equals(other.departureTime))
			return false;

		if (day != other.day)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = 1;
		final int prime = 31;

		result = result * prime + ((destination == null) ? 0 : destination.hashCode());
		result = result * prime + number;
		result = result * prime + ((type == null) ? 0 : type.hashCode());
		result = result * prime + ((departureTime == null) ? 0 : departureTime.hashCode());
		result = result * prime + ((day == null) ? 0 : day.hashCode());

		return result;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [destination=" + destination + ", number=" + number + ", type=" + type
				+ ", departureTime=" + departureTime + ", day=" + day + "]";
	}

	@Override
	public int compareTo(Airline other) {
		return number - other.number;
	}
}
