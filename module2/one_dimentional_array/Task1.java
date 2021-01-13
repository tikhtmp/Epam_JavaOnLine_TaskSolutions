/* Условие задачи:
 * В массив A [N] занесены натуральные числа. Найти сумму тех элементов, которые кратны данному К.
*/

package by.epam_training.java_online.module2.one_dimentional_array;

public class Task1 {

	public static void main(String[] args) {
		
		int[] a = { 1, 3, 6, 5, 12, 84 };
		int k = 3;
		int sum = 0;

		for (int num : a) {
			
			if (num % k == 0) {
				sum = sum + num;
			}
			
		}

		System.out.println(sum);

	}

}
