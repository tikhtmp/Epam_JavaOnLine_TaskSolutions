package by.epam_training.java_online.module5.task4_cave_and_dragon.bean;

import java.io.Serializable;
import java.util.List;

import by.epam_training.java_online.module5.task4_cave_and_dragon.service.impl.CaveAndDragonServiceImpl;

public class Cave implements Serializable, Comparable<Cave> {

	private static final long serialVersionUID = 1L;
	private List<Treasure> treasures;
	private Dragon dragon;

	public Cave() {
	}

	public Cave(List<Treasure> treasures, Dragon dragon) {
		this.treasures = treasures;
		this.dragon = dragon;
	}

	public List<Treasure> getTreasures() {
		return treasures;
	}

	public void setTreasures(List<Treasure> treasures) {
		this.treasures = treasures;
	}

	public Dragon getDragon() {
		return dragon;
	}

	public void setDragon(Dragon dragon) {
		this.dragon = dragon;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (getClass() != obj.getClass())
			return false;

		Cave other = (Cave) obj;

		if (this.treasures == null) {
			if (other.treasures != null)
				return false;
		} else if (!treasures.equals(other.treasures))
			return false;

		if (this.dragon == null) {
			if (other.dragon != null)
				return false;
		} else if (!dragon.equals(other.dragon))
			return false;

		return true;
	}

	@Override
	public int hashCode() {

		int result = 1;
		final int prime = 31;
		result = result * prime + ((treasures == null) ? 0 : treasures.hashCode());
		result = result * prime + ((dragon == null) ? 0 : dragon.hashCode());

		return result;
	}

	@Override
	public int compareTo(Cave other) {

		int totalValue = CaveAndDragonServiceImpl.calculateTotallValue(getTreasures());
		int otherTotalValue = CaveAndDragonServiceImpl.calculateTotallValue(other.getTreasures());

		if (totalValue > otherTotalValue)
			return 1;

		if (totalValue < otherTotalValue)
			return -1;

		return 0;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [treasures=" + treasures + ", dragon=" + dragon + "]";
	}
}
