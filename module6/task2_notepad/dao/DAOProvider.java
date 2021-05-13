package by.epam_training.java_online.module6.task2_notepad.dao;

import by.epam_training.java_online.module6.task2_notepad.dao.impl.DAOImpl;

public class DAOProvider {

	private static final DAOProvider instance = new DAOProvider();
	private static DAOImpl daoImpl = new DAOImpl();

	private DAOProvider() {
	}

	public static DAOProvider getInstance() {
		return instance;
	}

	public DAOImpl getDAOImpl() {
		return daoImpl;
	}

}
