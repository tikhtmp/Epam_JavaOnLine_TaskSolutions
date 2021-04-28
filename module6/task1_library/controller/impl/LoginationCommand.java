package by.epam_training.java_online.module6.task1_library.controller.impl;

import java.util.logging.Level;
import java.util.logging.Logger;

import by.epam_training.java_online.module6.task1_library.bean.RegistrationInfo;
import by.epam_training.java_online.module6.task1_library.bean.User;
import by.epam_training.java_online.module6.task1_library.controller.Command;
import by.epam_training.java_online.module6.task1_library.service.ServiceException;
import by.epam_training.java_online.module6.task1_library.service.ServiceProvider;
import by.epam_training.java_online.module6.task1_library.service.impl.UserServiceImpl;
import by.epam_training.java_online.module6.task1_library.service.validation.Validator;

public class LoginationCommand implements Command {
	
	private static Logger LOG;

	@Override
	public String execute(String[] params) {
		String[] loginationData = params[1].split("\\|");
		String login = loginationData[0].split("=")[1];

		if (!Validator.validateLogin(login)) {
			return "Incorrect login";
		}
		String password = loginationData[1].split("=")[1];

		if (!Validator.validatePassword(password)) {
			return "Incorrect password";
		}

		RegistrationInfo registrationInfo = new RegistrationInfo(login, password);
		ServiceProvider provider = ServiceProvider.getInstance();
		UserServiceImpl userService = provider.getUserService();
		String response;
		User user = null;

			try {
				user = userService.logination(registrationInfo);
			} catch (ServiceException e) {
				LOG.log(Level.WARNING,"Error!");				
				return "Error accessing the file!";
			}

		if (user != null) {
			response = "Hello, " + user.getName() + "! =" + user.getClass().getSimpleName();
		} else {
			response = "No such user!";
		}

		return response;

	}

}
