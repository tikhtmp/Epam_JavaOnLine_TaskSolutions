package by.epam_training.java_online.module6.task3_archive.view;

import java.util.Scanner;

import by.epam_training.java_online.module6.task3_archive.socket.AppClient;

public class View {
	private static Scanner scanner = new Scanner(System.in);
	private static String request;
	private static String response;
	private static AppClient appClient = new AppClient();

	public static void startApp() {

		boolean isCorrect;

		do {

			String login;
			String password;

			System.out.print("Please, input login and password\nlogin: ");
			login = scanner.nextLine();
			System.out.print("password: ");
			password = scanner.nextLine();

			request = "login:login=" + login + "|password=" + password;
			response = appClient.sendRequest(request);

			isCorrect = (response.equals("true") || response.equals("false"));

			if (!isCorrect) {
				System.out.println("response = " + response);
			} else if (response.equals("true")) {
				System.out.println("Hello, admin " + login + "!");
			} else if (response.equals("false")) {
				System.out.println("Hello, user " + login + "!");
			}

		} while (!isCorrect);

		if (response.equals("true"))
			adminMenu();

		if (response.equals("false"))
			userMenu();

		appClient.sendRequest("finishApp");

	}

	private static void userMenu() {
		findStudent();
	}

	private static void findStudent() {
		int choice = 1;
		String id = "0";

		do {
			System.out.print("Please, input student's id: ");
			id = scanner.nextLine();

			request = "getStudent:id=" + id;
			response = appClient.sendRequest(request);
			response = response.substring(0, response.length() - 1);
			System.out.println(response);

			System.out.print("Find another one (1 - yes, 0 - no)? ");
			choice = inputInt();

		} while (choice != 0);

	}

	private static void adminMenu() {
		int choice = -1;

		do {
			System.out.println("Please, choose action:\n1 - find student\n2 - add student\n3 - edit student\n0 - exit");
			choice = inputInt();

			switch (choice) {
			case 1:
				findStudent();
				break;
			case 2:
				addStudent();
				break;
			case 3:
				editStudent();
				break;

			default:
				break;
			}

		} while (choice != 0);
	}

	private static void editStudent() {
		String id;
		String name;
		String newId;
		String newName;
		boolean isFound = true;

		System.out.print("Please, input student's id: ");
		id = scanner.nextLine();

		request = "getStudent:id=" + id;
		response = appClient.sendRequest(request);

		if (response.contains("No student")) {
			System.out.println(response);
			isFound = false;
		}

		if (isFound) {
			id = response.split("\\|")[0].trim();
			name = response.split("\\|")[1].trim();
			name = name.substring(0, name.length() - 1);

			System.out.println("Please, input new id (current value - " + id + "):");
			newId = scanner.nextLine();
			System.out.println("Please, input new name (current value - " + name + "):");
			newName = scanner.nextLine();

			request = "deleteStudent:id=" + id;
			appClient.sendRequest(request);
			request = "addStudent:id=" + newId + "|name=" + newName;
			response = appClient.sendRequest(request);
		}
	}

	private static void addStudent() {
		String id;
		String name;

		System.out.print("Please, input new student's id and name:\nid: ");
		id = scanner.nextLine();
		System.out.print("name: ");
		name = scanner.nextLine();
		
		request = "addStudent:id=" + id + "|name=" + name;
		response = appClient.sendRequest(request);
		System.out.println(response);
	}

	private static int inputInt() {
		int result;

		while (!scanner.hasNextInt()) {
			scanner.next();
		}

		result = scanner.nextInt();

		if (scanner.nextLine() == "\n")
			scanner.next();

		return result;
	}

}
