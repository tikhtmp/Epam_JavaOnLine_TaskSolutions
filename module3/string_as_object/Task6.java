/*
 Условие: Из заданной строки получить новую, повторив каждый символ дважды.
 */
package by.epam_training.java_online.module3.string_as_object;

public class Task6 {

	public static void main(String[] args) {
		String testString = "Winter was coming, and Soapy knew that he must make his plans.";
		System.out.println(testString);

		StringBuilder result = new StringBuilder();

		for (int i = 0; i < testString.length(); i++) {
			result.append(testString.charAt(i)).append(testString.charAt(i));
		}

		testString = result.toString();
		System.out.println(testString);

	}

}
