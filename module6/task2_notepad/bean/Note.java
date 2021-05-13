package by.epam_training.java_online.module6.task2_notepad.bean;

import java.io.Serializable;

public class Note implements Serializable, Comparable<Note> {

	private static final long serialVersionUID = 1L;
	private Topic topic;
	private String creationDate;
	private String email;
	private String content;

	public Note() {
	}

	public Note(Topic topic, String creationDate, String email, String content) {
		this.topic = topic;
		this.creationDate = creationDate;
		this.email = email;
		this.content = content;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
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

		Note other = (Note) obj;

		if (topic != other.topic)
			return false;

		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;

		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
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
		int result = 1;
		final int prime = 31;
		result = result * prime + ((topic == null) ? 0 : topic.hashCode());
		result = result * prime + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = result * prime + ((email == null) ? 0 : email.hashCode());
		result = result * prime + ((content == null) ? 0 : content.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return getClass().getName() + " [topic=" + topic + ", creationDate=" + creationDate + ", email=" + email
				+ ", content=" + content + "]";
	}

	@Override
	public int compareTo(Note other) {
		return this.getTopic().compareTo(other.getTopic());
	}

}
