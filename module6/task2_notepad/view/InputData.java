package by.epam_training.java_online.module6.task2_notepad.view;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import by.epam_training.java_online.module6.task2_notepad.controller.Controller;
import by.epam_training.java_online.module6.task2_notepad.view.validation.Validator;

public class InputData {
	private static Scanner scanner = new Scanner(System.in);
	private static Controller controller = new Controller();

	public static String askDate() {
		int month;
		int day;
		int year;
		boolean isValid;

		do {
			System.out.print("Please, input month(1-12):");
			month = inputInt();
			System.out.print("Please, input day(1-31):");
			day = inputInt();
			System.out.print("Please, input year(0-2100):");
			year = inputInt();
			isValid = Validator.validateDate(month, day, year);

			if (!isValid) {
				System.out.println("Wrong data! Try again...");
			}

		} while (!isValid);

		scanner.nextLine();
		return month + "-" + day + "-" + year;
	}

	public static String askComporator() {

		int choice = 0;
		String comporator;
		boolean isValid = false;

		do {
			System.out.print(
					"Please, choose a variant to sort notes by:\n 1 - topic\n 2 - date\n 3 - email\n 4 - content\n");
			choice = inputInt();

			if (choice == 1 || choice == 2 || choice == 3 || choice == 4)
				isValid = true;

			if (!isValid) {
				System.out.println("Wrong choice! Try again...");
			}

		} while (!isValid);

		switch (choice) {
		case 1:
			comporator = "topic";
			break;
		case 2:
			comporator = "date";
			break;
		case 3:
			comporator = "email";
			break;
		case 4:
			comporator = "content";
			break;
		default:
			comporator = null;
		}

		return comporator;
	}

	public static String askTopics() {

		String result = null;
		StringBuilder choosenTopics = new StringBuilder();
		int choice;
		int topicChoice = 1;
		Map<Integer, String> topics = new HashMap<Integer, String>();

		topics = getTopics();
		Set<Integer> topicSet = new HashSet<Integer>(topics.size());

		System.out.println("\nPlease, choose topics (choose 0 to look for all topics, 1 - to specify topics):");

		choice = inputInt();

		if (choice == 0) {

			for (Entry<Integer, String> entry : topics.entrySet()) {
				choosenTopics.append(entry.getValue() + ",");
			}

			choosenTopics.deleteCharAt(choosenTopics.length() - 1);// удаление последней запятой
			result = choosenTopics.toString();

			return result;
		}

		do {
			topicChoice = inputTopic(topics);
			topicSet.add((Integer) topicChoice);
			System.out.print("You have chosen following topics: ");

			for (Entry<Integer, String> entry : topics.entrySet()) {

				if (topicSet.contains(entry.getKey())) {
					System.out.print(entry.getValue() + ", ");
				}
			}

			System.out.println("\nAdd another topic (0 - no, 1 - yes)?");
			topicChoice = inputInt();

		} while (topicChoice != 0);

		for (Entry<Integer, String> entry : topics.entrySet()) {

			if (topicSet.contains(entry.getKey())) {
				choosenTopics.append(entry.getValue() + ",");
			}
		}

		choosenTopics.deleteCharAt(choosenTopics.length() - 1);// удаление последней запятой
		result = choosenTopics.toString();

		return result;
	}

	public static String askEmail() {
		String email;
		boolean isValid = false;
		scanner.nextLine();

		do {
			System.out.println("Please, input email address:");

			email = scanner.nextLine();
			isValid = Validator.validateEmail(email);

			if (!isValid)
				System.out.println("Wrong email! Try again...");

		} while (!isValid);

		return email;
	}

	public static String askContent() {
		String content = null;
		boolean isValid = true;

		do {
			System.out.println("Please, input data (any symbols except '|' '=' '*'):");
			content = scanner.nextLine();
			isValid = Validator.validateContent(content);

			if (!isValid)
				System.out.println("You can use any symbols except '|' '=' '*' ! Try again...");

		} while (!isValid);

		return content;
	}

	public static String askRequestData() {
		String data = null;
		boolean isValid = true;
		scanner.nextLine();

		do {
			data = scanner.nextLine();
			isValid = Validator.validateContent(data);

			if (!isValid)
				System.out.println("You can use any symbols except '|' '=' '*' ! Try again...");

		} while (!isValid);

		return data;
	}

	public static String askTopic(Map<Integer, String> topics) {
		String topic;
		int choice;

		System.out.println("Please, choose the topic:");
		choice = inputTopic(topics);
		topic = topics.get(choice);

		return topic;
	}

	private static int inputTopic(Map<Integer, String> topics) {

		int numberOfTopic = topics.size();

		int choice;
		boolean isFit = false;

		do { // запрос темы заметки

			displayTopics(topics);
			choice = 0;
			choice = inputInt();

			// проверка введенного числа на соответствие диапазону
			isFit = Validator.validateTopic(choice, numberOfTopic);

			if (!isFit) {
				System.out.println("Wrong number! Try again...");
			}

		} while (!isFit);

		return choice;
	}

	public static Map<Integer, String> getTopics() {

		String topicList = controller.doAction("getTopics* "); // запрос тем из перечисления
		String[] topicData = topicList.split("\n");
		int numberOfTopic = topicData.length;
		Map<Integer, String> topics = new HashMap<Integer, String>();
		int num;
		String topicName;

		for (int i = 0; i < numberOfTopic; i++) {
			num = Integer.parseInt(topicData[i].split("\\-")[0].trim());
			topicName = topicData[i].split("\\-")[1].trim();
			topics.put(num, topicName);
		}

		return topics;
	}

	public static int inputInt() {
		int result;

		while (!scanner.hasNextInt()) {
			scanner.next();
		}

		result = scanner.nextInt();

		return result;
	}

	private static void displayTopics(Map<Integer, String> topics) {

		for (Entry<Integer, String> entry : topics.entrySet()) {
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}
	}
}
