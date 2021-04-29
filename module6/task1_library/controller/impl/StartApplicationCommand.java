package by.epam_training.java_online.module6.task1_library.controller.impl;

import by.epam_training.java_online.module6.task1_library.controller.Command;
import by.epam_training.java_online.module6.task1_library.service.ServiceException;
import by.epam_training.java_online.module6.task1_library.service.ServiceProvider;
import by.epam_training.java_online.module6.task1_library.service.impl.AccountServiceImpl;
import by.epam_training.java_online.module6.task1_library.service.impl.BookServiceImpl;
import by.epam_training.java_online.module6.task1_library.service.impl.UserServiceImpl;

public class StartApplicationCommand implements Command {

	@Override
	public String execute(String[] params) {

		String response;

		ServiceProvider provider = ServiceProvider.getInstance();
		UserServiceImpl userService = provider.getUserService();
		BookServiceImpl bookService = provider.getBookService();
		AccountServiceImpl accountService = provider.getAccountService();

		userService.checkIfLibraryExists();

		try {
			userService.checkIfUserFileExists();
		} catch (ServiceException e) {
			// логирование
			response = "Error creating the user file!";
		}

		try {
			bookService.checkIfBookFileExists();
		} catch (ServiceException e1) {
			// логирование
			response = "Error creating the book file!";
		}

		try {
			accountService.checkIfAccountFileExists();
		} catch (ServiceException e1) {
			// логирование
			response = "Error creating the account file!";
		}

		try {
			response = String.valueOf(userService.checkIfUserFileHasAdmin());

		} catch (ServiceException e) {
			// логирование
			response = "Error accessing the user file!";
		}

		return response;
	}
}
