package by.epam_training.java_online.module5.task5_sweet.bean;

import java.io.Serializable;

public class Box extends Packaging implements Serializable {

	private static final long serialVersionUID = 1L;

	public Box() {
	}

	public Box(String description) {
		super(description);
	}
}