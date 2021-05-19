package by.epam_training.java_online.module6.task3_archive.bean;

import java.io.Serializable;

public class Student implements Comparable<Student>, Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	private String name;

	public Student() {
	}

	public Student(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

		Student other = (Student) obj;

		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;

		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = 1;
		final int prime = 31;
		result = result * prime + ((id == null) ? 0 : id.hashCode());
		result = result * prime + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return getClass().getName() + " [id=" + id + ", name=" + name + "]";
	}

	@Override
	public int compareTo(Student s) {
		return name.compareTo(s.name);
	}

}
