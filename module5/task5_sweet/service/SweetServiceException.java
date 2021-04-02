package by.epam_training.java_online.module5.task5_sweet.service;

public class SweetServiceException extends Exception {

	private static final long serialVersionUID = 1L;

	public SweetServiceException() {
	}

	public SweetServiceException(Exception e) {
		super(e);
	}

	public SweetServiceException(String message) {
		super(message);
	}

	public SweetServiceException(String message, Exception e) {
		super(message, e);
	}
}
