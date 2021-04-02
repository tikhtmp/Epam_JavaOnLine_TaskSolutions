package by.epam_training.java_online.module5.task5_sweet.bean;

abstract public class Sweet implements Comparable<Sweet> {

	private String description;

	public Sweet() {
	}

	public Sweet(String description) {
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

		if (obj == null)
			return false;

		if (getClass() != obj.getClass())
			return false;

		Sweet other = (Sweet) obj;

		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = 1;
		final int prime = 31;
		result = result * prime + ((description == null) ? 0 : description.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return getClass().getName() + " [description=" + description + "]";
	}

	@Override
	public int compareTo(Sweet other) {
		return description.compareTo(other.description);
	}
}
