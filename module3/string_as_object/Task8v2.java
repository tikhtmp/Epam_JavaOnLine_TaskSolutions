/*
Условие: Вводится строка слов, разделённых пробелами. Найти самое длинное слово и
вывести его на экран. Случай, когда самых длинных слов может быть несколько, не обрабатывать.
 */

package by.epam_training.java_online.module3.string_as_object;

public class Task8v2 {

	public static void main(String[] args) {

		String testString = "Winter was coming and Soapy knew that he must make his preliminary plans.";
		System.out.println(testString);

		String[] words = testString.split(" ");
		String longestWord = words[0];

		for (int i = 0; i < words.length; i++) {

			if (words[i].length() > longestWord.length()) {
				longestWord = words[i];
			}
		}

		System.out.println("The longest word in the sentence is: " + longestWord);

	}

}
