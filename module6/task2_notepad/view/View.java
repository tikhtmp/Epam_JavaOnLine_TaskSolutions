package by.epam_training.java_online.module6.task2_notepad.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import by.epam_training.java_online.module6.task2_notepad.controller.Controller;

public class View {

	private static Controller controller = new Controller();

	public static void startApp() {
		String dataToSave;
		String response;
		response = controller.doAction("getNotes* ");

		if (response.contains("Error")) {
			System.out.println("Error reading the file!");
		} else {

			String[] notesData = response.split("\n"); // данные считываются из файла
			List<String> notes = new ArrayList<String>(Arrays.asList(notesData));
			display(notes);

			// добавление новой записи
			System.out.println("Adding a new note:");
			String newNote = askNewNote();
			notes.add(newNote);
			display(notes);

			// найти записи по любому параметру или по их группе с сортировкой результата
			List<String> filteredNotes = new ArrayList<String>();
			String[] filteredData = findNotes();

			if (filteredData != null)
				filteredNotes = Arrays.asList(filteredData);

			display(filteredNotes);
			
			dataToSave = convertToFileFormat(notes);

			response = controller.doAction("saveFile*" + dataToSave); // данные сохраняются в файл

			if (response.contains("Error")) {
				System.out.println("Error writing the file!");
			}
		}

		System.out.println("End app...");
	}

	private static String[] findNotes() {
		StringBuilder request = new StringBuilder("findNotes*");
		String[] result;
		String topics;
		String startDate;
		String endDate;
		String email = null;
		String content = null;
		String comporator;
		int choice = -1;

		topics = InputData.askTopics();

		System.out.println("Please, input start date:");
		startDate = InputData.askDate();
		System.out.println("Please, input end date:");
		endDate = InputData.askDate();

		System.out.println("Add a filter for email (1 - yes, 0 - no)?");

		do {
			choice = InputData.inputInt();

			if (choice == 0) {
				email = ".+";
			}

			if (choice == 1) {
				System.out
						.println("Please, input pattern for looking notes by email (any symbols except '|' '=' '*'):");
				email = InputData.askRequestData();
			}

		} while (choice != 0 && choice != 1);

		choice = -1;

		System.out.println("Add a filter for content (1 - yes, 0 - no)?");
		do {
			choice = InputData.inputInt();

			if (choice == 0) {
				content = ".+";
			}

			if (choice == 1) {
				System.out.println(
						"Please, input pattern for looking notes by content (any symbols except '|' '=' '*'):");
				content = InputData.askRequestData();
			}
		} while (choice != 0 && choice != 1);

		comporator = InputData.askComporator();

		request.append("topics=" + topics + "|");
		request.append("startDate=" + startDate + "|");
		request.append("endDate=" + endDate + "|");
		request.append("email=" + email + "|");
		request.append("content=" + content + "|");
		request.append("comporator=" + comporator);
		System.out.println("\nFollowing has been found on the request:");
		String s = controller.doAction(request.toString());

		if (s == null) {
			System.out.println("Nothing has been found");
			return null;
		}

		result = s.split("\n");

		return result;
	}

	private static String askNewNote() {
		Map<Integer, String> topics = new HashMap<Integer, String>();
		String topic;
		String date;
		String content;
		String email;
		int month;
		int day;
		int year;
		Calendar calendar = Calendar.getInstance();

		topics = InputData.getTopics();
		topic = InputData.askTopic(topics); // тема заметки

		month = calendar.get(Calendar.MONTH) + 1;
		day = calendar.get(Calendar.DATE);
		year = calendar.get(Calendar.YEAR);
		date = (month + "-" + day + "-" + year); // дата создания заметки

		email = InputData.askEmail();
		content = InputData.askContent();

		return String.format("%-14s | %-15s | %-35s | %s", "topic=" + topic, "date=" + date, "email=" + email,
				"content=" + content + "\n");
	}

	public static void display(List<String> notes) {

		for (String line : notes) {
			String[] data = line.split("\\|");
			String topic = data[0].split("=")[1].trim();
			String date = data[1].split("=")[1].trim();
			String email = data[2].split("=")[1].trim();
			String content = data[3].split("=")[1].trim();
			System.out.printf("%8s :   %-10s | %-25s | %s \n", topic, date, email, content);
		}
	}

	private static String convertToFileFormat(List<String> list) {

		StringBuilder notes = new StringBuilder();

		for (String line : list) {

			notes.append(line);
			notes.append("\n");
		}

		return notes.toString();
	}
}
