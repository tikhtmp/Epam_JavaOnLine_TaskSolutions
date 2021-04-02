package by.epam_training.java_online.module5.task5_bouquet.bean;

import java.io.Serializable;

public class Basket extends Packaging implements Serializable {

	private static final long serialVersionUID = 1L;
	private String description;

	public Basket() {
	}

	public Basket(String name, String description) {
		super(name);
		this.description = description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;

		if (!super.equals(obj))
			return false;

		if (getClass() != obj.getClass())
			return false;

		Basket other = (Basket) obj;

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
		return super.toString() + ", description=" + description + "]";
	}
}
