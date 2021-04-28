package by.epam_training.java_online.module6.task1_library.service;

public interface AccountService {
	
	public void removeAccount(String userId) throws ServiceException;
	
	public void lendBook(String bookID, String userID) throws ServiceException;
	
	public void takeBookBack(String bookID) throws ServiceException;

}
