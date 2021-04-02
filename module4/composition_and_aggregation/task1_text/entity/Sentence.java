package by.epam_training.java_online.module4.composition_and_aggregation.task1_text.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Sentence implements Comparable<Sentence>, Serializable {

	private static final long serialVersionUID = 1L;

	private List<Word> words = new ArrayList<Word>();

	public Sentence() {
		words = null;
	}

	public Sentence(List<Word> words) {
		this.words = words;
	}

	public List<Word> getSentence() {
		return words;
	}

	public void setSentence(List<Word> words) {
		this.words = words;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		Sentence other = (Sentence) obj;

		if (words == null)
			if (other.words != null) {
				return false;
			} else if (!words.equals(other.words))
				return false;

		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = result * prime + ((words == null) ? 0 : words.hashCode());
		return result;
	}

	@Override
	public String toString() {
		Class<Sentence> clazz = Sentence.class;
		return clazz.getSimpleName() + " [words=" + words + "]";
	}

	@Override
	public int compareTo(Sentence other) {

		if (words.size() > other.words.size())
			return 1;

		if (words.size() < other.words.size())
			return -1;

		return 0;
	}
}
