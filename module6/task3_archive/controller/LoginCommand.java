package by.epam_training.java_online.module6.task3_archive.controller;

import by.epam_training.java_online.module6.task3_archive.service.ServiceException;
import by.epam_training.java_online.module6.task3_archive.service.ServiceProvider;
import by.epam_training.java_online.module6.task3_archive.service.impl.ClientServiceImpl;

public class LoginCommand implements Command {

	private static ClientServiceImpl clientServiceImpl = ServiceProvider.getInstance().getClientServiceImpl();

	@Override
	public String execute(String params) {
		String response;
		String[] data = new String[2];
		String login;
		String password;

		data = params.split("\\|");

		login = data[0].split("=")[1].trim();
		password = data[1].split("=")[1].trim();
		try {
			response = clientServiceImpl.logIn(login, password);
		} catch (ServiceException e) {
			// логирование
			response = "No such client!";
		}

		return response;
	}

}
