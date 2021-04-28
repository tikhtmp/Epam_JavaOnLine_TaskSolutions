package by.epam_training.java_online.module6.task1_library.bean;

import java.io.Serializable;

public class Admin extends Reader implements Serializable {

	private static final long serialVersionUID = 1L;

	public Admin() {
	}

	public Admin(int id, String name, String login, String password, String eMail) {
		super(id, name, login, password, eMail);
	}
}
