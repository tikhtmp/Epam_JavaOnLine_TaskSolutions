package by.epam_training.java_online.module6.task1_library.service;

public interface BookService {

	public void addBook(String title, String author, String year, String type, String prefferedID) throws ServiceException;

	public void removeBook(String id) throws ServiceException;
}
