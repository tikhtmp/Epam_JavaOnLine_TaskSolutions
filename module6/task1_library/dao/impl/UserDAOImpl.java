package by.epam_training.java_online.module6.task1_library.dao.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import by.epam_training.java_online.module6.task1_library.bean.Account;
import by.epam_training.java_online.module6.task1_library.bean.Admin;
import by.epam_training.java_online.module6.task1_library.bean.Reader;
import by.epam_training.java_online.module6.task1_library.bean.User;
import by.epam_training.java_online.module6.task1_library.dao.DAOException;
import by.epam_training.java_online.module6.task1_library.dao.DaoProvider;
import by.epam_training.java_online.module6.task1_library.dao.UserDAO;

public class UserDAOImpl implements UserDAO {

	private static String LIBRARY_LOCATION = "C:/HomeLibrary/";
	private static final String USERFILE_LOCATION = "users.txt";
	private static final File USER_SOURCE = new File(LIBRARY_LOCATION + USERFILE_LOCATION);

	public static String getLIBRARY_LOCATION() {
		return LIBRARY_LOCATION;
	}

	public boolean checkIfUserFileExists() {

		if (!USER_SOURCE.exists()) {
			new File(LIBRARY_LOCATION + USERFILE_LOCATION);
			return false;
		}

		return true;
	}

	public boolean checkIfLibraryExists() {

		if (!new File(LIBRARY_LOCATION).exists()) {
			new File(LIBRARY_LOCATION).mkdir();
			return false;
		}

		return true;
	}

	public List<User> getUsersFromFile() throws DAOException {

		String line;
		int id;
		String name;
		String login;
		String password;
		String email;
		String type;

		List<User> result = new ArrayList<User>();

		try (BufferedReader reader = new BufferedReader(new FileReader(USER_SOURCE))) {

			try {
				while ((line = reader.readLine()) != null) {

					String[] data = line.split("\\|");
					id = Integer.parseInt(data[0].trim());
					name = data[1].trim();
					login = data[2].trim();
					email = data[3].trim();
					type = data[4].trim();
					password = data[5].trim();

					if (type.equals("Reader")) {
						result.add(new Reader(id, name, login, password, email));
					}

					if (type.equals("Admin")) {
						result.add(new Admin(id, name, login, password, email));

					}
				}
			} catch (NumberFormatException | IOException e) {
				throw new DAOException(e);
			}
		} catch (FileNotFoundException e1) {
			throw new DAOException(e1);
		} catch (IOException e1) {
			throw new DAOException(e1);
		}
		return result;
	}

	private void saveUserDataFile(List<User> users) throws DAOException {

		String line;

		try (FileWriter writer = new FileWriter(USER_SOURCE, false)) {

			for (User u : users) {

				line = String.format("%03d | %-25s | %-15s | %-25s | %-6s | %s\n", u.getId(), u.getName(), u.getLogin(),
						u.geteMail(), u.getClass().getSimpleName(), u.getPassword());
				writer.write(line);
			}
		} catch (IOException e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void addUser(User newUser) throws DAOException {
		List<User> users = new ArrayList<User>();

		users = getUsersFromFile();

		users.add(newUser);
		saveUserDataFile(users);

		// при добавлении пользователя одновременно создается карточка на него
		AccountDAOImpl accountDAOImpl = DaoProvider.getInstance().getAccountDAOImpl();
		Account newAccount = new Account(newUser, null);

		accountDAOImpl.addAccount(newAccount);
	}

	@Override
	public void editUser(int id, String newName, String newLogin, String newPassword, String NewEMail)
			throws DAOException {

		List<User> users = new ArrayList<User>();

		users = getUsersFromFile();

		for (User u : users) {

			if (u.getId() == id) {
				u.setName(newName);
				u.setLogin(newLogin);
				u.setPassword(newPassword);
				u.seteMail(NewEMail);
				break;
			}
		}

		saveUserDataFile(users);
	}

	@Override
	public void removeUser(int id) throws DAOException {

		List<User> users = getUsersFromFile();

		for (int i = 0; i < users.size(); i++) {

			if (users.get(i).getId() == id) {
				users.remove(i);
				AccountDAOImpl accountDAOImpl = DaoProvider.getInstance().getAccountDAOImpl();
				accountDAOImpl.removeAccount(id); // при удалении пользователя одновременно удаляется его карточка
				break;
			}
		}
		
		saveUserDataFile(users);
	}

}
