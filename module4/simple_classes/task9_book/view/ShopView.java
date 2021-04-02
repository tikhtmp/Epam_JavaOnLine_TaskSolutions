package by.epam_training.java_online.module4.simple_classes.task9_book.view;

import java.util.Calendar;
import java.util.List;

import by.epam_training.java_online.module4.simple_classes.task9_book.entity.Book;
import by.epam_training.java_online.module4.simple_classes.task9_book.entity.BookShop;

public class ShopView {

	public static void display(Book book) {
		System.out.format(
				"%-3s %05d | %-5s %-24s | %-7s %-20s | %-10s %-25s | %-20s %4d | %-16s %4d | %-6s %6.2f | %-6s %9s\n",
				"id:", book.getId(), "title:", "\"" + book.getTitle() + "\"", "author:", book.getAuthor(), "publisher:",
				book.getPublisher(), "Year of publication:", (book.getYearOfPublication().get(Calendar.YEAR) + 1),
				"Number of pages:", book.getNumberOfPages(), "price:", book.getPrice(), "cover:", book.getCover());
	}

	public static void display(List<Book> books) {

		if (books.size() > 0)
			System.out.println("The list of available books:");

		for (Book b : books) {
			display(b);
		}
		System.out.println();
	}

	public static void display(BookShop shop) {

		List<Book> books = shop.getBooks();

		if (books.size() > 0)
			System.out.println("The list of available books:");

		for (Book b : books) {
			display(b);
		}

		System.out.println();
	}
}
