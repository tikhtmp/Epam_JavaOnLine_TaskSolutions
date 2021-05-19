package by.epam_training.java_online.module6.task3_archive.bean;

import java.io.Serializable;

public class Client implements Comparable<Client>, Serializable {

	private static final long serialVersionUID = 1L;
	private String login;
	private String password;
	private boolean isAdmin;

	public Client() {
	}

	public Client(String login, String password, boolean isAdmin) {
		this.login = login;
		this.password = password;
		this.isAdmin = isAdmin;
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

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (getClass() != obj.getClass())
			return false;

		Client other = (Client) obj;

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

		if (isAdmin != other.isAdmin)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = 1;
		final int prime = 31;
		result = result * prime + ((login == null) ? 0 : login.hashCode());
		result = result * prime + ((password == null) ? 0 : password.hashCode());
		result = result * prime + (isAdmin ? 1231 : 1237);
		return result;
	}

	@Override
	public String toString() {
		return getClass().getName() + " [login=" + login + ", password=" + password + ", isAdmin=" + isAdmin + "]";
	}

	@Override
	public int compareTo(Client c) {
		return c.login.compareTo(c.login);
	}

}
