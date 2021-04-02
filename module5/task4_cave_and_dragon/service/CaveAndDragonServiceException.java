package by.epam_training.java_online.module5.task4_cave_and_dragon.service;

public class CaveAndDragonServiceException extends Exception {

	private static final long serialVersionUID = 1L;

	public CaveAndDragonServiceException() {
		super();
	}

	public CaveAndDragonServiceException(Exception e) {
		super(e);
	}

	public CaveAndDragonServiceException(String message) {
		super(message);
	}

	public CaveAndDragonServiceException(String message, Exception e) {
		super(message, e);
	}

}
