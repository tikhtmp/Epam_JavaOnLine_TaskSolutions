package by.epam_training.java_online.module6.task1_library.bean;

public abstract class Book implements Comparable<Book> {

	private int id;
	private String title;
	private String author;
	private int year;
	private boolean isAvailable;

	public Book() {
	}

	public Book(int id, String title, String author, int year, boolean isAvailable) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.year = year;
		this.isAvailable = isAvailable;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAuthor() {
		return author;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getYear() {
		return year;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (getClass() != obj.getClass())
			return false;

		Book other = (Book) obj;

		if (id != other.id)
			return false;

		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;

		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;

		if (year != other.year)
			return false;

		if (isAvailable != other.isAvailable)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = 1;
		final int prime = 31;
		result = result * prime + id;
		result = result * prime + ((title == null) ? 0 : title.hashCode());
		result = result * prime + ((author == null) ? 0 : author.hashCode());
		result = result * prime + year;
		result = result * prime + ((isAvailable == true) ? 1231 : 1237);
		return result;
	}

	@Override
	public String toString() {
		return getClass().getName() + " [id=" + id + ", title=" + title + ", author=" + author + ", year=" + year
				+ ", isAvailable=" + isAvailable + "]";
	}

	@Override
	public int compareTo(Book other) {
		return title.compareTo(other.title);
	}
}
