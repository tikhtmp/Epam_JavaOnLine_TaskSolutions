/*
Basics of software code development.
�������� ���������. ������ 6.
��� ������ ������� ��������� �������� ���������, ������� �������� true, ���� ����� � ������������ (�, �)
����������� ����������� �������, � false � � ��������� ������:
*/

package by.epam_training.java_online.module1.linear_programs;

public class Task6 {

	public static void main(String[] args) {
		double x = 2.6;
		double y = 3.5;
		System.out.println(
				((x >= -4) && (x <= 4) && (y >= -3) && (y <= 0)) || ((x >= -2) && (x <= 2) && (y > 0) && (y <= 4)));
		x = -1.4;
		y = 3.2;
		System.out.println(
				((x >= -4) && (x <= 4) && (y >= -3) && (y <= 0)) || ((x >= -2) && (x <= 2) && (y > 0) && (y <= 4)));
	}
}
