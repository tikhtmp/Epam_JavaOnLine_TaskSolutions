package by.epam_training.java_online.module5.task5_sweet.bean;

import java.io.Serializable;

public class PaperBag extends Packaging implements Serializable {

	private static final long serialVersionUID = 1L;

	public PaperBag() {
	}

	public PaperBag(String description) {
		super(description);
	}
}
