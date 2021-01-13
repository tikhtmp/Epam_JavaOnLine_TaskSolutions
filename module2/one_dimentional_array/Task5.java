/* Условие задачи:
  Даны целые числа а1 ,а2 ,..., аn . Вывести на печать только те числа, для которых а[i] > i.
*/

package by.epam_training.java_online.module2.one_dimentional_array;

public class Task5 {

	public static void main(String[] args) {

		int[] array = { 10, 1, 6, 2, 7, -8, 4 };

		for (int i = 0; i < array.length; i++) {

			if (array[i] > i) {
				System.out.print(array[i] + " ");
			}
		}
	}
}
