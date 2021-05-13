package by.epam_training.java_online.module6.task2_notepad.service;

import by.epam_training.java_online.module6.task2_notepad.service.impl.ServiceImpl;

public class ServiceProvider {

	private static final ServiceProvider instance = new ServiceProvider();
	private static ServiceImpl serviceImpl = new ServiceImpl();

	private ServiceProvider() {
	}

	public static ServiceProvider getInstance() {
		return instance;
	}

	public ServiceImpl getServiceImpl() {
		return serviceImpl;
	}

}
