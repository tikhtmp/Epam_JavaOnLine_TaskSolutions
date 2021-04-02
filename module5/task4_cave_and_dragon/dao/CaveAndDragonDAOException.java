package by.epam_training.java_online.module5.task4_cave_and_dragon.dao;

public class CaveAndDragonDAOException extends Exception {

	private static final long serialVersionUID = 1L;

	public CaveAndDragonDAOException() {
		super();
	}

	public CaveAndDragonDAOException(Exception e) {
		super(e);
	}

	public CaveAndDragonDAOException(String message) {
		super(message);
	}

	public CaveAndDragonDAOException(String message, Exception e) {
		super(message, e);
	}

}
