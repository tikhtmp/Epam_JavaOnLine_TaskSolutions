package by.epam_training.java_online.module6.task3_archive.controller;

import by.epam_training.java_online.module6.task3_archive.service.ServiceException;
import by.epam_training.java_online.module6.task3_archive.service.ServiceProvider;
import by.epam_training.java_online.module6.task3_archive.service.impl.StudentServiceImpl;

public class GetStudentsCommand implements Command {

	private static StudentServiceImpl studentServiceImpl = ServiceProvider.getInstance().getStudentServiceImpl();

	@Override
	public String execute(String params) {
		String response;

		try {
			response = studentServiceImpl.getStudents();
		} catch (ServiceException e) {
			// логирование
			response = "Error reading student file!";
		}

		return response;
	}
}
