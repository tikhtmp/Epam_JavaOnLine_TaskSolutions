/*
Basics of software code development.
Циклы. Задача 6.
Вывести на экран соответствий между символами и их численными обозначениями в памяти компьютера.
*/
package by.epam_training.java_online.module1.cicle;

public class Task6 {

	public static void main(String[] args) {

		for (int i = 1; i < 258; i++) {

			System.out.print(i + " = \'" + (char) i + "\'   ");

			if (i % 10 == 0)
				System.out.println();
		}
	}

}
