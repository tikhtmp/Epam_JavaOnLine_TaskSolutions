package by.epam_training.java_online.module5.task5_sweet.bean;

import java.io.Serializable;

public class Cookie extends Sweet implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public Cookie() {
	}

	public Cookie(String description) {
		super(description);
	}

}
