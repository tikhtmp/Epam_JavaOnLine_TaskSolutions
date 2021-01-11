/*
Basics of software code development.
Циклы. Задача 2.
Вычислить значения функции на отрезке [а,b] c шагом h:
х, если х > 2
-х, если х <= 2
*/
package by.epam_training.java_online.module1.cicle;

public class Task2 {

	public static void main(String[] args) {
		double a = -1;
		double b = 4;
		double h = 1;
		double y = 0;
		double result = 0;
		
		while (a <= b) {
			
			if (a <= 2)
				y = -a;
			else
				y = a;
			
			a = a + h;
			result = result + y;
		}
		
		System.out.println("Result " + result);
		
	}
	
}
