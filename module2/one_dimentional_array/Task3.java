package by.epam_training.java_online.module2.one_dimentional_array;

/* Условие задачи:
 * Дан массив действительных чисел, размерность которого N. Подсчитать, сколько в нем отрицательных,
 * положительных и нулевых элементов.
*/

public class Task3 {

	public static void main(String[] args) {

		double[] array = { 15.2, -18.8, 1.6, 120.7, 0.0, 45.6, -22.1 };
		int counterPositive = 0;
		int counterNegative = 0;
		int counterZero = 0;

		for (double member : array) {

			if (member > 0) {
				counterPositive++;
			} else if (member == 0) {
				counterZero++;
			} else if (member < 0) {
				counterNegative++;
			}
		}

		System.out.println("Number of negative members: " + counterNegative);
		System.out.println("Number of zero members: " + counterZero);
		System.out.println("Number of positive members: " + counterPositive);

	}

}
