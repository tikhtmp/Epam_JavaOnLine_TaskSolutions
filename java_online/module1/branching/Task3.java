/*
Basics of software code development.
���������. ������ 3.
���� ��� ����� �(�1,�1), �(�2,�2) � �(�3,�3). ����������, ����� �� ��� ����������� �� ����� ������.
*/
package by.epam_training.java_online.module1.branching;

public class Task3 {

	public static void main(String[] args) {
		double x1 = 1;
		double y1 = 1;
		double x2 = 2;
		double y2 = 2;
		double x3 = 3;
		double y3 = 3;
		
		if ((y2 - y1) / (x2 - x1) == (y3 - y1) / (x3 - x1))
			System.out.println("This is a strihgt line");
		else
			System.out.println("This is not a strihgt line");
	}

}
