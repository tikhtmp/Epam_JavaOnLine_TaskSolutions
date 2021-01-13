/* Условие задачи:
Даны действительные числа a1 , a2 ,... , an . Найти max( a1 + a2n , a2 + a2n-1 ,... , an + an+1 ) .
*/

package by.epam_training.java_online.module2.one_dimentional_array;

public class Task7 {

	public static void main(String[] args) {
		double[] array = { 15.2, -18.8, 1.6, 120.7, 0.0, 45.6, -22.1 };
		int lastIndex = array.length - 1;
		double max = 0.0;

		for (int i = 0; i <= (lastIndex + 1) / 2; i++) {

			if (array[i] + array[lastIndex - i] > max) {
				max = array[i] + array[lastIndex - i];
			}

		}

		System.out.println(max);
	}

}
