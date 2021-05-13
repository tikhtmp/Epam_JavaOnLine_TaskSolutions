package by.epam_training.java_online.module6.task2_notepad.dao.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.epam_training.java_online.module6.task2_notepad.bean.Criteria;
import by.epam_training.java_online.module6.task2_notepad.bean.Note;
import by.epam_training.java_online.module6.task2_notepad.dao.ComporatorFactory;
import by.epam_training.java_online.module6.task2_notepad.dao.DAO;
import by.epam_training.java_online.module6.task2_notepad.dao.DAOException;
import by.epam_training.java_online.module6.task2_notepad.dao.NoteConverter;

public class DAOImpl implements DAO {

	private static String SOURCE = "C:/Notepad/notes.txt";

	@Override
	public String getNotes() throws DAOException {
		StringBuilder notes = new StringBuilder();
		String line = "";
		File data = new File(SOURCE);

		try (BufferedReader reader = new BufferedReader(new FileReader(data))) {

			while ((line = reader.readLine()) != null) {
				notes.append(line).append("\n");
			}

		} catch (FileNotFoundException e) {
			throw new DAOException(e);
		} catch (IOException e1) {
			throw new DAOException(e1);
		}

		return notes.toString();
	}

	@Override
	public void saveNotes(String notes) throws DAOException {

		
		try (FileWriter writer = new FileWriter(SOURCE, false)) {
			writer.write(notes);
		} catch (IOException e) {
			throw new DAOException(e);
		}
	}

	@Override
	public String findNotes(Criteria criteria) throws DAOException {

		StringBuilder stringNotes = new StringBuilder();
		String result;
		String[] lines;
		String currentDate;
		String startDate = null;
		String endDate = null;
		String comparator = null;
		lines = getNotes().split("\\n");
		List<Note> notes = new ArrayList<Note>();

		Map<String, String> line = new HashMap<String, String>();
		boolean isFit;

		for (int i = 0; i < lines.length; i++) {
			isFit = true;
			line = NoteConverter.convertNotesIntoMap(lines[i]);
			currentDate = line.get("date");

			for (Entry<String, String> entry : criteria.getCriteries().entrySet()) {
				if (entry.getValue().equals("startDate".trim())) {
					startDate = entry.getKey().trim();
				}

				if (entry.getValue().equals("endDate".trim())) {
					endDate = entry.getKey().trim();
				}

				if (entry.getValue().equals("comporator".trim())) {
					comparator = entry.getKey().trim();
				}
			}

			isFit = checkLine(line, criteria);

			if (!checkPeriod(startDate, endDate, currentDate)) {
				isFit = false;
			}

			if (isFit)
				stringNotes.append(lines[i] + "\n");
		}

		if (stringNotes.length() < 1)
			return null;
		
		notes = NoteConverter.convertStringsIntoNotes(stringNotes.toString());
		Collections.sort(notes, ComporatorFactory.createComporator(comparator));
		result = NoteConverter.convertNotesIntoString(notes);

		return result;
	}

	private boolean checkLine(Map<String, String> line, Criteria criteria) {

		String regex;
		Pattern pattern;
		Matcher matcher;

		for (Entry<String, String> criteriaEntry : criteria.getCriteries().entrySet()) {

			for (Entry<String, String> noteEntry : line.entrySet()) {

				if (criteriaEntry.getValue().equals(noteEntry.getKey())) {

					regex = criteriaEntry.getKey().toString();
					pattern = Pattern.compile(regex);
					matcher = pattern.matcher(noteEntry.getValue());

					if (!matcher.find()) {
						return false;
					}
				}
			}
		}

		return true;
	}

	private boolean checkPeriod(String afterDate, String beforDate, String currentDate) {

		int[] start;
		int[] end;
		int[] current;

		start = parseDate(afterDate);
		end = parseDate(beforDate);
		current = parseDate(currentDate);

		Calendar startDate = new GregorianCalendar(start[0], start[1], start[2], 0, 0);
		startDate.add(Calendar.DAY_OF_YEAR, -1);
		Calendar endDate = new GregorianCalendar(end[0], end[1], end[2], 0, 0);
		endDate.add(Calendar.DAY_OF_YEAR, 1);
		Calendar date = new GregorianCalendar(current[0], current[1], current[2], 0, 0);

		return date.after(startDate) && date.before(endDate);
	}

	public static int[] parseDate(String date) {
		int[] dates = new int[3];
		dates[0] = Integer.parseInt(date.split("-")[2].trim());
		dates[1] = Integer.parseInt(date.split("-")[0].trim()) - 1;
		dates[2] = Integer.parseInt(date.split("-")[1].trim());
		return dates;
	}
}
