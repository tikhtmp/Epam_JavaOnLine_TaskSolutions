package by.epam_training.java_online.module6.task1_library.view;

import java.util.Calendar;
import java.util.Scanner;

import by.epam_training.java_online.module6.task1_library.controller.Controller;

public class LibraryView {

	private Controller controller = new Controller();
	private static Scanner scanner = new Scanner(System.in);
	private int currentYear = Calendar.getInstance().get(Calendar.YEAR);

	public void startApp() {

		int choice = -1;
		String request;
		String response;
		boolean isAdmin;

		// завести админа, если нет ни одного в базе
		// пользователь может быть зарегистрирован только админом
		while (controller.doAction("startApplication").equals("false")) {
			System.out.println("Please, register an Admin to proceed");
			controller.doAction("addUser*" + askNewUserInfo("Admin"));
		}

		do {

			do {
				System.out.println("Please, log in to start working.");
				request = askLoginInfo();
				response = controller.doAction(request);

				if (response.contains("Error")) {
					System.out.println(response);
					break;
				}

				if (response.contains("Incorrect")) {
					System.out.println(response);
				}

			} while (response.contains("Incorrect"));

			choice = response.equals("No such user!") ? -1 : 0;

			if (choice == -1) {
				System.out.println("Logination error! Please, try log in again.");
			} else {

				if (response.contains("Error")) {
					break;
				}

				System.out.println(response.split("=")[0]);
				isAdmin = response.split("=")[1].equals("Admin");

				if (!isAdmin) {
					userMenu();
				} else {
					adminMenu();
				}
			}

		} while (choice != 0);

		scanner.close();
		System.out.println("\nThe session is over.");
	}

	public void adminMenu() {
		int choice = -1;
		String response;
		String newBook;

		do {

			do {
				System.out
						.println("Please, select an action:\n1 - display library's books\n2 - filter books by request\n"
								+ "3 - add a book to the library \n4 - remove book from the library \n5 - edit book"
								+ "\n6 - add reader \n7 - remove reader \n8 - lend book \n9 - take a lended book back\n0 - end working");
				choice = getIntDataFromKeybord();

			} while (choice != 0 && choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5
					&& choice != 6 && choice != 7 && choice != 8 && choice != 9);

			getStringDataFromKeybord(); // это нужно чтобы подчистить ENTER после ввода числа

			if (choice == 1) // просмотр всех книг в каталоге
				displayBooks();

			if (choice == 2) // поиск книг в каталоге
				searchBook();

			if (choice == 3) { // добавить книгу в каталог с оповещением на эл. почту пользователей

				do {
					newBook = askNewBookInfo();
					response = controller.doAction("addBook*" + newBook);

					if (response.contains("Incorrect")) {
						System.out.println(response + "\nTry again...");
					} else {
						System.out.println(response);
					}

				} while (response.contains("Incorrect"));

				if (response.contains("Error")) {
					break;
				}

				announceBookByEmail("Reader", newBook);
			}

			if (choice == 4) { // удалить книгу из каталога
				response = controller.doAction("removeBook*" + askRemovingBook());

				System.out.println(response);

				if (response.contains("Error")) {
					break;
				}

			}

			if (choice == 5) { // редактировать книгу из каталога
				System.out.println("Please, input editing book's id: ");
				int id = getIntDataFromKeybord();
				editBook(id);
			}

			if (choice == 6) { // добавить читателя

				String newReader;

				do {
					newReader = askNewUserInfo("Reader");
					response = controller.doAction("addUser*" + newReader);

					if (response.contains("Error")) {
						System.out.println(response);
						break;
					}

					if (response.contains("Incorrect")) {
						System.out.println(response + "\nTry again...");
					} else {
						System.out.println(response);
					}

				} while (response.contains("Incorrect"));

			}

			if (choice == 7) { // удалить читателя
				response = controller.doAction("removeUser*" + askRemovingUser());

				System.out.println(response);

				if (response.contains("Error")) {
					break;
				}
			}

			if (choice == 8) { // выдать книгу читателю
				System.out.println("Please, input lending book's id: ");
				int bookID = getIntDataFromKeybord();

				System.out.println("Please, input reader's id: ");
				int userID = getIntDataFromKeybord();

				response = controller.doAction("lendBook*bookID=" + bookID + "|userID=" + userID);
				System.out.println(response);

				if (response.contains("Error")) {
					break;
				}
			}

			if (choice == 9) { // вернуть книгу в библиотеку
				System.out.println("Please, input returning book's id: ");
				int bookID = getIntDataFromKeybord();
				response = controller.doAction("takeBookBack*bookID=" + bookID);
				System.out.println(response);

				if (response.contains("Error")) {
					break;
				}
			}

		} while (choice != 0);
	}

