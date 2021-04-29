package by.epam_training.java_online.module6.task1_library.controller.impl;

import by.epam_training.java_online.module6.task1_library.controller.Command;
import by.epam_training.java_online.module6.task1_library.service.ServiceException;
import by.epam_training.java_online.module6.task1_library.service.ServiceProvider;
import by.epam_training.java_online.module6.task1_library.service.impl.UserServiceImpl;

public class RemoveReaderCommand implements Command {

	@Override
	public String execute(String[] params) {

		ServiceProvider provider = ServiceProvider.getInstance();
		UserServiceImpl userService = provider.getUserService();

		String[] deletingUserDetails = params[1].split("\\|");
		String removingUserId = deletingUserDetails[1].split("=")[1].trim();

		try {
			userService.removeUser(removingUserId);
		} catch (ServiceException e) {
			// логирование
			return "Error removing the user!";
		}

		return "The reader was successfully removed.\n";
	}

}
