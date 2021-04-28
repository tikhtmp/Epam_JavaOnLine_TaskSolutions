package by.epam_training.java_online.module6.task1_library.controller.impl;

import java.util.logging.Level;
import java.util.logging.Logger;

import by.epam_training.java_online.module6.task1_library.controller.Command;
import by.epam_training.java_online.module6.task1_library.service.ServiceException;
import by.epam_training.java_online.module6.task1_library.service.ServiceProvider;
import by.epam_training.java_online.module6.task1_library.service.impl.AccountServiceImpl;
import by.epam_training.java_online.module6.task1_library.service.impl.BookServiceImpl;
import by.epam_training.java_online.module6.task1_library.service.impl.UserServiceImpl;

public class StartApplicationCommand implements Command {
	
	private static Logger LOG;

	@Override
	public String execute(String[] params) {
		String response = null;

		ServiceProvider provider = ServiceProvider.getInstance();
		UserServiceImpl userService = provider.getUserService();
		BookServiceImpl bookService = provider.getBookService();
		AccountServiceImpl accountService = provider.getAccountService();

		userService.checkIfLibraryExists();
		userService.checkIfUserFileExists();
		bookService.checkIfBookFileExists();
		accountService.checkIfAccountFileExists();

		try {
			response = String.valueOf(userService.checkIfUserFileHasAdmin());
		} catch (ServiceException e) {
			LOG.log(Level.WARNING,"Error accessing the file!");				
			return "Error accessing the file!";
		}
		

		return response;
	}

}
