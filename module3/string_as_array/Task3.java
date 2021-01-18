/*
Условие: В строке найти количество цифр
*/

package by.epam_training.java_online.module3.string_as_array;

public class Task3 {

	public static void main(String[] args) {

		char[] str = { 'H', 'o', 'w', ' ', 'm', 'a', 'n', 'y', ' ', 'w', 'o', 'r', 'd', 's', ' ', '"', '1', '2', 'r',
				'3', '"', ' ', 'i', 'n', ' ', 't', 'h', 'e', ' ', 's', 'e', 'n', 't', 'e', 'n', 'c', 'e', ' ', '"', 'I',
				' ', 'h', 'a', 'v', 'e', ' ', 'n', 'o', ' ', 'w', 'o', 'r', 'd', ' ', 'a', 'b', 'o', 'u', 't', ' ', '8',
				'8', '"', '?' };

		System.out.println(str);
		int count = 0;

		for (int i = 0; i < str.length; i++) {
			if (Character.isDigit(str[i])) {
				count++;
			}
		}

		System.out.println("The string has " + count + " figures.");

	}

}
