/*
Basics of software code development.
�������� ���������.������ 4.
���� �������������� ����� R ���� nnn.ddd (��� �������� ������� � ������� � ����� ������). �������� �������
������� � ����� ����� ����� � ������� ���������� �������� �����  
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
