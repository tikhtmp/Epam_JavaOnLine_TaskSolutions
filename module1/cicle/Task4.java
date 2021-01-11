/*
Basics of software code development.
Циклы. Задача 4.
Составить программу нахождения произведения квадратов первых двухсот чисел.
*/
package by.epam_training.java_online.module1.cicle;

public class Task4 {

	public static void main(String[] args) {
		double product = 1;
		double current = 1;
		int max = 0;

		for (int i = 1; i < 201; i++) {
			current = current * i * i;

			if (current == Double.POSITIVE_INFINITY) {
				System.out.println("Overfilling for number " + i + "!");
				break;
			} else {
				product = current;
				max = i;
			}

		}

		System.out.println("Max number = " + max);
		System.out.println("Product = " + product);
	}

}
