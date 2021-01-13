/* Условие задачи:
На плоскости заданы своими координатами n точек. Написать метод(методы), определяющие, между какими
из пар точек самое большое расстояние. Указание. Координаты точек занести в массив.
*/

package by.epam_training.java_online.module2.decomposition;

import java.util.Arrays;

public class Task4 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		double[][] point = { { 2, 7 }, { 2, 7 }, { 6, 12 }, { 6, 11 }, { 6, 12 } };
		Task4 task = new Task4();
		double[] distance = new double[task.getNumberOfLines(point)];
		int k = 0;
		int l = 4;
		int m = 2;
		double maxDistance = -1.0;
		
		@SuppressWarnings("unused")
		double[] startPointMax = new double[2];
		double[] endPointMax = new double[2];
		double[] maxLength = new double[4];
		int[] maxLengthIndex = new int[2];

		for (int i = 0; i < point.length - 1; i++) {

			for (int j = i + 1; j < point.length; j++) {
				distance[k] = task.getDistance(point[i], point[j]);

				if (distance[k] == maxDistance) { // если максимальное расстояние одновременно между несколькими парами точек
					startPointMax = point[i];
					endPointMax = point[j];
					maxLength = Arrays.copyOf(maxLength, maxLength.length + 4);

					maxLength[l] = point[i][0];
					maxLength[l + 1] = point[i][1];
					maxLength[l + 2] = point[j][0];
					maxLength[l + 3] = point[j][1];
					l += 4;

					maxLengthIndex = Arrays.copyOf(maxLengthIndex, maxLengthIndex.length + 2);
					maxLengthIndex[m] = i + 1;
					maxLengthIndex[m + 1] = j + 1;
					m += 2;

				}

				if (distance[k] > maxDistance) {  // если максимальное расстояние между одной парой точек
					maxDistance = distance[k];
					startPointMax = point[i];
					endPointMax = point[j];

					maxLength = Arrays.copyOf(maxLength, 4);
					maxLengthIndex = Arrays.copyOf(maxLengthIndex, 2);
					l = 4;
					m = 2;

					maxLength[0] = point[i][0];
					maxLength[1] = point[i][1];
					maxLength[2] = point[j][0];
					maxLength[3] = point[j][1];

					maxLengthIndex[0] = i + 1;
					maxLengthIndex[1] = j + 1;

				}

				k++;
			}
		}

		task.printArray(distance);
		
		System.out.print("The max distance is: ");
		System.out.println(maxDistance);

		m = 0;

		for (int i = 0; i < maxLengthIndex.length; i += 2) {
			System.out.print("\nFrom point " + (maxLengthIndex[i]) + " : ");
			System.out.println("[" + maxLength[m] + ", " + maxLength[m + 1] + "]");
			System.out.print("  to point " + (maxLengthIndex[i + 1]) + " : ");
			System.out.println("[" + maxLength[m + 2] + ", " + maxLength[m + 3] + "]");
			m += 4;
		}

	}

	/* Расчет расстояния между точками */
	public double getDistance(double startPoint[], double endPoint[]) {
		return Math.sqrt((startPoint[0] - endPoint[0]) * (startPoint[0] - endPoint[0])
				+ (startPoint[1] - endPoint[1]) * (startPoint[1] - endPoint[1]));
	}

	/* Расчет количества расстояний между точками */
	public int getNumberOfLines(double[][] point) {
		int numberOfLines = 0;

		for (int i = 1; i < point.length; i++) {
			numberOfLines = numberOfLines + i;
		}

		return numberOfLines;
	}

	/* Вывод одномерного double массива в консоль */
	public void printArray(double arr[]) {

		for (double element : arr) {
			System.out.printf("%5f  ", element);
		}

		System.out.println();
	}
}
