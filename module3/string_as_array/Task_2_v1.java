/*
Условие: Замените в строке все вхождения 'word' на 'letter'.
*/
package by.epam_training.java_online.module3.string_as_array;

public class Task_2_v1 {

	public static void main(String[] args) {
		char[] stringIn = { 'H', 'o', 'w', ' ', 'm', 'a', 'n', 'y', ' ', 'w', 'o', 'r', 'd', 's', ' ', '"', 'w', 'o',
				'r', 'd', '"', ' ', 'i', 'n', ' ', 't', 'h', 'e', ' ', 's', 'e', 'n', 't', 'e', 'n', 'c', 'e', ' ', '"',
				'I', ' ', 'h', 'a', 'v', 'e', ' ', 'n', 'o', ' ', 'w', 'o', 'r', 'd', ' ', 'a', 'b', 'o', 'u', 't', ' ',
				'i', 't', '"', '?' };
		System.out.println(stringIn);
		char[] replace = { 'w', 'o', 'r', 'd' };
		char[] insert = { 'l', 'e', 't', 't', 'e', 'r' };

		char[] stringOut = replaceWord(insert, replace, stringIn);

		System.out.println(stringOut);

	}

	static char[] replaceWord(char[] in, char[] out, char[] str) {

		int count = 0;

		for (int i = 0; i < str.length - 4; i++) {

			if (str[i] == 'w' && str[i + 1] == 'o' && str[i + 2] == 'r' && str[i + 3] == 'd') {
				count++;
			}
		}

		char[] result = new char[str.length + count * (in.length - out.length)];

		for (int i = 0; i < str.length; i++) {
			result[i] = str[i];
		}

		for (int i = 0; i < result.length - 4; i++) {

			if (result[i] == 'w' && result[i + 1] == 'o' && result[i + 2] == 'r' && result[i + 3] == 'd') {

				for (int j = 0; j < i; j++) {
					result[j] = result[j];
				}

				for (int j = result.length - 1; j > i + 1; j--) {
					result[j] = result[j - 2];
				}

				for (int j = i, k = 0; j < i + in.length;) {
					result[j++] = in[k++];
				}
			}
		}
		return result;
	}

}
