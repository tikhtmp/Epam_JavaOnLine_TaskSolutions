/*
Basics of software code development.
Ветвления. Задача 2.
Найти max{min(a, b), min(c, d)}.
*/

package by.epam_training.java_online.module1.branching;

public class Task2 {

	public static void main(String[] args) {
		double a = 1.2;
		double b = 3.4;
		double c = 5.6;
		double d = 7.8;

		double min1 = (a < b) ? a : b;
		double min2 = (c < d) ? c : d;
		double max = (min1 > min2) ? min1 : min2;
		
		System.out.println(max);

	}
}