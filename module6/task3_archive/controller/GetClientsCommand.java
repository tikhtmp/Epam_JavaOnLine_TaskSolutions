package by.epam_training.java_online.module6.task3_archive.controller;

import by.epam_training.java_online.module6.task3_archive.service.ServiceException;
import by.epam_training.java_online.module6.task3_archive.service.ServiceProvider;
import by.epam_training.java_online.module6.task3_archive.service.impl.ClientServiceImpl;

public class GetClientsCommand implements Command {

	private static ServiceProvider provider = ServiceProvider.getInstance();
	private static ClientServiceImpl clientServiceImpl = provider.getClientServiceImpl();

	@Override
	public String execute(String params) {

		String response;

		try {
			response = clientServiceImpl.getClients();
		} catch (ServiceException e) {
			// логирование
			response = "Error reading from client file!";
		}

		return response;
	}
}
