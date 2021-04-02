/*
Модуль 4. Простейшие классы и объекты. 
Задача 4.
Создайте класс Train, содержащий поля: название пункта назначения, номер поезда, время отправления.
Создайте данные в массиве из пяти элементов типа Train, добавьте возможность сортировки элементов массива по
номерам поездов. Добавьте возможность вывода информации о поезде, номер которого введен пользователем. 
Добавьте возможность сортировки массива по пункту назначения, причем поезда с одинаковыми пунктами
назначения должны быть упорядочены по времени отправления.
 */

package by.epam_training.java_online.module4.simple_classes.task4_train.entity;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Train implements Comparable<Train> {
	private String destination;
	private int number;
	private Calendar departureTime;

	public Train() {
		destination = "";
		number = 0;
		departureTime = new GregorianCalendar(0, 0, 0, 0, 0);
	}

	public Train(String destination, int number, Calendar departureTime) {
		this.destination = destination;
		this.number = number;
		this.departureTime = departureTime;
	}

	public String getDestination() {
		return this.destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getNumber() {
		return this.number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Calendar getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Calendar departureTime) {
		this.departureTime = departureTime;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj == null)
			return false;

		if (this == obj)
			return true;

		if (getClass() != obj.getClass())
			return false;

		Train other = (Train) obj;

		if (destination == null) {
			if (other.destination != null) {
				return false;
			} else if (!destination.equals(other.destination))
				return false;
		}

		if (number != other.number)
			return false;

		if (departureTime == null) {
			if (other.departureTime != null)
				return false;
		} else if (!departureTime.equals(other.departureTime))
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((destination == null) ? 0 : destination.hashCode());
		result = prime * result + ((departureTime == null) ? 0 : departureTime.hashCode());
		result = prime * result + number;
		return result;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [number=" + number + ", departureTime=" + departureTime.get(11) + ":"
				+ departureTime.get(12) + ", destination=" + destination + "]";
	}

	@Override
	public int compareTo(Train train) {
		return destination.compareTo(train.destination);
	}
}