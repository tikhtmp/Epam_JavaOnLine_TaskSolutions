/*
 Условие: С помощью функции копирования и операции контеканации составить из частей слова
 "информатика" слово "торт".
 */
package by.epam_training.java_online.module3.string_as_object;

public class Task4 {

	public static void main(String[] args) {

		String informatica = "информатика";
		System.out.println(informatica);

		char[] informaticaArray = informatica.toCharArray();

		String tort = "";
		tort = tort.concat(String.copyValueOf(informaticaArray, 7, 1))
				.concat(String.copyValueOf(informaticaArray, 3, 2)).concat(String.copyValueOf(informaticaArray, 7, 1));
		System.out.println(tort);

		String tort1 = new String(
				informatica.substring(7, 8) + informatica.substring(3, 5) + informatica.substring(7, 8));
		System.out.println(tort1);

		StringBuilder tort2 = new StringBuilder();
		tort2.insert(0, informatica.substring(7, 8)).insert(1, informatica.substring(3, 4))
				.insert(2, informatica.substring(4, 5)).insert(3, informatica.substring(7, 8));
		System.out.println(tort2);

	}

}
