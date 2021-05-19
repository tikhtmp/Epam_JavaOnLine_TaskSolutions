package by.epam_training.java_online.module6.task3_archive.dao;

import by.epam_training.java_online.module6.task3_archive.dao.impl.StudentDAOImpl;
import by.epam_training.java_online.module6.task3_archive.dao.impl.ClientDAOImpl;

public class DAOProvider {

	private static final DAOProvider instance = new DAOProvider();
	private StudentDAOImpl studentDaoImpl = new StudentDAOImpl();
	private ClientDAOImpl userDaoImpl = new ClientDAOImpl();

	private DAOProvider() {
	}

	public static DAOProvider getInstance() {
		return instance;
	}

	public StudentDAOImpl getStudentDAOImpl() {
		return studentDaoImpl;
	}

	public ClientDAOImpl getUserDAOImpl() {
		return userDaoImpl;
	}

}
