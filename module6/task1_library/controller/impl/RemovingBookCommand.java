package by.epam_training.java_online.module6.task1_library.controller.impl;

import java.util.logging.Level;
import java.util.logging.Logger;

import by.epam_training.java_online.module6.task1_library.controller.Command;
import by.epam_training.java_online.module6.task1_library.service.ServiceException;
import by.epam_training.java_online.module6.task1_library.service.ServiceProvider;
import by.epam_training.java_online.module6.task1_library.service.impl.BookServiceImpl;

public class RemovingBookCommand implements Command {

	private static Logger LOG;

	@Override
	public String execute(String[] params) {

		ServiceProvider provider = ServiceProvider.getInstance();
		BookServiceImpl bookService = provider.getBookService();
		String removingBookId = params[1].split("=")[1];

		try {
			bookService.removeBook(removingBookId);
		} catch (ServiceException e) {
			LOG.log(Level.WARNING, "Error!");
			return "Error accessing the file!";
		}

		return "The book " + removingBookId + "was successfully removed";
	}

}
