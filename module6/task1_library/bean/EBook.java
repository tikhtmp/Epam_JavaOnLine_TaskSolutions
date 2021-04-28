package by.epam_training.java_online.module6.task1_library.bean;

import java.io.Serializable;

public class EBook extends Book implements Serializable {

	private static final long serialVersionUID = 1L;

	public EBook() {
		super();
	}

	public EBook(int id, String title, String author, int year, boolean isAvailable) {
		super(id, title, author, year, isAvailable);
	}
}
