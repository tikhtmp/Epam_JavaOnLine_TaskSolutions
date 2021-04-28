package by.epam_training.java_online.module6.task1_library.dao.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import by.epam_training.java_online.module6.task1_library.bean.Account;
import by.epam_training.java_online.module6.task1_library.bean.Book;
import by.epam_training.java_online.module6.task1_library.bean.User;
import by.epam_training.java_online.module6.task1_library.dao.AccountDAO;
import by.epam_training.java_online.module6.task1_library.dao.DAOException;
import by.epam_training.java_online.module6.task1_library.dao.DaoProvider;

public class AccountDAOImpl implements AccountDAO {

	private static final String ACCOUNTFILE_LOCATION = "accounts.txt";
	private static final File ACCOUNT_SOURCE = new File(UserDAOImpl.getLIBRARY_LOCATION() + ACCOUNTFILE_LOCATION);

	public boolean checkIfAccountFileExists() {

		if (!ACCOUNT_SOURCE.exists()) {
			new File(UserDAOImpl.getLIBRARY_LOCATION() + ACCOUNTFILE_LOCATION);
			return false;
		}

		return true;
	}

	public void lendBook(int userID, int bookID) throws DAOException  {

		BookDAOImpl bookDAOImpl = DaoProvider.getInstance().getBookDaoImpl();
		List<Book> books = bookDAOImpl.getBooksFromFile();
		AccountDAOImpl accountDAOImpl = DaoProvider.getInstance().getAccountDAOImpl();
		List<Account> accounts = accountDAOImpl.getAccountsFromFile();

		Book lendedBook = null;

		for (Book b : books) {

			if (b.getId() == bookID && b.isAvailable()) {

				b.setAvailable(false);
				lendedBook = b;
				break;
			} else if (!b.isAvailable()) {
				// System.out.println("The book is unavailable");
			}
		}

		bookDAOImpl.saveBookDataFile(books);

		for (Account a : accounts) {

			if (a.getUser().getId() == userID) {

				if (lendedBook != null) {
					a.getBooks().add(lendedBook);
					break;
				}
			}
		}

		saveAccountDataFile(accounts);
	}

	public void takeBookBack(int bookID) throws DAOException {

		BookDAOImpl bookDAOImpl = DaoProvider.getInstance().getBookDaoImpl();
		List<Book> books = bookDAOImpl.getBooksFromFile();

		for (Book b : books) {

			if (b.getId() == bookID) {

				b.setAvailable(true);
			}
		}

		List<Account> accounts = getAccountsFromFile();

		for (Account a : accounts) {

			List<Book> userBooks = a.getBooks();
			List<Book> newUserBooks = new ArrayList<Book>();

			if (userBooks != null) {

				for (Book b : userBooks) {

					if (b.getId() != bookID) {
						newUserBooks.add(b);
					}
				}

				a.setBooks(newUserBooks);
			}
		}

		bookDAOImpl.saveBookDataFile(books);
		saveAccountDataFile(accounts);
	}

	public List<Account> getAccountsFromFile() throws DAOException {
		List<Account> result = new ArrayList<Account>();
		String line;
		int userId;
		User user = null;

		try (BufferedReader reader = new BufferedReader(new FileReader(ACCOUNT_SOURCE))) {

			while ((line = reader.readLine()) != null) {

				List<Book> accountBooks = new ArrayList<Book>();
				List<Integer> idBooks = new ArrayList<Integer>();

				String[] dataLine = line.split("\\|");
				userId = Integer.parseInt(dataLine[0].split("=")[1].trim());

				for (User u : DaoProvider.getInstance().getUserDAOImpl().getUsersFromFile()) {

					if (u.getId() == userId) {
						user = u;
						break;
					}
				}

				if (dataLine[1].split("=").length > 1) { // если есть выданные книги

					String[] dataBooks = dataLine[1].split("=")[1].split(",");

					for (int i = 0; i < dataBooks.length; i++) {
						idBooks.add(Integer.parseInt(dataBooks[i]));
					}

					for (int i = 0; i < idBooks.size(); i++) {

						for (Book b : DaoProvider.getInstance().getBookDaoImpl().getBooksFromFile()) {
							if (idBooks.get(i) == b.getId())
								accountBooks.add(b);
						}
					}
				}

				result.add(new Account(user, accountBooks));
			}
		} catch (IOException e) {
			throw new DAOException(e);
		}
		return result;
	}

	private void saveAccountDataFile(List<Account> accounts) throws DAOException {

		try (FileWriter writer = new FileWriter(ACCOUNT_SOURCE, false)) {

			for (Account a : accounts) {
				StringBuffer line = new StringBuffer();

				line.append(String.format("%25s=%d | books=", a.getUser().getName(), a.getUser().getId()));

				if (a.getBooks() != null) {

					for (Book b : a.getBooks()) {
						line.append(b.getId() + ",");
					}

					if (line.charAt(line.length() - 1) == ',')
						line.deleteCharAt(line.length() - 1); // удаление последней запятой
				}

				line.append("\n");
				String accountLine = line.toString();

				writer.write(accountLine);

			}
		} catch (IOException e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void addAccount(Account newAccount) throws DAOException {
		List<Account> accounts = getAccountsFromFile();
		accounts.add(newAccount);
		saveAccountDataFile(accounts);
	}

	@Override
	public void removeAccount(int userID) throws DAOException {

		List<Account> accounts = getAccountsFromFile();

		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getUser().getId() == userID) {
				accounts.remove(i);
				break;
			}
		}

		saveAccountDataFile(accounts);
	}
}
