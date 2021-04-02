package by.epam_training.java_online.module4.composition_and_aggregation.task2_car.entity;

import java.io.Serializable;

public class StockWheel implements Comparable<StockWheel>, Serializable {

	private static final long serialVersionUID = 1L;
	
	private String type;

	public StockWheel() {
		type = null;
	}

	public StockWheel(String type) {
		this.type = type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		StockWheel other = (StockWheel) obj;

		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!this.type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = result * prime + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [type=" + type + "]";
	}

	@Override
	public int compareTo(StockWheel other) {
		return type.compareTo(other.type);
	}
}