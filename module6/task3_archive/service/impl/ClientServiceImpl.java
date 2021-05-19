package by.epam_training.java_online.module6.task3_archive.service.impl;

import by.epam_training.java_online.module6.task3_archive.dao.DAOException;
import by.epam_training.java_online.module6.task3_archive.dao.impl.ClientDAOImpl;
import by.epam_training.java_online.module6.task3_archive.service.ClentService;
import by.epam_training.java_online.module6.task3_archive.service.ServiceException;

public class ClientServiceImpl implements ClentService {
	private static ClientDAOImpl clientDAOImpl = new ClientDAOImpl();

	@Override
	public String getClients() throws ServiceException {
		String clients;

		try {
			clients = clientDAOImpl.getClients();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

		return clients;
	}

	@Override
	public String logIn(String login, String password) throws ServiceException {
		String response;

		try {
			response = clientDAOImpl.logIn(login, password);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

		return response;
	}

}
