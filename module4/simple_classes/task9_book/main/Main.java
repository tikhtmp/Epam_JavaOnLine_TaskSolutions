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

package by.epam_training.java_online.module4.simple_classes.task9_book.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;
import by.epam_training.java_online.module4.simple_classes.task9_book.entity.Book;
import by.epam_training.java_online.module4.simple_classes.task9_book.entity.BookShop;
import by.epam_training.java_online.module4.simple_classes.task9_book.entity.Cover;
import by.epam_training.java_online.module4.simple_classes.task9_book.logic.ShopLogic;
import by.epam_training.java_online.module4.simple_classes.task9_book.view.ShopView;

public class Main {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {

		Book book1 = new Book("No story", "O.Henry", "Genesis Publications", new GregorianCalendar(1905, 0, 0), 50,
				354.80f, Cover.PAPERBACK);
		Book book2 = new Book("High stand", "Innes Hammond", "Collins", new GregorianCalendar(1985, 0, 0), 336, 115.95f,
				Cover.JACKET);
		Book book3 = new Book("The Catcher in the Rye", "Salinger J. D.", "Little, Brown and Company",
				new GregorianCalendar(1951, 0, 0), 280, 310.40f, Cover.PAPERBACK);
		Book book4 = new Book("To Kill a Mockingbird", "Harper Lee Nelle", "J. B. Lippi, ncott & Co",
				new GregorianCalendar(1960, 0, 0), 381, 420.50f, Cover.HARDCOVER);
		Book book5 = new Book("Of Mice and Men", "Steinbeck John Ernst", "Pascal Covici",
				new GregorianCalendar(1937, 0, 0), 120, 355.25f, Cover.PAPERBACK);

		List<Book> books = new ArrayList<>(Arrays.asList(book1, book2, book3, book4, book5));
		BookShop antiquesShop = new BookShop("Antiques books", books);
		
		Book book6 = new Book("The Great Gatsby", "Francis Fitzgerald", "Charles Scribner's Sons",
				new GregorianCalendar(1925, 0, 0), 520, 310.90f, Cover.PAPERBACK);
		ShopView.display(antiquesShop);

		System.out.println("Removing book2");
		antiquesShop.removeBook(book2);
		ShopView.display(antiquesShop);

		System.out.println("Adding book6");
		antiquesShop.addBook(book6);
		ShopView.display(antiquesShop);

		System.out.println("Adding new books");
		antiquesShop.addBook(new Book("The Cop and the Anthem", "O.Henry", "Genesis Publications",
				new GregorianCalendar(1906, 0, 0), 48, 180.80f, Cover.PAPERBACK));
		antiquesShop.addBook(new Book("The Gift of the Magi", "O.Henry", "Pascal Covici",
				new GregorianCalendar(1906, 0, 0), 77, 220.00f, Cover.PAPERBACK));
		antiquesShop.addBook(new Book("The Trimmed Lamp", "O.Henry", "Pascal Covici", new GregorianCalendar(1906, 0, 0),
				50, 145.40f, Cover.PAPERBACK));
		ShopView.display(books);

		System.out.println("Books sorted by title.");
		ShopLogic.sortBooks(antiquesShop);
		ShopView.display(antiquesShop);

		ShopLogic processShop = new ShopLogic();

		String author = "O.Henry";
		System.out.println("The list of books by " + author + " (version1).");
		ShopView.display(ShopLogic.filterList(antiquesShop, author));
		
		System.out.println("The list of books by " + author + " (version2).");
		List<Book> books2 = processShop.chooseBooks(antiquesShop, author);
		ShopView.display(books2);

		String publisher = "Pascal Covici";
		System.out.println("Books published by " + publisher + " (version1).");
		ShopView.display(ShopLogic.filterList(antiquesShop, publisher));
		
		System.out.println("Books published by " + publisher + " (version2).");
		List<Book> books3 = processShop.chooseBooks(antiquesShop, publisher);
		ShopView.display(books3);


		int year = 1920;
		System.out.println("Books published after " + year);
		ShopView.display(ShopLogic.filterList(antiquesShop, year));

		
		
		
		String wrongAuthor = "O.Hnry";
		System.out.println("The list of books by " + wrongAuthor + " (wrong author version1).");
		ShopView.display(ShopLogic.filterList(antiquesShop, wrongAuthor));
		
		System.out.println("The list of books  by " + wrongAuthor + " (wrong author version2).");
		List<Book> books4 = processShop.chooseBooks(antiquesShop, wrongAuthor);
		ShopView.display(books4);
		
		String wrongPublisher = "Pascal Covii";
		System.out.println("Books published by " + wrongPublisher + " (wrong publisher version1).");
		ShopView.display(ShopLogic.filterList(antiquesShop, wrongPublisher));
		
		System.out.println("Books published by " + wrongPublisher + " (wrong publisher version2).");
		List<Book> books5 = processShop.chooseBooks(antiquesShop, wrongPublisher);
		ShopView.display(books5);




	}
}
