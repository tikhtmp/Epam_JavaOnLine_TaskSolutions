package by.epam_training.java_online.module6.task1_library.controller.impl;

import java.util.logging.Level;
import java.util.logging.Logger;

import by.epam_training.java_online.module6.task1_library.controller.Command;
import by.epam_training.java_online.module6.task1_library.service.ServiceException;
import by.epam_training.java_online.module6.task1_library.service.ServiceProvider;
import by.epam_training.java_online.module6.task1_library.service.impl.BookServiceImpl;
import by.epam_training.java_online.module6.task1_library.service.validation.Validator;

public class AddBookCommand implements Command {
	static Logger LOG;
	
	@Override
	public String execute(String[] params) {
		
		
		ServiceProvider provider = ServiceProvider.getInstance();
		BookServiceImpl bookService = provider.getBookService();

		String[] newBookDetails = params[1].split("\\|");

		String title = newBookDetails[0].split("=")[1].trim();
		String author = newBookDetails[1].split("=")[1].trim();
		
		if (!Validator.validateName(author)) {
			return "Incorrect name!";
		}
		
		String year = newBookDetails[2].split("=")[1].trim();
		
		if (!Validator.validateYear(year)) {
			return "Incorrect year!";
		}

		String bookType = newBookDetails[3].split("=")[1].trim();
		String prefferedBookID = newBookDetails[4].split("=")[1].trim();

			try {
				bookService.addBook(title, author, year, bookType, prefferedBookID);
			} catch (ServiceException e) {
				LOG.log(Level.WARNING,"Error accessing the file!");				
				return "Error accessing the file! The book wasn't added!";
			}

			return "The book was successfully added";
	}

}
