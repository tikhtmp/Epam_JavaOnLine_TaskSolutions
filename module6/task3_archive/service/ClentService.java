package by.epam_training.java_online.module6.task3_archive.service;

public interface ClentService {

	String getClients() throws ServiceException;

	String logIn(String login, String password) throws ServiceException;

}
