package by.epam_training.java_online.module6.task1_library.bean;

public abstract class User implements Comparable<User> {

	private int id;
	private String name;
	private String login;
	private String password;
	private String eMail;

	public User() {
	}

	public User(int id, String name, String login, String password, String eMail) {
		this.id = id;
		this.name = name;
		this.login = login;
		this.password = password;
		this.eMail = eMail;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (getClass() != obj.getClass())
			return false;

		User other = (User) obj;

		if (id != other.id)
			return false;

		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;

		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;

		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;

		if (eMail == null) {
			if (other.eMail != null)
				return false;
		} else if (!eMail.equals(other.eMail))
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = 1;
		final int prime = 31;
		result = result * prime + id;
		result = result * prime + ((name == null) ? 0 : name.hashCode());
		result = result * prime + ((login == null) ? 0 : login.hashCode());
		result = result * prime + ((password == null) ? 0 : password.hashCode());
		result = result * prime + ((eMail == null) ? 0 : eMail.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return getClass().getName() + " [id=" + id + ", name=" + name + ", login=" + login + ", password=" + password
				+ ", eMail=" + eMail + "]";
	}

	@Override
	public int compareTo(User other) {
		return name.compareTo(other.name);
	}
}
