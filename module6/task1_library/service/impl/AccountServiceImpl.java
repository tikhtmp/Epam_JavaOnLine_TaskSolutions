package by.epam_training.java_online.module6.task1_library.service.impl;

import by.epam_training.java_online.module6.task1_library.dao.DAOException;
import by.epam_training.java_online.module6.task1_library.dao.DaoProvider;
import by.epam_training.java_online.module6.task1_library.dao.impl.AccountDAOImpl;
import by.epam_training.java_online.module6.task1_library.service.AccountService;
import by.epam_training.java_online.module6.task1_library.service.ServiceException;

public class AccountServiceImpl implements AccountService {

	AccountDAOImpl accountDAOImpl = DaoProvider.getInstance().getAccountDAOImpl();

	public boolean checkIfAccountFileExists() throws ServiceException {
		try {
			return accountDAOImpl.checkIfAccountFileExists();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void removeAccount(String userId) throws ServiceException {

		try {
			accountDAOImpl.removeAccount(Integer.parseInt(userId));
		} catch (NumberFormatException | DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void lendBook(String bookID, String userID) throws ServiceException {
		try {
			accountDAOImpl.lendBook(Integer.parseInt(userID), Integer.parseInt(bookID));
		} catch (NumberFormatException | DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void takeBookBack(String bookID) throws ServiceException {
		try {
			accountDAOImpl.takeBookBack(Integer.parseInt(bookID));
		} catch (NumberFormatException | DAOException e) {
			throw new ServiceException(e);
		}
	}

}
