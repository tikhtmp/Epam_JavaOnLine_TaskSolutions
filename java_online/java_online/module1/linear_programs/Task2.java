/*
Basics of software code development.
Линейные программы.Задача 2.
Условие: Вычислить значение выражения по формуле (все переменные принимают действительные значения):
(b + sqrt(b^2 + 4ac)) / 2a + a^3c + b^-2
*/
package by.epam_training.java_online.module1.linear_programs;

public class Task2 {

	public static void main(String[] args) {
		double a = 1.2;
		double b = 8.3;
		double c = 2.8;
		System.out.println((b + Math.sqrt(b * b + 4 * a * c)) / (2 * a) - a * a * a * c + Math.pow(b, -2));
	}

}
