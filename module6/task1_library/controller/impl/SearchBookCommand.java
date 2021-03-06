package by.epam_training.java_online.module6.task1_library.controller.impl;

import by.epam_training.java_online.module6.task1_library.controller.Command;
import by.epam_training.java_online.module6.task1_library.service.ServiceException;
import by.epam_training.java_online.module6.task1_library.service.ServiceProvider;
import by.epam_training.java_online.module6.task1_library.service.impl.BookServiceImpl;

public class SearchBookCommand implements Command {

	@Override
	public String execute(String[] params) {
		ServiceProvider provider = ServiceProvider.getInstance();
		BookServiceImpl bookService = provider.getBookService();
		String response = null;

		String criteria = params[1];

		try {
			response = bookService.getBooks(criteria);
		} catch (ServiceException e) {
			// логирование
			return "Error accessing the book file!";
		}

		return response;
	}
}
