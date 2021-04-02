package by.epam_training.java_online.module5.task4_cave_and_dragon.bean;

import java.io.Serializable;

public class SilverCoin extends Treasure implements Serializable {

	private static final long serialVersionUID = 1L;
	private String description;

	public SilverCoin() {
		super();
		description = null;
	}

	public SilverCoin(int value, int inventaryNumber, String description) {
		super(value, inventaryNumber);
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
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

		SilverCoin other = (SilverCoin) obj;

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
