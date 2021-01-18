/*
Условие: Замените в строке все вхождения 'word' на 'letter'.
*/
package by.epam_training.java_online.module3.string_as_array;

public class Task_2_v2 {

	public static void main(String[] args) {
		String str = "How many words \"word\" in the sentence \"I have no word about it\"?";
		System.out.println(str);
		System.out.println(str.replace("word", "letter"));
	}

}
