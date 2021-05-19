package by.epam_training.java_online.module6.task3_archive.controller;

import by.epam_training.java_online.module6.task3_archive.service.ServiceException;
import by.epam_training.java_online.module6.task3_archive.service.ServiceProvider;
import by.epam_training.java_online.module6.task3_archive.service.impl.StudentServiceImpl;

public class AddStudentCommand implements Command {

	private static ServiceProvider provider = ServiceProvider.getInstance();
	private static StudentServiceImpl studentServiceImpl = provider.getStudentServiceImpl();

	@Override
	public String execute(String params) {
		String response;
		String[] data = new String[2];
		String id;
		String name;

		data = params.split("\\|");

		id = data[0].split("=")[1].trim();
		name = data[1].split("=")[1].trim();

		try {
			response = studentServiceImpl.addStudent(id, name);
		} catch (ServiceException e) {
			//логирование
			response = "Error reading or writing student file!";
		}

		return response;
	}

}
