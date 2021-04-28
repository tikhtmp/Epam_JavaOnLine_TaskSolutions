package by.epam_training.java_online.module6.task1_library.dao;

import by.epam_training.java_online.module6.task1_library.dao.impl.AccountDAOImpl;
import by.epam_training.java_online.module6.task1_library.dao.impl.BookDAOImpl;
import by.epam_training.java_online.module6.task1_library.dao.impl.UserDAOImpl;

public class DaoProvider {
	private static final DaoProvider instance = new DaoProvider();
	private BookDAOImpl bookDaoImpl = new BookDAOImpl();
	private UserDAOImpl userDAOImpl = new UserDAOImpl();
	private AccountDAOImpl accountDAOImpl = new AccountDAOImpl();

	private DaoProvider() {
	}

	public static DaoProvider getInstance() {
		return instance;
	}

	public UserDAOImpl getUserDAOImpl() {
		return userDAOImpl;
	}

	public BookDAOImpl getBookDaoImpl() {
		return bookDaoImpl;
	};

	public AccountDAOImpl getAccountDAOImpl() {
		return accountDAOImpl;
	}
}
