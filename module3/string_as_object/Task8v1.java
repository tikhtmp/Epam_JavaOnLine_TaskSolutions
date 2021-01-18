/*
Условие: Вводится строка слов, разделённых пробелами. Найти самое длинное слово и
вывести его на экран. Случай, когда самых длинных слов может быть несколько, не обрабатывать.
 */

package by.epam_training.java_online.module3.string_as_object;

public class Task8v1 {

	public static void main(String[] args) {
		String testString = "Winter was coming and Soapy knew that he must make his preliminary plans.";
		System.out.println(testString);

		StringBuilder longestWord = new StringBuilder();
		int maxWord = 0;
		int indexOfMax = 0;

		for (int i = 0; i < testString.length(); i++) {

			int countLetter = 0;

			int j = i;

			while (j < testString.length() && testString.charAt(j) != ' ') {
				countLetter++;
				j++;
			}

			if (countLetter > maxWord) {
				maxWord = countLetter;
				indexOfMax = i;
			}
		}

		for (int i = indexOfMax; i < indexOfMax + maxWord; i++) {
			longestWord.append(testString.charAt(i));
		}

		System.out.println("The longest word in the sentence is: " + longestWord);

	}

}
