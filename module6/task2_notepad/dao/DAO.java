package by.epam_training.java_online.module6.task2_notepad.dao;

import by.epam_training.java_online.module6.task2_notepad.bean.Criteria;

public interface DAO {
	
	String getNotes() throws DAOException;
	
	void saveNotes(String notes) throws DAOException;
	
	String findNotes(Criteria criteria) throws DAOException;

}
