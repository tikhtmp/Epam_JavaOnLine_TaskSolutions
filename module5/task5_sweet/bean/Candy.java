package by.epam_training.java_online.module5.task5_sweet.bean;

import java.io.Serializable;

public class Candy extends Sweet implements Serializable {

	private static final long serialVersionUID = 1L;

	public Candy() {
	}

	public Candy(String description) {
		super(description);
	}

}
