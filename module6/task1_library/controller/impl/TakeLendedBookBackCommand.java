package by.epam_training.java_online.module6.task1_library.controller.impl;

import java.util.logging.Level;
import java.util.logging.Logger;

import by.epam_training.java_online.module6.task1_library.controller.Command;
import by.epam_training.java_online.module6.task1_library.service.ServiceException;
import by.epam_training.java_online.module6.task1_library.service.ServiceProvider;
import by.epam_training.java_online.module6.task1_library.service.impl.AccountServiceImpl;

public class TakeLendedBookBackCommand implements Command {

	private static Logger LOG;

	@Override
	public String execute(String[] params) {

		ServiceProvider provider = ServiceProvider.getInstance();
		AccountServiceImpl accountService = provider.getAccountService();

		String takingBookID = params[1].split("=")[1];

		try {
			accountService.takeBookBack(takingBookID);
		} catch (ServiceException e) {
			LOG.log(Level.WARNING, "Error taking a book back!");
			return "Error taking the book back!";
		}

		return "The book " + takingBookID + "was returned in the library";
	}

}
