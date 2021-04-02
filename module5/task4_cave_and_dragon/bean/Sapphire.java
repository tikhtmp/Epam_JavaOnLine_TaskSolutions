package by.epam_training.java_online.module5.task4_cave_and_dragon.bean;

import java.io.Serializable;

public class Sapphire extends Treasure implements Serializable {

	private static final long serialVersionUID = 1L;
	private String description;

	public Sapphire() {
		super();
		description = null;
	}

	public Sapphire(int value, int inventaryNumber, String description) {
		super(value, inventaryNumber);
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void getDescription(String description) {
		this.description = description;
	}

	@Override
	public String getTreasureInfo() {
		return super.getTreasureInfo() + description;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;

		if (!super.equals(obj))
			return false;

		if (getClass() != obj.getClass())
			return false;

		Sapphire other = (Sapphire) obj;

		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		final int prime = 31;
		result = result * prime + ((description == null) ? 0 : description.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return super.toString() + "description=" + description + "]";
	}
}
