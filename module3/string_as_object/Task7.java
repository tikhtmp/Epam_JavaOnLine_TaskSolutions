/*
Условие: Вводится строка. Требуется удалить из неё повторяющиеся символы и все пробелы. Например, 
если было введено "abc cde def", то должно быть выведено "abcdef".
 */
package by.epam_training.java_online.module3.string_as_object;

public class Task7 {

	public static void main(String[] args) {

		String testString = "WWintter was cooooming, and Soapy kneeew that he muuuust make his plans..... ";

		System.out.println(testString);

		StringBuilder str = new StringBuilder(testString);

		for (int i = 0; i < str.length() - 1; i++) {

			for (int j = i + 1; j < str.length(); j++) {

				if (str.charAt(i) == str.charAt(j) || str.charAt(j) == ' ') {
					str.deleteCharAt(j);
					j--; // на случай, если символы повторяются последовательно ('ooo')
				}
			}
		}

		testString = str.toString();
		System.out.println(testString);
	}
}