/*
Basics of software code development.
�������� ���������.������ 5.
���� ����������� ����� �, ������� ������������ ������������ ���������� ������� � ��������. �������
������ �������� ������������ � �����, ������� � �������� � ��������� �����:
��� ����� SSc.  
*/
package by.epam_training.java_online.module1.linear_programs;

public class Task5 {

	public static void main(String[] args) {
		int t = 10145;
		int hour = t / 3600;
		int min = (t - hour * 3600) / 60;
		int sec = t - hour * 3600 - min * 60;
		if (hour < 10)
			System.out.print("0");
		System.out.print(hour + "h ");
		if (min < 10)
			System.out.print("0");
		System.out.print(min + "m ");
		if (sec < 10)
			System.out.print("0");
		System.out.println(sec + "s");
	}

}
