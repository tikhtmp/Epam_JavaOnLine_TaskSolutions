package by.epam_training.java_online.module6.task1_library.bean;

import java.io.Serializable;
import java.util.List;

public class Account implements Comparable<Account>, Serializable {

	private static final long serialVersionUID = 1L;
	private User user;
	private List<Book> books;

	public Account() {
	}

	public Account(User user, List<Book> books) {
		this.user = user;
		this.books = books;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (getClass() != obj.getClass())
			return false;

		Account other = (Account) obj;

		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;

		if (books == null) {
			if (other.books != null)
				return false;
		} else if (!books.equals(other.books))
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = 1;
		final int prime = 31;
		result = result * prime + ((user == null) ? 0 : user.hashCode());
		result = result * prime + ((books == null) ? 0 : books.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [user=" + user + ", books=" + books + "]";
	}

	@Override
	public int compareTo(Account other) {
		return user.getName().compareTo(other.user.getName());
	}
}