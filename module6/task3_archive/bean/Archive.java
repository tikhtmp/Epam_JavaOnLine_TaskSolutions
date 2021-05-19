package by.epam_training.java_online.module6.task3_archive.bean;

import java.io.Serializable;
import java.util.List;

public class Archive implements Comparable<Archive>, Serializable {

	private static final long serialVersionUID = 1L;
	private String source;
	private List<Student> students;

	public Archive() {
	}

	public Archive(String id, List<Student> students) {
		this.source = id;
		this.students = students;
	}

	public String getId() {
		return source;
	}

	public void setId(String id) {
		this.source = id;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(String name, List<Student> students) {
		this.students = students;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;

		if (obj == null) {
			return false;
		}

		if (getClass() != obj.getClass())
			return false;

		Archive other = (Archive) obj;

		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;

		if (students == null) {
			if (other.students != null)
				return false;
		} else if (!students.equals(other.students))
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = 1;
		final int prime = 31;
		result = result * prime + ((source == null) ? 0 : source.hashCode());
		result = result * prime + ((students == null) ? 0 : students.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return getClass().getName() + " [source=" + source + ", students=" + students + "]";
	}

	@Override
	public int compareTo(Archive a) {
		return source.compareTo(a.source);
	}

}