	public void userMenu() {
		int choice = -1;

		do {

			do {
				System.out.println("Please, choose action:\n1 - display library's books\n2 - filter books by request\n"
						+ "3 - suggest a book to add to the library\n0 - end the session");
				choice = getIntDataFromKeybord();

			} while (choice != 0 && choice != 1 && choice != 2 && choice != 3);

			getStringDataFromKeybord(); // это нужно чтобы подчистить ENTER после ввода числа

			if (choice == 1) // просмотр всех книг в каталоге
				displayBooks();

			if (choice == 2) // поиск книг в каталоге
				searchBook();

			if (choice == 3) {// отправить email с предложением о добавлении книги в каталог
				String newBook = askNewBookInfo();
				announceBookByEmail("Admin", newBook);
			}

		} while (choice != 0);
	}

	public void displayBooks() {

		String response = controller.doAction("viewBooks*");

		if (!response.contains("Error")) {

			String[] books = response.split("\n");

			for (int i = 0; i < books.length; i++) {

				System.out.println(books[i]);

				// "постраничный" просмотр книг - по 3 штуки на "странице"
				if ((i + 1) % 3 == 0) {
					System.out.println("\nPress ENTER to continue watching the list of books...");
					getStringDataFromKeybord();
				}
			}
			System.out.println("That's all at the moment\n");
		} else {
			System.out.println(response);
		}

	}

	// поиск книг по параметрам
	public void searchBook() {

		StringBuilder searchData = new StringBuilder();
		searchData.append("searchBooks*");
		System.out.print("Please, set search parametres (press ENTER to skip item):\nauthor: ");
		searchData.append("author=" + getStringDataFromKeybord() + "|");
		System.out.print("title: ");
		searchData.append("title=" + getStringDataFromKeybord() + "|");
		System.out.print("Year of publication\nfrom (starting from 1445 AD): ");
		searchData.append("fromyear=" + getIntDataFromKeybord() + "|");

		System.out.print("to (" + currentYear + " max): ");
		searchData.append("toyear=" + getIntDataFromKeybord() + "|");
		System.out.print("type (1 - printed book, 2 - Ebook, 3 - both types): ");

		int bookType = 0;

		do {
			bookType = getIntDataFromKeybord();

			if (!(bookType == 1 || bookType == 2 || bookType == 3))
				System.out.println("Please, input 1 or 2 or 3");

		} while (!(bookType == 1 || bookType == 2 || bookType == 3));

		String type;

		switch (bookType) {
		case 1:
			type = "PrintedBook";
			break;
		case 2:
			type = "EBook";
			break;
		default:
			type = "";
		}

		searchData.append("type=" + type);
		System.out.println(controller.doAction(searchData.toString()));
	}

	public void announceBookByEmail(String recipient, String newBook) {

		System.out.print("Please, input your gmail account's login: ");
		String gMailLogin = getStringDataFromKeybord();
		System.out.print("Password: "); // можно было бы сохранять пароль от почты в файле и не вводить его и логин
										// вручную, но для библиотечной БД это слишком
		String eMailPassword = getStringDataFromKeybord();
		String action = "proposeBook*" + newBook + "|gMailLogin=" + gMailLogin + "|eMailPassword=" + eMailPassword
				+ "|recipient=" + recipient;
		controller.doAction(action);
	}

	public String askLoginInfo() {

		StringBuilder loginData = new StringBuilder();
		loginData.append("logination*login=");
		System.out.println("Please, enter your login and password (letters and numbers only).");
		System.out.print("Login: ");
		String login = getStringDataFromKeybord() + "|";
		System.out.print("Password: ");
		loginData.append(login + " password=");
		String password = getStringDataFromKeybord();
		loginData.append(password);

		return loginData.toString();
	}

	private String getStringDataFromKeybord() {
		return scanner.nextLine();
	}

