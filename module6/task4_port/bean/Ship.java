package by.epam_training.java_online.module6.task4_port.bean;

import java.io.Serializable;

public class Ship implements Comparable<Ship>, Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private int capacity;
	private int cargo;

	public Ship() {
	}

	public Ship(String name, int capacity, int cargo) {
		this.name = name;
		this.capacity = capacity;
		this.cargo = cargo;
	}

	public synchronized String getName() {
		return name;
	}

	public synchronized void setName(String name) {
		this.name = name;
	}

	public synchronized int getCapacity() {
		return capacity;
	}

	public synchronized void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public synchronized int getCargo() {
		return cargo;
	}

	public synchronized void setCargo(int cargo) {
		this.cargo = cargo;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (getClass() != obj.getClass())
			return false;

		Ship other = (Ship) obj;

		if (capacity != other.capacity)
			return false;

		if (cargo != other.cargo)
			return false;

		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = 1;
		final int prime = 31;
		result = result * prime + capacity;
		result = result * prime + cargo;
		result = result * prime + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return getClass().getName() + " [name=" + name + ", capacity=" + capacity + ", cargo=" + cargo + "]";
	}

	@Override
	public int compareTo(Ship other) {
		return capacity - other.capacity;
	}

}
