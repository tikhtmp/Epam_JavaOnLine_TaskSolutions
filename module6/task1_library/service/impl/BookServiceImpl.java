package by.epam_training.java_online.module6.task1_library.service.impl;

import by.epam_training.java_online.module6.task1_library.bean.Book;
import by.epam_training.java_online.module6.task1_library.bean.EBook;
import by.epam_training.java_online.module6.task1_library.bean.PrintedBook;
import by.epam_training.java_online.module6.task1_library.dao.DAOException;
import by.epam_training.java_online.module6.task1_library.dao.DaoProvider;
import by.epam_training.java_online.module6.task1_library.dao.impl.BookDAOImpl;
import by.epam_training.java_online.module6.task1_library.service.BookService;
import by.epam_training.java_online.module6.task1_library.service.ServiceException;
import by.epam_training.java_online.module6.task1_library.service.util.IdGenerator;

public class BookServiceImpl implements BookService {

	BookDAOImpl bookDAOimpl = DaoProvider.getInstance().getBookDaoImpl();

	public boolean checkIfBookFileExists() throws ServiceException {
		try {
			return bookDAOimpl.checkIfBookFileExists();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void addBook(String title, String author, String year, String type, String prefferedID)
			throws ServiceException {

		Book newBook;
		int newID = Integer.parseInt(prefferedID);
		int id;

		try {
			id = IdGenerator.generateId(bookDAOimpl.getBooksFromFile(), newID);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

		if (type.equals("PrintedBook")) {
			newBook = new PrintedBook(id, title, author, Integer.parseInt(year), true);
		} else {
			newBook = new EBook(id, title, author, Integer.parseInt(year), true);
		}
		try {
			bookDAOimpl.addBook(newBook);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void removeBook(String id) throws ServiceException {

		try {
			bookDAOimpl.removeBook(Integer.parseInt(id));
		} catch (NumberFormatException | DAOException e) {
			throw new ServiceException(e);
		}
	}

	public String getBook(String id) throws ServiceException {

		try {
			return bookDAOimpl.getBook(id);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	public String getAllBooks() throws ServiceException {

		String books;
		try {
			books = bookDAOimpl.getStringDataFromBooksFile();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

		books = books.replaceAll("false", "unavailable");
		books = books.replaceAll("true", "");

		return books;
	}

	public String getBooks(String criteria) throws ServiceException {
		String books;

		try {
			books = bookDAOimpl.getBooks(criteria);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

		books = books.replaceAll("false", "unavailable");
		books = books.replaceAll("true", "");

		return books;
	}

}