	private int getIntDataFromKeybord() {

		while (!scanner.hasNextInt()) {
			System.out.print("Please, input a number: ");
			@SuppressWarnings("unused")
			String garbage = scanner.next();
		}

		int data = scanner.nextInt();

		return data;
	}

	public String askNewUserInfo(String userType) {

		StringBuilder registrationData = new StringBuilder();

		if (userType.equals("Admin"))
			registrationData.append("user=Admin|");

		if (userType.equals("Reader"))
			registrationData.append("user=Reader|");

		System.out.println("Please, enter data to registrate new user:");
		System.out.print("Name: ");
		registrationData.append("name=" + getStringDataFromKeybord() + "|");
		System.out.print("Login: ");
		registrationData.append("login=" + getStringDataFromKeybord() + "|");
		System.out.print("Password: ");
		registrationData.append("password=" + getStringDataFromKeybord() + "|");
		System.out.print("e-mail: ");
		registrationData.append("e-mail=" + getStringDataFromKeybord() + "| prefferedID=1");

		return registrationData.toString();
	}

	public void editBook(int id) {

		String response;

		String editingBook = controller.doAction("getBook*" + id);

		if (editingBook == null) {
			System.out.println("No such a book in the library.");
		} else {

			do {
				String[] bookData = editingBook.split("\\|");
				StringBuilder newBookData = new StringBuilder();

				System.out.println(
						"Please, change if you need to the details of the book (press ENTER to keep the current value:");
				System.out.print("Current title: " + bookData[1].trim() + "\n new title: ");
				getStringDataFromKeybord();
				newBookData.append("title=" + getStringDataFromKeybord() + "|");
				System.out.print("Current author: " + bookData[2].trim() + "\n new author: ");
				newBookData.append("author=" + getStringDataFromKeybord() + "|");
				System.out.print("Year of publication: " + bookData[3].trim() + "\n new year of publication: ");
				newBookData.append("year=" + getIntDataFromKeybord() + "|");

				System.out.print("Current type: " + bookData[4].trim() + "\n new type");

				String type;
				int bookType;

				do {

					System.out.print(" (input 1 for a printed book or 2 for a e-book): ");
					bookType = getIntDataFromKeybord();

				} while (!(bookType == 1 || bookType == 2));

				type = (bookType == 1) ? "PrintedBook" : "EBook";

				newBookData.append("type=" + type + " | prefferedID=" + id);

				controller.doAction("removeBook*id=" + id);
				response = controller.doAction("addBook*" + newBookData);

				if (response.contains("Incorrect")) {
					System.out.println(response + "\nTry again...");
				} else {
					System.out.println("All changes were saved.");
				}

			} while (response.contains("Incorrect"));
		}
	}

	public String askNewBookInfo() {

		StringBuilder newBookData = new StringBuilder();

		System.out.println("Please, enter the details to add a new book to the library:");
		System.out.print("Title: ");
		newBookData.append("title=" + getStringDataFromKeybord() + "|");
		System.out.print("Author: ");
		newBookData.append("author=" + getStringDataFromKeybord() + "|");
		System.out.print("Year of publication (from 1445 to " + currentYear + " AD): ");
		newBookData.append("year=" + getIntDataFromKeybord() + "|");

		String type;
		int bookType;

		do {

			System.out.print("Please, input type of the book (input 1 for a printed book or 2 for a e-book): ");
			bookType = getIntDataFromKeybord();

		} while (!(bookType == 1 || bookType == 2));

		type = (bookType == 1) ? "PrintedBook" : "EBook";

		newBookData.append("type=" + type + "|prefferedID=1");
		String newBook = newBookData.toString();
		getStringDataFromKeybord();

		return newBook;
	}

	public String askRemovingUser() {
		StringBuilder removingUserData = new StringBuilder();
		removingUserData.append("removeUser|id=");
		System.out.println("Please, enter removing user id:");
		int id = getIntDataFromKeybord();
		removingUserData.append(id);
		return removingUserData.toString();
	}

	public int askId() {

		System.out.println("Please, enter id:");
		return getIntDataFromKeybord();
	}

	public String askRemovingBook() {
		StringBuilder removingBookData = new StringBuilder();
		removingBookData.append("removeBook|id=");
		System.out.println("Please, enter removing book id:");
		int id = getIntDataFromKeybord();
		removingBookData.append(id);
		return removingBookData.toString();
	}
}
