/*
Basics of software code development.
Ветвления. Задача 5.
Вычислить значение функции:
x^2 - 3x + 9, если х <= 3
1 / (x^3 + 6), если х > 3
*/

package by.epam_training.java_online.module1.branching;

public class Task5 {

	public static void main(String[] args) {
		double x = 4.0;
		if (x <= 3)
			System.out.println("Result " + (x * x - 3 * x + 9));
		else
			System.out.println("Result " + (1 / (x * x * x + 6)));

	}

}
