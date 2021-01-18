/*
Условие: Подсчитать, сколько раз среди символов заданной строки встречается буква 'a'.
 */
package by.epam_training.java_online.module3.string_as_object;

public class Task5 {

	public static void main(String[] args) {

		String testString = "Winter was coming, and Soapy knew that he must make his plans.";
		System.out.println(testString);
		int count = 0;

		for (int i = 0; i < testString.length(); i++) {

			if (testString.charAt(i) == 'a')
				count++;
		}

		System.out.println("There are " + count + " 'a' in the sentence.");

	}

}
