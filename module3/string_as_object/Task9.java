/*
Условие: Посчитать количество строчных (маленьких) и прописных (больших) букв в введенной строке.
Учитывать только английские буквы.
 */

package by.epam_training.java_online.module3.string_as_object;

public class Task9 {

	public static void main(String[] args) {

		String testString = "Winter was coming and Soapy knew that he MUST make his preliminary plans.";
		System.out.println(testString);

		int numberOfUpper = 0;
		int numberOfLower = 0;

		for (int i = 0; i < testString.length(); i++) {

			if (Character.isUpperCase(testString.charAt(i))) {
				numberOfUpper++;
			}

			if (Character.isLowerCase(testString.charAt(i))) {
				numberOfLower++;
			}
		}

		System.out.println("Uppers = " + numberOfUpper);
		System.out.println("Lowers = " + numberOfLower);
	}
}
