package by.epam_training.java_online.module6.task3_archive.service;

import by.epam_training.java_online.module6.task3_archive.service.impl.StudentServiceImpl;
import by.epam_training.java_online.module6.task3_archive.service.impl.ClientServiceImpl;

public class ServiceProvider {

	private static final ServiceProvider instance = new ServiceProvider();
	private StudentServiceImpl studentServiceImpl = new StudentServiceImpl();
	private ClientServiceImpl clientServiceImpl = new ClientServiceImpl();

	private ServiceProvider() {
	}

	public static ServiceProvider getInstance() {
		return instance;
	}

	public StudentServiceImpl getStudentServiceImpl() {
		return studentServiceImpl;
	}

	public ClientServiceImpl getClientServiceImpl() {
		return clientServiceImpl;
	}

}
