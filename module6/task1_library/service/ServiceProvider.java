package by.epam_training.java_online.module6.task1_library.service;

import by.epam_training.java_online.module6.task1_library.service.impl.AccountServiceImpl;
import by.epam_training.java_online.module6.task1_library.service.impl.BookServiceImpl;
import by.epam_training.java_online.module6.task1_library.service.impl.UserServiceImpl;

public class ServiceProvider {

	private static final ServiceProvider instance = new ServiceProvider();
	private BookServiceImpl bookService = new BookServiceImpl();
	private UserServiceImpl userService = new UserServiceImpl();
	private AccountServiceImpl accountService = new AccountServiceImpl();

	private ServiceProvider() {
	}

	public static ServiceProvider getInstance() {
		return instance;
	}

	public UserServiceImpl getUserService() {
		return userService;
	}

	public BookServiceImpl getBookService() {
		return bookService;
	}

	public AccountServiceImpl getAccountService() {
		return accountService;
	}
}
