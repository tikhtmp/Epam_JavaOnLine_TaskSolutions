package by.epam_training.java_online.module5.task5_bouquet.bean;

import java.io.Serializable;
import java.util.List;

public class Bouquet implements Comparable<Bouquet>, Serializable {

	private static final long serialVersionUID = 1L;
	private List<Flower> flowers;
	private Packaging packaging;

	public Bouquet() {
	}

	public Bouquet(Packaging packaging, List<Flower> flowers) {
		this.packaging = packaging;
		this.flowers = flowers;		
	}

	public void setFlowers(List<Flower> flowers) {
		this.flowers = flowers;
	}

	public List<Flower> getFlowers() {
		return this.flowers;
	}

	public void setPackaging(Packaging packaging) {
		this.packaging = packaging;
	}

	public Packaging getPackaging() {
		return packaging;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (getClass() != obj.getClass())
			return false;

		Bouquet other = (Bouquet) obj;

		if (flowers == null) {
			if (other.flowers != null)
				return false;
		} else if (!flowers.equals(other.flowers))
			return false;

		if (packaging == null) {
			if (other.packaging != null)
				return false;
		} else if (!packaging.equals(other.packaging))
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = 1;
		final int prime = 31;
		result = result * prime + ((flowers == null) ? 0 : flowers.hashCode());
		result = result * prime + ((packaging == null) ? 0 : packaging.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [flowers=" + flowers + ", packaging=" + packaging + "]";
	}

	@Override
	public int compareTo(Bouquet other) {
		return flowers.size() - other.flowers.size();
	}

}
