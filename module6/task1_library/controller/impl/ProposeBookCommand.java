package by.epam_training.java_online.module6.task1_library.controller.impl;

import by.epam_training.java_online.module6.task1_library.controller.Command;
import by.epam_training.java_online.module6.task1_library.service.ServiceException;
import by.epam_training.java_online.module6.task1_library.service.ServiceProvider;
import by.epam_training.java_online.module6.task1_library.service.impl.UserServiceImpl;

public class ProposeBookCommand implements Command {

	@Override
	public String execute(String[] params) {

		ServiceProvider provider = ServiceProvider.getInstance();
		UserServiceImpl userService = provider.getUserService();

		String[] proposingBookDetails = params[1].split("\\|");

		String proposingBookTitle = proposingBookDetails[0].split("=")[1].trim();
		String proposingBookAuthor = proposingBookDetails[1].split("=")[1].trim();
		String proposingBookYear = proposingBookDetails[2].split("=")[1].trim();
		String proposingBookType = proposingBookDetails[3].split("=")[1].trim();
		String gMailLogin = proposingBookDetails[5].split("=")[1].trim();
		String userPassword = proposingBookDetails[6].split("=")[1].trim();
		String recipient = proposingBookDetails[7].split("=")[1].trim();
		StringBuilder message = new StringBuilder();

		if (recipient.equals("Admin")) {
			message.append("Dear library admin!\nWould you like to add the following book to your library?");
		} else
			message.append("Dear reader!\nFollowing book has been added to the library:");

		message.append("\nTitle: " + proposingBookTitle);
		message.append("\nAuthor: " + proposingBookAuthor);
		message.append("\nYear of publication: " + proposingBookYear);
		message.append("\nType: " + proposingBookType);

		try {
			userService.proposeBook(gMailLogin, userPassword, recipient, message.toString());
		} catch (ServiceException e) {
			// логирование
			return "Error sending an email!";
		}

		return "The book \"" + proposingBookTitle + " by " + proposingBookAuthor + " was proposed";
	}

}
