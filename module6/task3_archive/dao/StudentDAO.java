package by.epam_training.java_online.module6.task3_archive.dao;

public interface StudentDAO {

	String getStudents() throws DAOException;

	String getStudent(String id) throws DAOException;

	String addStudent(String id, String name) throws DAOException;
	
	String deleteStudent(String id) throws DAOException;

}
