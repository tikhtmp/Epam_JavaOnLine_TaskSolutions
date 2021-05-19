package by.epam_training.java_online.module6.task3_archive.controller;

import by.epam_training.java_online.module6.task3_archive.service.ServiceException;
import by.epam_training.java_online.module6.task3_archive.service.ServiceProvider;
import by.epam_training.java_online.module6.task3_archive.service.impl.StudentServiceImpl;

public class GetStudentCommand implements Command{
	private static ServiceProvider provider = ServiceProvider.getInstance();
	private static StudentServiceImpl studentServiceImpl = provider.getStudentServiceImpl();

	@Override
	public String execute(String params) {
		String id = params.split("=")[1].trim();
		String response;
		try {
			response = studentServiceImpl.getStudent(id);
		} catch (ServiceException e) {
			//логирование
			response = "Error reading student file!";
		}
		return response;
	}

}
