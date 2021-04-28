package by.epam_training.java_online.module6.task1_library.dao.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import by.epam_training.java_online.module6.task1_library.bean.Book;
import by.epam_training.java_online.module6.task1_library.bean.EBook;
import by.epam_training.java_online.module6.task1_library.bean.PrintedBook;
import by.epam_training.java_online.module6.task1_library.dao.BookDAO;
import by.epam_training.java_online.module6.task1_library.dao.DAOException;

public class BookDAOImpl implements BookDAO {

	private static final String BOOKFILE_LOCATION = "books.txt";
	private static final File BOOK_SOURCE = new File(UserDAOImpl.getLIBRARY_LOCATION() + BOOKFILE_LOCATION);

	public String getBooks(String criteria) throws DAOException {

		String[] books = getStringDataFromBooksFile().split("\\n");
		StringBuilder result = new StringBuilder();

		String[] searchBookDetails = criteria.split("\\|");
		String searchBookAuthor = "";
		String searchBookTitle = "";
		String searchBookFromYear = "";
		String searchBookToYear = "";
		String searchBookType = "";

		if (searchBookDetails[0].split("=").length > 1) {
			searchBookAuthor = searchBookDetails[0].split("=")[1].trim();
		}

		if (searchBookDetails[1].split("=").length > 1) {
			searchBookTitle = searchBookDetails[1].split("=")[1].trim();
		}

		if (searchBookDetails[2].split("=").length > 1) {
			searchBookFromYear = searchBookDetails[2].split("=")[1].trim();
		}

		if (searchBookDetails[3].split("=").length > 1) {
			searchBookToYear = searchBookDetails[3].split("=")[1].trim();
		}

		if (searchBookDetails[4].split("=").length > 1) {
			searchBookType = searchBookDetails[4].split("=")[1].trim();
		}

		for (int i = 0; i < books.length; i++) {

			String[] currentBook = books[i].split("\\|");

			if (currentBook[2].contains(searchBookAuthor) && currentBook[1].contains(searchBookTitle)
					&& currentBook[4].trim().contains(searchBookType)) {

				int yearOfPublication = Integer.parseInt(currentBook[3].trim());
				int yearFrom = Integer.parseInt(searchBookFromYear);
				int yearTo = Integer.parseInt(searchBookToYear);

				if (yearOfPublication >= yearFrom && yearOfPublication <= yearTo) {
					result.append(books[i] + "\n");
				}
			}
		}

		if (result.length() < 1) {
			result.append("No such books in the library...\n");
		}

		return result.toString();
	}

	public boolean checkIfBookFileExists() {

		if (!BOOK_SOURCE.exists()) {
			new File(UserDAOImpl.getLIBRARY_LOCATION() + BOOKFILE_LOCATION);
			return false;
		}

		return true;
	}

	@Override
	public void addBook(Book newBook) throws DAOException {

		try (FileWriter writer = new FileWriter(BOOK_SOURCE, true)) {

			String line = String.format("%03d | %-25s | %-25s | %-4s | %-11s | %s\n", newBook.getId(),
					newBook.getTitle(), newBook.getAuthor(), newBook.getYear(), newBook.getClass().getSimpleName(),
					newBook.isAvailable());

			writer.write(line);

		} catch (IOException e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void removeBook(int id) throws DAOException {

		List<Book> books = getBooksFromFile();

		for (int i = 0; i < books.size(); i++) {

			Book currentBook = books.get(i);

			if (currentBook.getId() == id && currentBook.isAvailable()) { // книгу можно удалить только если она
																			// не на руках
				books.remove(i);
				break;
			}
		}

		saveBookDataFile(books);
	}

	@Override
	public void editBook(int id, String newTitle, String newAuthor, int newYear, boolean isAvailable)
			throws DAOException {

		List<Book> books = getBooksFromFile();

		for (Book b : books) {

			if (b.getId() == id) {
				b.setTitle(newTitle);
				b.setAuthor(newAuthor);
				b.setYear(newYear);
				b.setAvailable(isAvailable);
				break;
			}
		}

		saveBookDataFile(books);
	}

	public String getBook(String id) throws DAOException {
		String[] books = getStringDataFromBooksFile().split("\\n");

		String book = null;
		int currentId = 0;

		for (int i = 0; i < books.length; i++) {

			currentId = Integer.parseInt(books[i].split("\\|")[0].trim());

			if (currentId == Integer.parseInt(id)) {
				book = books[i];
				break;
			}
		}

		return book;
	}

	public String getStringDataFromBooksFile() throws DAOException {

		StringBuilder books = new StringBuilder();
		String line = "";

		try (BufferedReader reader = new BufferedReader(new FileReader(BOOK_SOURCE))) {

			while ((line = reader.readLine()) != null) {
				books.append(line).append("\n");
			}

		} catch (FileNotFoundException e) {
			throw new DAOException(e);
		} catch (IOException e1) {
			throw new DAOException(e1);
		}

		return books.toString();
	}

	public List<Book> getBooksFromFile() throws DAOException {

		String line;
		int id;
		String title;
		String author;
		int year;
		String type;
		boolean isAvailable;
		List<Book> result = new ArrayList<Book>();

		try (BufferedReader reader = new BufferedReader(new FileReader(BOOK_SOURCE))) {

			while ((line = reader.readLine()) != null) {

				String[] data = line.split("\\|");
				id = Integer.parseInt(data[0].trim());
				title = data[1].trim();
				author = data[2].trim();
				year = Integer.parseInt(data[3].trim());
				type = data[4].trim();
				isAvailable = Boolean.parseBoolean(data[5].trim());

				if (type.equals("PrintedBook")) {
					result.add(new PrintedBook(id, title, author, year, isAvailable));
				}

				if (type.equals("EBook")) {
					result.add(new EBook(id, title, author, year, isAvailable));
				}
			}
		} catch (FileNotFoundException e) {
			throw new DAOException(e);
		} catch (IOException e1) {
			throw new DAOException(e1);
		}

		return result;
	}

	public void saveBookDataFile(List<Book> books) throws DAOException {

		String line;

		try (FileWriter writer = new FileWriter(BOOK_SOURCE, false)) {

			for (Book book : books) {

				line = String.format("%03d | %-25s | %-25s | %-4s | %-11s | %s\n", book.getId(), book.getTitle(),
						book.getAuthor(), book.getYear(), book.getClass().getSimpleName(), book.isAvailable());

				writer.write(line);
			}

		} catch (IOException e) {
			throw new DAOException(e);
		}
	}
}
