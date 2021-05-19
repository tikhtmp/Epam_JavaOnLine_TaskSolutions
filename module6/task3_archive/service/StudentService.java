package by.epam_training.java_online.module6.task3_archive.service;

public interface StudentService {

	String getStudents() throws ServiceException;

	String getStudent(String id) throws ServiceException;
	
	String addStudent(String id, String name) throws ServiceException;
	
	String deleteStudent(String id) throws ServiceException;

}
