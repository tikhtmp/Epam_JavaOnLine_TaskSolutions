package by.epam_training.java_online.module6.task1_library.controller.impl;

import java.util.logging.Level;
import java.util.logging.Logger;

import by.epam_training.java_online.module6.task1_library.controller.Command;
import by.epam_training.java_online.module6.task1_library.service.ServiceException;
import by.epam_training.java_online.module6.task1_library.service.ServiceProvider;
import by.epam_training.java_online.module6.task1_library.service.impl.UserServiceImpl;
import by.epam_training.java_online.module6.task1_library.service.validation.Validator;

public class AddReaderCommand implements Command{
	
	private static Logger LOG;

	@Override
	public String execute(String[] params) {

		ServiceProvider provider = ServiceProvider.getInstance();
		UserServiceImpl userService = provider.getUserService();
		String[] userData = params[1].split("\\|");

		String userType = userData[0].split("=")[1].trim();
		String name = userData[1].split("=")[1].trim();
		
		if (!Validator.validateName(name)) {
			return "Incorrect name!";
		}

		String login = userData[2].split("=")[1].trim();
		
		if (!Validator.validateLogin(login)) {
			return "Incorrect login!";
		}

		String password = userData[3].split("=")[1].trim();
		
		if (!Validator.validatePassword(password)) {
			return "Incorrect password!";
		}

		String email = userData[4].split("=")[1].trim();
		
		if (!Validator.validateEmail(email)) {
			return "Incorrect email!";
		}

		String prefferedUserID = userData[5].split("=")[1].trim();

		try {
			userService.addUser(userType, name, login, password, email, prefferedUserID);
		} catch (ServiceException e) {
			LOG.log(Level.WARNING, "Error adding an user!");
			return "Error adding the user!";
		}

		return "The reader was successfully added.";
	}

}
