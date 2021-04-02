/*
Модуль 4. Агрегация и композиция.
Задача 1.
Условие: Создать объет класса Текст, используя классы Предложение, Слово. Методы: дополнить текст, вывести на консоль текст,
заголовок текста.  
*/

package by.epam_training.java_online.module4.composition_and_aggregation.task1_text.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Text implements Comparable<Text>, Serializable {

	private static final long serialVersionUID = 1L;

	private Sentence title;
	private List<Sentence> content = new ArrayList<Sentence>();

	public Text() {
		title = null;
		content = null;
	}

	public Text(Sentence title, List<Sentence> content) {
		this.title = title;
		this.content = content;
	}

	public Sentence getTitle() {
		return title;
	}

	public void setTitle(Sentence title) {
		this.title = title;
	}

	public List<Sentence> getContent() {
		return content;
	}

	public void setContent(List<Sentence> content) {
		this.content = content;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		Text other = (Text) obj;

		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;

		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = result * prime + ((title == null) ? 0 : title.hashCode());
		result = result * prime + ((content == null) ? 0 : content.hashCode());
		return result;
	}

	@Override
	public String toString() {
		Class<Text> clazz = Text.class;
		return clazz.getSimpleName() + " [title=" + title + ", content=" + content + "]";
	}

	@Override
	public int compareTo(Text other) {
		return title.compareTo(other.title);
	}
}
