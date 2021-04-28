package by.epam_training.java_online.module6.task1_library.dao;

import by.epam_training.java_online.module6.task1_library.bean.User;

public interface UserDAO {
	
	void addUser(User newUser) throws DAOException;
	
	void removeUser(int id) throws DAOException;
	
	void editUser(int id, String newName, String newLogin, String newPassword, String NewEMail) throws DAOException;
	
}
