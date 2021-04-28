package by.epam_training.java_online.module6.task1_library.controller.impl;

import java.util.logging.Level;
import java.util.logging.Logger;

import by.epam_training.java_online.module6.task1_library.controller.Command;
import by.epam_training.java_online.module6.task1_library.service.ServiceException;
import by.epam_training.java_online.module6.task1_library.service.ServiceProvider;
import by.epam_training.java_online.module6.task1_library.service.impl.AccountServiceImpl;

public class LendBookCommand implements Command {

	private static Logger LOG;

	@Override
	public String execute(String[] params) {

		ServiceProvider provider = ServiceProvider.getInstance();
		AccountServiceImpl accountService = provider.getAccountService();

		String[] lendingBookData = params[1].split("\\|");
		String bookID = lendingBookData[0].split("=")[1].trim();
		String userID = lendingBookData[1].split("=")[1].trim();

		try {
			accountService.lendBook(bookID, userID);
		} catch (ServiceException e) {
			LOG.log(Level.WARNING, "Error lending a book!");
			return "Error lending the book!";
		}

		return "The book " + bookID + " was lended to reader " + userID;
	}

}
