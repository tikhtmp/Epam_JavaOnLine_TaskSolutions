package by.epam_training.java_online.module5.task4_cave_and_dragon.bean;

public abstract class Treasure implements Comparable<Treasure> {

	private int value;
	private final int inventaryNumber;

	public Treasure() {
		inventaryNumber = 0;
	}

	public Treasure(int value, int inventaryNumber) {
		this.value = value;
		this.inventaryNumber = inventaryNumber;
	}

	public int getInventaryNumber() {
		return inventaryNumber;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public String getTreasureInfo() {
		return String.format("%03d | %-13s | %-4s | ", getInventaryNumber(), getClass().getSimpleName(),
				Integer.toString(value));
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [value=" + value + ", inventaryNumber=" + inventaryNumber + ", ";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		Treasure other = (Treasure) obj;

		if (value != other.value)
			return false;
		if (inventaryNumber != other.inventaryNumber)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = result * prime + value;
		result = result * prime + inventaryNumber;
		return result;
	}

	@Override
	public int compareTo(Treasure other) {
		return this.value - other.value;

	}
}
