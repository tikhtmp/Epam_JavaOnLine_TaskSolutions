package by.epam_training.java_online.module6.task1_library.bean;

public class RegistrationInfo {
	private String registrationLogin;
	private String registrationPassword;

	public RegistrationInfo() {
	}

	public RegistrationInfo(String registrationLogin, String registrationPassword) {
		this.registrationLogin = registrationLogin;
		this.registrationPassword = registrationPassword;
	}

	public String getRegistrationLogin() {
		return registrationLogin;
	}

	public String getRegistrationPassword() {
		return registrationPassword;
	}
}
