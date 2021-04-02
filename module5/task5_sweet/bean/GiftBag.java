package by.epam_training.java_online.module5.task5_sweet.bean;

import java.io.Serializable;
import java.util.List;

public class GiftBag implements Comparable<GiftBag>, Serializable {

	private static final long serialVersionUID = 1L;
	private Packaging packaging;
	private List<Sweet> sweets;	

	public GiftBag() {
	}

	public GiftBag(Packaging packaging, List<Sweet> sweets) {
		this.packaging = packaging;
		this.sweets = sweets;		
	}

	public void setSweets(List<Sweet> sweets) {
		this.sweets = sweets;
	}

	public List<Sweet> getSweets() {
		return this.sweets;
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

		GiftBag other = (GiftBag) obj;

		if (sweets == null) {
			if (other.sweets != null)
				return false;
		} else if (!sweets.equals(other.sweets))
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
		result = result * prime + ((sweets == null) ? 0 : sweets.hashCode());
		result = result * prime + ((packaging == null) ? 0 : packaging.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return getClass().getName() + " [sweets=" + sweets + ", packaging=" + packaging + "]";
	}

	@Override
	public int compareTo(GiftBag other) {
		return sweets.size() - other.sweets.size();
	}
}
