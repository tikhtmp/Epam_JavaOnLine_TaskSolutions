package by.epam_training.java_online.module5.task3_calendar.dao;

public class DAOException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public DAOException() {
		super();
	}
	
	public DAOException(Exception e) {
		super(e);
	}
	
	public DAOException(String message) {
		super(message);
	}
	
	public DAOException(String message, Exception e) {
		super(message, e);
	}
}
