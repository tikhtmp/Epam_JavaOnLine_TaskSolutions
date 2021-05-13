package by.epam_training.java_online.module6.task2_notepad.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import by.epam_training.java_online.module6.task2_notepad.bean.Note;
import by.epam_training.java_online.module6.task2_notepad.bean.Topic;

public class NoteConverter {

	public static Map<String, String> convertNotesIntoMap(String line) {
		Map<String, String> note = new HashMap<String, String>();
		String data[];
		String key;
		String value;
		data = line.split("\\|");

		for (int i = 0; i < data.length; i++) {
			key = data[i].split("=")[0].trim();
			value = data[i].split("=")[1].trim();
			note.put(key, value);
		}

		return note;
	}

	public static String convertNotesIntoString(List<Note> notesList) {

		StringBuilder notes = new StringBuilder();

		for (Note n : notesList) {

			String line = String.format("%-14s | %-15s | %-35s | %s", "topic=" + n.getTopic(),
					"date=" + n.getCreationDate(), "email=" + n.getEmail(), "content=" + n.getContent() + "\n");
			notes.append(line);
		}

		return notes.toString();
	}

	public static List<Note> convertStringsIntoNotes(String stringNotes) {

		List<Note> notes = new ArrayList<Note>();
		String[] dataLines = stringNotes.split("\\n");
		String stringTopic;
		String date;
		String email;
		String content;
		Topic topic;

		for (int i = 0; i < dataLines.length; i++) {

			String[] data = dataLines[i].split("\\|");

			stringTopic = data[0].split("=")[1].trim();
			date = data[1].split("=")[1].trim();
			email = data[2].split("=")[1].trim();
			content = data[3].split("=")[1].trim();
			topic = Topic.valueOf(stringTopic);
			notes.add(new Note(topic, date, email, content));
		}

		return notes;
	}
}
