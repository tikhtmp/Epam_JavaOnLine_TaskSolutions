/*
Basics of software code development.
Циклы. Задача 3.
Найти сумму квадратов первых ста чисел.
*/
package by.epam_training.java_online.module1.cicle;

public class Task3 {

	public static void main(String[] args) {
		int sum = 0;
		
		for (int i = 1; i < 101; i++) {
			sum += i * i;
		}
		System.out.println("Sum = " + sum);
	}

}
