/*
Basics of software code development.
���������. ������ 4.
������ ������� �, � �������������� ��������� � ������� �, �, z �������. ����������, ������� �� ������ �����
���������.
*/

package by.epam_training.java_online.module1.branching;

public class Task4 {

	public static void main(String[] args) {
		double a = 8;
		double b = 6;
		double x = 5;
		double y = 7;
		double z = 6;

		double min = Math.min(Math.min(x, y), z); // ����������� ������ �������
		double mid = x + y + z - min - Math.max(Math.max(x, y), z); // ������ ������� �� ������������ � �� �����������
																	// (�������).

		/*
		 * ���� ������� ������ ��������� ������ �������� ������� ������� � �������
		 * ������ ��������� ������ �������� ������� �������, �� ������ ��������.
		 */
		
		if (Math.min(a, b) > min && Math.max(a, b) > mid)
			System.out.println("The brick is fit");
		else
			System.out.println("The brick is not fit");
	}

}
