package by.epam_training.java_online.module5.task5_sweet.bean;

import java.io.Serializable;

public class Chocolate extends Sweet implements Serializable {

	private static final long serialVersionUID = 1L;

	public Chocolate() {
	}

	public Chocolate(String description) {
		super(description);
	}

}
