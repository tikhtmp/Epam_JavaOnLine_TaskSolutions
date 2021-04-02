package by.epam_training.java_online.module5.task4_cave_and_dragon.bean;

import java.io.Serializable;

import by.epam_training.java_online.module5.task4_cave_and_dragon.view.CaveAndDragonView;

public class Knight implements Serializable, Comparable<Knight> {

	private static final long serialVersionUID = 1L;
	private String name = "knight Knight";
	private boolean isAlive = true;

	public Knight() {
	}

	public Knight(String name, boolean alive) {
		this.name = name;
		this.isAlive = alive;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean alive) {
		this.isAlive = alive;
	}

	public void say(String message) {
		CaveAndDragonView.displayMessage(getName() + ": " + message);
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (getClass() != obj.getClass())
			return false;

		Knight other = (Knight) obj;

		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;

		if (isAlive != other.isAlive)
			return false;

		return true;
	}

	@Override
	public int hashCode() {

		int result = 1;
		final int prime = 31;
		result = result * prime + ((name == null) ? 0 : name.hashCode());
		result = result * prime + (isAlive ? 1231 : 1237);

		return result;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [name=" + name + ", alive=" + isAlive + "]";
	}

	@Override
	public int compareTo(Knight other) {
		return name.compareTo(other.name);
	}
}
