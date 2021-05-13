package by.epam_training.java_online.module6.task2_notepad.service;

public interface Service {

	String getNotes() throws ServiceException;

	void saveNotes(String notes) throws ServiceException;

	String findNotes(String criteria) throws ServiceException;

}
