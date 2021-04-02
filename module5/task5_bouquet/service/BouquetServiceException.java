package by.epam_training.java_online.module5.task5_bouquet.service;

public class BouquetServiceException extends Exception {

	private static final long serialVersionUID = 1L;

	BouquetServiceException() {
	}

	BouquetServiceException(Exception e) {
		super(e);
	}

	BouquetServiceException(String message) {
		super(message);
	}

	BouquetServiceException(String message, Exception e) {
		super(message, e);
	}

}
