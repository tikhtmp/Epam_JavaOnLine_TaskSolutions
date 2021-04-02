package by.epam_training.java_online.module4.simple_classes.task9_book.entity;

import java.util.List;

public class BookShop implements Comparable<BookShop> {

	private String name;
	private List<Book> books;

	public BookShop() {
		name = "";
		books = null;
	}

	public BookShop(String name, List<Book> books) {
		this.name = name;
		this.books = books;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void addBook(Book book) {
		books.add(book);
	}

	public void removeBook(Book book) {
		books.remove(book);
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;

		BookShop other = (BookShop) obj;

		if (name == null) {
			if (other.name != null) {
				return false;
			} else if (!name.equals(other.name))
				return false;
		}

		if (books == null) {
			if (other.books != null)
				return false;
		} else if (!books.equals(other.books))
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = result * prime + ((name == null) ? 0 : name.hashCode());
		result = result * prime + ((books == null) ? 0 : books.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [name=" + name + ", available items=" + books.size() + "]";
	}

	@Override
	public int compareTo(BookShop other) {
		return name.compareTo(other.getName());
	}
}
