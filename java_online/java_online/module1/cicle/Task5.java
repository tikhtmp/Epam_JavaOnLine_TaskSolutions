/*
Basics of software code development.
Циклы. Задача 5.
Даны числовой ряд и некоторое число е. Найти сумму тех членов ряда, модуль которых больше или равен
заданному е. Общий член ряда имеет вид:
an = 1/2^n + 1/3^n
*/
package by.epam_training.java_online.module1.cicle;

public class Task5 {

	public static void main(String[] args) {
		double n = 1;
		double sum = 0;
		double e = 0.01;
		double a = 0;

		while (true) {
			a = Math.abs(1 / Math.pow(2.0, n) + 1 / Math.pow(3.0, n));
			
			if (a >= e) {
				sum = sum + a;
				n = n + 1;
			} else
				break;
		}

		System.out.println("Sum " + sum);
	
	}

}
