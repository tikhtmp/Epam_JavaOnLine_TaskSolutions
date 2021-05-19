package by.epam_training.java_online.module6.task3_archive.dao;

public interface ClientDAO {

	String getClients() throws DAOException;

	String logIn (String login, String password) throws DAOException;
}
