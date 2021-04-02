package by.epam_training.java_online.module4.simple_classes.task9_book.logic;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import by.epam_training.java_online.module4.simple_classes.task9_book.entity.Book;
import by.epam_training.java_online.module4.simple_classes.task9_book.entity.BookShop;

public class ShopLogic {
	
	public static void sortBooks(BookShop shop) {
		Collections.sort(shop.getBooks());
	}

	public List<Book> chooseBooks(BookShop shop, String param)
			throws IllegalArgumentException, IllegalAccessException, SecurityException {

		List<Book> result = new ArrayList<Book>();
		List<Book> list = shop.getBooks();

		for (Book book : list) {
			
			if (hasParameter(book, param))
				result.add(book);
		}

		if (result.size() <= 0) {
			System.out.println("Nothing has been found for: " + param);
		}

		return result;
	}

	public boolean hasParameter(Book book, String param)
			throws IllegalArgumentException, IllegalAccessException, SecurityException {
		Field fields[] = book.getClass().getDeclaredFields();

		for (Field field : fields) {

			boolean isAccesiableFlag = true;

			if (!field.isAccessible()) {
				field.setAccessible(true);
				isAccesiableFlag = false;
			}

			if (field.get(book).equals(param)) {
				field.setAccessible(isAccesiableFlag);
				return true;
			}

			field.setAccessible(isAccesiableFlag); 
		}
		return false;
	}

	
	public static List<Book> filterList(BookShop shop, String param) {

		List<Book> result = new ArrayList<>();
		List<Book> list = shop.getBooks();

		for (Book book : list) {

			if (isContained(book, param)) {
				result.add(book);
			}
		}

		if (result.size() <= 0) {
			System.out.println("Nothing has been found for " + param);
		}

		return result;
	}

	public static boolean isContained(Book book, String param) {
		String[] str = getValues(book.toString());

		for (String item : str) {

			if (item.equals(param))
				return true;
		}

		return false;
	}

	public static String[] getValues(String str) {

		StringBuilder sb = new StringBuilder();
		String[] array = str.split("=");
		String[] result = new String[array.length];
		int k = 0;

		for (String s : array) {

			sb.append(s);
			char[] tmp = s.toCharArray();
			int j = 0;

			for (int i = tmp.length - 1; i >= 0; i--) {

				if (tmp[i] == ',' || tmp[i] == ']') {
					j = i;
					break;
				}

			}

			sb.delete(j, s.length());
			result[k++] = sb.toString();
			sb.delete(0, sb.length());
		}

		return result;
	}
	
	public static List<Book> filterList(BookShop shop, int year) {
		List<Book> result = new ArrayList<>();
		List<Book> list = shop.getBooks();

		for (Book book : list) {
			if ((book.getYearOfPublication().get(Calendar.YEAR) + 1) > year) {
				result.add(book);
			}
		}

		if (result.size() <= 0) {
			System.out.println("Nothing has been found after " + year + " year.");
		}

		return result;
	}
}