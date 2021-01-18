/*
Условие: Проверить, является ли заданное слово палиндромом
*/
package by.epam_training.java_online.module3.string_as_object;

public class Task3 {

	public static void main(String[] args) {

		String word1 = "довод";
		String word2 = "доводы";

		isPalindrom1(word1);
		isPalindrom2(word1);
		isPalindrom1(word2);
		isPalindrom2(word2);
	}

	static boolean isPalindrom1(String str) {

		int length = str.length();

		for (int i = 0; i < length / 2; i++) {

			if (str.charAt(i) != str.charAt(length - i - 1)) {
				System.out.println("The word " + str + " is not a palindrom.");
				return false;
			}
		}

		System.out.println("The word \"" + str + "\" is a palindrom.");
		return true;
	}

	static boolean isPalindrom2(String str) {

		if (!str.equals(new StringBuilder(str).reverse().toString())) {

			System.out.println("The word " + str + " is not a palindrom.");
			return false;
		} else {
			System.out.println("The word \"" + str + "\" is a palindrom.");
			return true;
		}
	}
}
