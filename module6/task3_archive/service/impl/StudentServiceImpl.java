package by.epam_training.java_online.module6.task3_archive.service.impl;

import by.epam_training.java_online.module6.task3_archive.dao.DAOException;
import by.epam_training.java_online.module6.task3_archive.dao.DAOProvider;
import by.epam_training.java_online.module6.task3_archive.dao.impl.StudentDAOImpl;
import by.epam_training.java_online.module6.task3_archive.service.ServiceException;
import by.epam_training.java_online.module6.task3_archive.service.StudentService;

public class StudentServiceImpl implements StudentService {
	private static StudentDAOImpl studentDaoImpl = DAOProvider.getInstance().getStudentDAOImpl();

	@Override
	public String getStudents() throws ServiceException {
		String response;

		try {
			response = studentDaoImpl.getStudents();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

		return response;
	}

	@Override
	public String getStudent(String id) throws ServiceException {
		String response;

		try {
			response = studentDaoImpl.getStudent(id);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

		return response;
	}

	@Override
	public String addStudent(String id, String name) throws ServiceException {
		String response;

		try {
			response = studentDaoImpl.addStudent(id, name);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

		return response;
	}

	@Override
	public String deleteStudent(String id) throws ServiceException {
		try {
			return studentDaoImpl.deleteStudent(id);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

}
