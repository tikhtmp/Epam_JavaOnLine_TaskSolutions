/*
Модуль 4. Агрегация и композиция.
Задача 5.
Условие: Туристические путевки. Сформировать набор предложений клиенту по выбору туристической путевки
различного типа (отдых, экскурсии, лечение, шопинг, круиз и т. д.) для оптимального выбора. Учитывать 
возможность выбора транспорта, питания и числа дней. Реализовать выбор и сортировку путевок.
*/
package by.epam_training.java_online.module4.composition_and_aggregation.task5_travel.entity;

import java.io.Serializable;

public class Trip implements Comparable<Trip>, Serializable {

	private static final long serialVersionUID = 1L;
	private String destination;
	private Type type;
	private int period;
	private Transport transport;
	private Feed feed;

	public Trip() {
		destination = null;
		type = null;
		period = 0;
		transport = null;
		feed = null;
	}

	public Trip(String destination, Type type, int period, Transport transport, Feed feed) {
		this.destination = destination;
		this.type = type;
		this.period = period;
		this.transport = transport;
		this.feed = feed;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public Transport getTransport() {
		return transport;
	}

	public void setTransport(Transport transport) {
		this.transport = transport;
	}

	public Feed getFeed() {
		return feed;
	}

	public void setFeed(Feed feed) {
		this.feed = feed;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		Trip other = (Trip) obj;

		if (destination == null) {
			if (other.destination != null)
				return false;
		} else if (!destination.equals(other.destination))
			return false;

		if (type != other.type)
			return false;

		if (period != other.period)
			return false;

		if (transport != other.transport)
			return false;

		if (feed != other.feed)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = result * prime + ((destination == null) ? 0 : destination.hashCode());
		result = result * prime + ((type == null) ? 0 : type.hashCode());
		result = result * prime + period;
		result = result * prime + ((transport == null) ? 0 : transport.hashCode());
		result = result * prime + ((feed == null) ? 0 : feed.hashCode());
		return result;
	}

	@Override
	public String toString() {
		Class<Trip> clazz = Trip.class;
		return clazz.getSimpleName() + " [destination=" + destination + ", type=" + type + ", period=" + period
				+ ", transport=" + transport + ", feed=" + feed + "]";
	}

	@Override
	public int compareTo(Trip other) {
		return destination.compareTo(other.destination);
	}
}
