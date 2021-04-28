package by.epam_training.java_online.module6.task1_library.dao;

import by.epam_training.java_online.module6.task1_library.bean.Book;

public interface BookDAO {

	void addBook(Book book) throws DAOException;

	void removeBook(int id) throws DAOException;

	void editBook(int id, String newTitle, String newAuthor, int newYear, boolean isAvailable) throws DAOException;

}
