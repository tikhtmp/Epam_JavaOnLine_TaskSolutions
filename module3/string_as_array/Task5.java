/*
Условие: Удалить в строке все лишние пробелы, то есть серии подряд идущих
пробелов заменить на одиночные пробелы. Крайние лишние пробелы удалить.
*/
package by.epam_training.java_online.module3.string_as_array;

public class Task5 {

	public static void main(String[] args) {

		char[] str = { ' ', ' ', ' ', 'H', 'o', 'w', ' ', 'm', 'a', 'n', 'y', ' ', 'w', 'o', 'r', 'd', 's', ' ', ' ',
				' ', ' ', '0', ' ', '2', '3', ' ', ' ', 'i', 'n', ' ', '4', '5', '6', ' ', 's', 'e', 'n', 't', 'e', 'n',
				'c', 'e', ' ', '"', 'I', ' ', 'h', 'a', 'v', 'e', ' ', 'n', 'o', ' ', ' ', ' ', '8', '8', ' ', 'a', 'b',
				'o', 'u', 't', ' ', ' ', ' ', 'i', 't', '"', '?', ' ', ' ', };

		System.out.println(str);

		for (int i = 0; i < str.length; i++) {

			if (str[i] == ' ') {

				int count = 0;

				while ((i + 1 + count < str.length) && str[i + 1 + count] == ' ') { // подсчет лишних пробелов
					count++;
				}

				if (str[0] == ' ') // если первый элемент тоже пробел
					count++;

				moveLine(str, i, count); // сдвиг массива влево на количество лишних пробелов
			}
		}

		int tailSpaces = 0;
		int j = str.length - 1;

		while (str[j] == ' ') { // подсчёт пробелов в конце строки
			tailSpaces++;
			j--;
		}

		char[] resultStr = new char[str.length - tailSpaces]; // формирование строки-результата

		for (int i = 0; i < resultStr.length; i++) {
			resultStr[i] = str[i];
		}

		System.out.println(resultStr);
	}

	/* сдвиг эл-в массива влево, начиная с индекса index на кол-во позиций number */
	static void moveLine(char[] line, int index, int number) {

		for (int i = index; i < line.length - number; i++) {
			line[i] = line[i + number];
		}

		for (int i = line.length - 1; i >= line.length - number; i--) {
			line[i] = ' '; // замена оставшихся после сдвига строки лишних символов пробелами
		}
	}

}
