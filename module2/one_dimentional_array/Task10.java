package by.epam_training.java_online.module2.one_dimentional_array;

/* ������� ������: 
 * ��� ������������� ������ � ����������� ��������� �. ����� ������, �������� �� ���� ������ ������
 * ������� (�������������� �������� ��������� ������). ����������. �������������� ������ �� ������������.
*/

public class Task10 {

	public static void main(String[] args) {
		int[] array = { 15, 18, 1, 120, 18, 18, 4, -22, 18, -2, 18, 2, 2, -22, -22, 2, 2, 120, 1, 1, 1, 1, -22, -22 };
		Task10 task = new Task10();
		task.printArray(array);

		for (int i = 0; i < array.length; i++) {

			if ((i + 1) % 2 == 0) {
				array[i] = 0;
			}

		}

		task.printArray(array);

	}

	/* ����� ������� � ������� */
	public void printArray(int arr[]) {

		for (int num : arr) {
			System.out.print(num + " ");
		}

		System.out.println();
	}

}
