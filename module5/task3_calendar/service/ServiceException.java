package by.epam_training.java_online.module5.task3_calendar.service;

public class ServiceException extends Exception {

	private static final long serialVersionUID = 1L;

	public ServiceException() {
	}

	public ServiceException(Exception e) {
		super(e);
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(String message, Exception e) {
		super(message, e);
	}
}
