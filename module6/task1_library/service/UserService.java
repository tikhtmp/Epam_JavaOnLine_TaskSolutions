package by.epam_training.java_online.module6.task1_library.service;

import by.epam_training.java_online.module6.task1_library.bean.RegistrationInfo;
import by.epam_training.java_online.module6.task1_library.bean.User;

public interface UserService {
	
	void addUser(String type, String name, String login, String password, String eMail, String prefferedID) throws ServiceException;

	void removeUser(String id) throws ServiceException;
	
	User logination(RegistrationInfo newUser) throws ServiceException;

}
