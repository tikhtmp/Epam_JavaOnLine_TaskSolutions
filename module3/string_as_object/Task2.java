/*
Условие: В строке после каждого символа 'a' вставить 'b'
*/

package by.epam_training.java_online.module3.string_as_object;

public class Task2 {

	public static void main(String[] args) {

		String testString = "Winter was coming, and Soapy knew that he must make his plans.";
		System.out.println(testString);

		StringBuffer sb = new StringBuffer(testString);
		int j = 0;

		for (int i = 0; i < testString.length(); i++) {
			
			if (testString.charAt(i) == 'a') {
				sb.insert(i + 1 + j, "b");
				j++;
			}
		}

		testString = sb.toString();
		System.out.println(testString);
	}
}
