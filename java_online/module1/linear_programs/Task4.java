/*
Basics of software code development.
Линейные программы.Задача 4.
Дано действительное число R вида nnn.ddd (три цифровых разряда в дробной и целой частях). Поменять местами
дробную и целую части числа и вывести полученное значение числа  
*/
package by.epam_training.java_online.module1.linear_programs;

public class Task4 {

	public static void main(String[] args) {
		double number = 123.789;
		System.out.println("Before " + number);
		double result = (number * 1000) % 1000 + (int) number / 1000.0;
		System.out.println("After " + result);
	}

}
