/*
Basics of software code development.
Линейные программы.Задача 3.
Условие: Вычислить значение выражения по формуле (все переменные принимают действительные значения):
(sin(x) + cos(y)) / (cos(x) + sin(y)) * tg(xy)  
*/
package by.epam_training.java_online.module1.linear_programs;

public class Task3 {

	public static void main(String[] args) {
		double x = 0.5236;
		double y = 1.0472;
		double z = (Math.sin(x) + Math.cos(y)) / (Math.cos(y) + Math.sin(y)) * Math.tan(x * y);
		System.out.println(z);
	}
}
