/*
Basics of software code development.
�����. ������ 1.
�������� ���������, ��� ������������ ������ ����� ����� ������������� �����. � ��������� ���������
��� ����� �� 1 �� ���������� ������������� �����.
*/
package by.epam_training.java_online.module1.cicle;

import java.util.Scanner;

public class Task1 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.println("Input an integer number ");

		if (sc.hasNextInt()) {
			int i = sc.nextInt();
			int sum = 0;

			for (int j = 1; j <= i; j++) {
				sum = sum + j;
			}

			System.out.println("Sum = " + sum);

		} else
			System.out.println("You haven't inputed an integer number!");

	}

}
