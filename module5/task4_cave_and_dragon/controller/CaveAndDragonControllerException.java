package by.epam_training.java_online.module5.task4_cave_and_dragon.controller;

public class CaveAndDragonControllerException extends Exception {

	private static final long serialVersionUID = 1L;

	public CaveAndDragonControllerException() {
		super();
	}

	public CaveAndDragonControllerException(String message) {
		super(message);
	}

	public CaveAndDragonControllerException(Exception e) {
		super(e);
	}

	public CaveAndDragonControllerException(String message, Exception e) {
		super(message, e);
	}

}
