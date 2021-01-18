/*
Условие: Дан текст (строка). Найдите наибольшее количество подряд идущих пробелов в нём
*/

package by.epam_training.java_online.module3.string_as_object;

public class Task1 {

	public static void main(String[] args) {

		String testString = "    Winter was coming, and Soapy knew that he  must make his plans.     ";

		int count = 1;
		int maxSpaces = 1;
		boolean isSpace = false; // для проверки наличия хотя бы одного пробела

		for (int i = 0; i < testString.length(); i++) {

			if (Character.isSpaceChar(testString.charAt(i)) && isSpace == false) {
				isSpace = true;
			}

			if (i != testString.length() - 1 && Character.isSpaceChar(testString.charAt(i))
					&& Character.isSpaceChar(testString.charAt(i + 1))) {
				count++;

				if (count > maxSpaces) {
					maxSpaces = count;

					if (i == testString.length() - 3 // если самая длинная последовательность пробелов в конце строки
							&& Character.isSpaceChar(testString.charAt(testString.length() - 1))) {
						maxSpaces++;
					}

				}

			} else
				count = 1;

		}

		if (isSpace == false) {
			maxSpaces = 0;
			System.out.println("maxSpaces = " + maxSpaces);
		} else {
			System.out.println("maxSpaces = " + maxSpaces);
		}
	}
}
