/*
Модуль 4. Простейшие классы и объекты. 
Задача 9.
Создать класс Book, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы
и метод toString(). Создать второй класс, агрегирующий массив типа Book, с подходящими конструкторами
и методами. Задать критерии выбора данных и вывести эти данные на консоль.
Book: id, название, автор(ы), издательство, год издания, количество страниц, цена, тип переплета.
Найти и вывести:
а) список книг заданного автора;
b) список книг, выпущенных заданным издательством;
c) список книг, выпущенных после заданного года.
*/

package by.epam_training.java_online.module4.simple_classes.task9_book.entity;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Book implements Comparable<Book> {

	private final int id;
	private static int bookCount = 0;
	private final String title;
	private final String author;
	private String publisher;
	private Calendar yearOfPublication;
	private int numberOfPages;
	private float price;
	private Cover cover;

	public Book() {
		id = ++bookCount;
		title = "";
		author = "";
		publisher = "";
		yearOfPublication = new GregorianCalendar(0, 0, 0);
		numberOfPages = 0;
		price = 0.0F;
		cover = Cover.PAPERBACK;
	}

	public Book(String name, String author, String publisher, Calendar yearOfPublication, int numberOfPages,
			float price, Cover cover) {
		this.id = ++bookCount;
		this.title = name;
		this.author = author;
		this.publisher = publisher;
		this.yearOfPublication = yearOfPublication;
		this.numberOfPages = numberOfPages;
		this.price = price;
		this.cover = cover;
	}

	public int getId() {
		return this.id;
	}

	public String getTitle() {
		return this.title;
	}

	public String getAuthor() {
		return this.author;
	}

	public String getPublisher() {
		return this.publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Calendar getYearOfPublication() {
		return this.yearOfPublication;
	}

	public void setYearOfPublication(Calendar yearOfPublication) {
		this.yearOfPublication = yearOfPublication;
	}

	public int getNumberOfPages() {
		return this.numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Cover getCover() {
		return this.cover;
	}

	public void setCover(Cover cover) {
		this.cover = cover;
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
		} else if (!title.contentEquals(other.title))
			return false;

		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.contentEquals(other.author))
			return false;

		if (publisher == null) {
			if (other.publisher != null)
				return false;
		} else if (!publisher.equals(other.publisher))
			return false;

		if (yearOfPublication == null) {
			if (other.yearOfPublication != null) {
				return false;
			} else if (!yearOfPublication.equals(other.yearOfPublication))
				return false;
		}

		if (numberOfPages != other.numberOfPages)
			return false;

		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;

		if (cover != other.cover)
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = result * prime + id;
		result = result * prime + ((title == null) ? 0 : title.hashCode());
		result = result * prime + ((author == null) ? 0 : author.hashCode());
		result = result * prime + ((publisher == null) ? 0 : publisher.hashCode());
		result = result * prime + ((yearOfPublication == null) ? 0 : yearOfPublication.hashCode());
		result = result * prime + numberOfPages;
		result = result * prime + Float.floatToIntBits(price);
		result = result * prime + ((cover == null) ? 0 : cover.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [" + "id=" + id + ", title=" + title + ", author=" + author + ", publisher="
				+ publisher + ", yearOfPublication=" + (yearOfPublication.get(Calendar.YEAR) + 1) + ", numberOfPages="
				+ numberOfPages + ", price=" + price + ", cover=" + cover + "]";
	}

	@Override
	public int compareTo(Book other) {
		return title.compareTo(other.title);
	}
}