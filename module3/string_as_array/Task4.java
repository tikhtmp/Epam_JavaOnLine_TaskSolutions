/*
Условие: В строке найти количество чисел
Моё примечание: Числом будет считаться последовательность вида 1234.567, т.е.
последовательность цифр без деления запятыми на разряды и с точкой в качестве 
указателя начала дробной части
*/

package by.epam_training.java_online.module3.string_as_array;

public class Task4 {

	public static void main(String[] args) {
		char[] str = { '2', '2', ' ', 'H', 'o', 'w', ' ', 'm', 'a', 'n', 'y', ' ', 'w', 'o', 'r', 'd', 's', ' ', '"',
				'0', '.', '2', '3', '"', ' ', 'i', 'n', ' ', '4', '5', '6', ' ', 's', 'e', 'n', 't', 'e', 'n', 'c', 'e',
				' ', '"', 'I', ' ', 'h', 'a', 'v', 'e', ' ', 'n', 'o', ' ', '0', '1', '8', '8', ' ', 'a', 'b', 'o', 'u',
				't', ' ', 'i', 't', '"', '?' };

		System.out.println(str);

		int count = 0;

		if (Character.isDigit(str[0])) // если первый символ цифра.
			count++;

		for (int i = 1; i < str.length; i++) {

			/* если цифра, а перед ней не цифра и не точка */
			if (Character.isDigit(str[i]) && !Character.isDigit(str[i - 1]) && str[i - 1] != '.') {
				count++;
			}

		}
		System.out.println("The line has " + count + " numbers.");
	}

}
