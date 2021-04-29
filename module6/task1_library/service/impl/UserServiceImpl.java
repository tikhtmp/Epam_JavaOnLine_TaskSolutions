package by.epam_training.java_online.module6.task1_library.service.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.xml.bind.DatatypeConverter;

import by.epam_training.java_online.module6.task1_library.bean.Admin;
import by.epam_training.java_online.module6.task1_library.bean.Reader;
import by.epam_training.java_online.module6.task1_library.bean.RegistrationInfo;
import by.epam_training.java_online.module6.task1_library.bean.User;
import by.epam_training.java_online.module6.task1_library.dao.DAOException;
import by.epam_training.java_online.module6.task1_library.dao.DaoProvider;
import by.epam_training.java_online.module6.task1_library.dao.impl.UserDAOImpl;
import by.epam_training.java_online.module6.task1_library.service.ServiceException;
import by.epam_training.java_online.module6.task1_library.service.UserService;
import by.epam_training.java_online.module6.task1_library.service.util.IdGenerator;

public class UserServiceImpl implements UserService {

	UserDAOImpl userDAOimpl = DaoProvider.getInstance().getUserDAOImpl();

	public void proposeBook(String gMailLogin, String emailPassword, String recipient, String content)
			throws ServiceException {

		final String username = gMailLogin;
		final String password = emailPassword;
		StringBuilder recipientList = new StringBuilder();

		try {
			for (User u : userDAOimpl.getUsersFromFile()) {

				if (u.getClass().getSimpleName().equals(recipient)) {
					recipientList.append(u.geteMail());
					recipientList.append(", ");
				}
			}
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

		if (recipientList.length() > 0) {
			recipientList.deleteCharAt(recipientList.length() - 1);
			recipientList.deleteCharAt(recipientList.length() - 1);
		}

		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");

		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("from@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientList.toString()));
			message.setSubject("Adding new book");
			message.setText(content);

			Transport.send(message);

			System.out.println("Notification has been send by email.\n");

		} catch (MessagingException e) {
			throw new ServiceException(e);
		}

	}

	@Override
	public void addUser(String type, String name, String login, String password, String eMail, String prefferedID)
			throws ServiceException {

		User newUser;
		String encriptedPassword = getEncryptedPassword(password);
		int newID = Integer.parseInt(prefferedID);
		int id;

		try {
			id = IdGenerator.generateId(userDAOimpl.getUsersFromFile(), newID);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

		if (type.equals("Admin")) {
			newUser = new Admin(id, name, login, encriptedPassword, eMail);
		} else {
			newUser = new Reader(id, name, login, encriptedPassword, eMail);
		}

		try {
			userDAOimpl.addUser(newUser);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void removeUser(String id) throws ServiceException {

		try {
			userDAOimpl.removeUser(Integer.parseInt(id));
		} catch (NumberFormatException e) {
			throw new ServiceException(e);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	public boolean checkIfLibraryExists() {
		return userDAOimpl.checkIfLibraryExists();
	}

	public boolean checkIfUserFileExists() throws ServiceException {
		try {
			return userDAOimpl.checkIfUserFileExists();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	public boolean checkIfUserFileHasAdmin() throws ServiceException {

		List<User> users;

		try {
			users = userDAOimpl.getUsersFromFile();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

		for (User u : users) {

			if (u.getClass().getSimpleName().equals("Admin"))
				return true;
		}

		return false;
	}

	@Override
	public User logination(RegistrationInfo newUser) throws ServiceException {

		List<User> users;

		try {
			users = userDAOimpl.getUsersFromFile();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

		for (User u : users) {
			if (u.getLogin().equals(newUser.getRegistrationLogin())
					&& u.getPassword().equals(getEncryptedPassword(newUser.getRegistrationPassword())))
				return u;
		}
		return null;
	}

	private static String getEncryptedPassword(String password) throws ServiceException {

		MessageDigest digester;

		try {
			digester = MessageDigest.getInstance("SHA-512");
		} catch (NoSuchAlgorithmException e) {
			throw new ServiceException(e);
		}

		byte[] bytePassword = password.getBytes();
		byte[] digestPassword = digester.digest(bytePassword);
		String encryptedPassword = DatatypeConverter.printHexBinary(digestPassword);
		return encryptedPassword;
	}

}
