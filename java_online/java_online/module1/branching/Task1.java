/*
Basics of software code development.
Ветвления. Задача 1.
Даны два угла треугольника (в градусах). Определить, существует ли такой треугольник, и если да, то будет ли
он прямоугольным.  
*/

package by.epam_training.java_online.module1.branching;

public class Task1 {

	public static void main(String[] args) {
		double alfa = 45;
		double beta = 90;
		if (alfa + beta >= 180)
			System.out.println("This is not a triangle!");
		else if (alfa == 90 || beta == 90 || (180 - alfa - beta) == 90)
			System.out.println("This is a right triangle!");
		else
			System.out.println("This is not a right triangle!");
	}
}
