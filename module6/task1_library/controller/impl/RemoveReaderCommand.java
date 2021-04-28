package by.epam_training.java_online.module6.task1_library.controller.impl;

import java.util.logging.Level;
import java.util.logging.Logger;

import by.epam_training.java_online.module6.task1_library.controller.Command;
import by.epam_training.java_online.module6.task1_library.service.ServiceException;
import by.epam_training.java_online.module6.task1_library.service.ServiceProvider;
import by.epam_training.java_online.module6.task1_library.service.impl.UserServiceImpl;

public class RemoveReaderCommand implements Command {
	
	private static Logger LOG;

	@Override
	public String execute(String[] params) {

		ServiceProvider provider = ServiceProvider.getInstance();
		UserServiceImpl userService = provider.getUserService();

		String[] deletingUserDetails = params[1].split("\\|");
		String removingUserId = deletingUserDetails[1].split("=")[1].trim();

		try {
			userService.removeUser(removingUserId);
		} catch (ServiceException e) {
			LOG.log(Level.WARNING, "Error removing an user!");
			return "Error removing the user!";
		}

		return "The reader was successfully removed";
	}

}
