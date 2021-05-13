package by.epam_training.java_online.module6.task2_notepad.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Criteria implements Comparable<Criteria>, Serializable {

	private static final long serialVersionUID = 1L;
	private Map<String, String> criteries = new HashMap<String, String>();

	public Criteria() {
	}

	public Criteria(Map<String, String> criteries) {
		this.criteries = criteries;
	}

	public Map<String, String> getCriteries() {
		return criteries;
	}

	public void addCriteria(String key, String value) {
		criteries.put(key, value);
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (getClass() != obj.getClass())
			return false;

		Criteria other = (Criteria) obj;

		if (criteries == null) {
			if (other.criteries != null)
				return false;
		} else if (!criteries.equals(other.criteries)) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		int result = 1;
		final int prime = 31;
		result = result * prime + ((criteries == null) ? 0 : criteries.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return getClass().getName() + " [criteries=" + criteries + "]";
	}

	@Override
	public int compareTo(Criteria c) {
		return criteries.size() - c.criteries.size();
	}
}
