package by.epam_training.java_online.module6.task2_notepad.dao;

import java.util.Calendar;
import java.util.Comparator;
import java.util.GregorianCalendar;

import by.epam_training.java_online.module6.task2_notepad.bean.Note;
import by.epam_training.java_online.module6.task2_notepad.dao.impl.DAOImpl;

public class ComporatorFactory {

	public static Comparator<Note> createComporator(String type) {

		switch (type) {

		case "topic":
			return new Comparator<Note>() {
				@Override
				public int compare(Note n1, Note n2) {
					return n1.getTopic().compareTo(n2.getTopic());
				}
			};

		case "date":
			return new Comparator<Note>() {
				@Override
				public int compare(Note n1, Note n2) {
					int[] n1Dates = DAOImpl.parseDate(n1.getCreationDate());
					int[] n2Dates = DAOImpl.parseDate(n2.getCreationDate());
					Calendar n1Calendar = new GregorianCalendar(n1Dates[0], n1Dates[1], n1Dates[2]);
					Calendar n2Calendar = new GregorianCalendar(n2Dates[0], n2Dates[1], n2Dates[2]);
					return n1Calendar.compareTo(n2Calendar);
				}
			};

		case "email":
			return new Comparator<Note>() {
				@Override
				public int compare(Note n1, Note n2) {
					return n1.getEmail().compareTo(n2.getEmail());
				}
			};

		case "content":
			return new Comparator<Note>() {
				@Override
				public int compare(Note n1, Note n2) {
					return n1.getContent().compareTo(n2.getContent());
				}
			};

		default:
			return null;

		}
	}

}
