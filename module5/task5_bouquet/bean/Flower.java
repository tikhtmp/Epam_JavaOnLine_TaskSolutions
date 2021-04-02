package by.epam_training.java_online.module5.task5_bouquet.bean;

abstract public class Flower implements Comparable<Flower> {

	private String color;

	public Flower() {
	}

	public Flower(String name) {
		this.color = name;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		Flower other = (Flower) obj;
		
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		
		return true;
	}
	
	@Override
	public int hashCode() {
		int result = 1;
		final int prime = 31;
		result = result * prime + ((color == null) ? 0 : color.hashCode());		
		return result;
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + " [color=" + color;
	}
	
	@Override
	public int compareTo(Flower other) {
		return color.compareTo(other.color);
	}
	
}



















