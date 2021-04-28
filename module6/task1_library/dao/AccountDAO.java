package by.epam_training.java_online.module6.task1_library.dao;

import by.epam_training.java_online.module6.task1_library.bean.Account;

public interface AccountDAO {

	void addAccount(Account newAccount) throws DAOException;

	void removeAccount(int userID) throws DAOException;

}
