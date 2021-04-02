package by.epam_training.java_online.module4.composition_and_aggregation.task1_text.entity;

import java.io.Serializable;

public class Word implements Comparable<Word>, Serializable {

	private static final long serialVersionUID = 1L;
	private String word;

	public Word() {
		word = null;
	}

	public Word(String word) {
		super();
		this.word = word;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		Word other = (Word) obj;

		if (word == null) {

			if (other.word != null)
				return false;

		} else if (!word.equals(other.word))
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = result * prime + ((word == null) ? 0 : word.hashCode());
		return result;
	}

	@Override
	public String toString() {
		Class<Word> clazz = Word.class;
		return clazz.getSimpleName() + " [word=" + word + "]";
	}

	@Override
	public int compareTo(Word w) {
		return word.compareTo(w.word);
	}
}
