/* Условие задачи:
 Дана последовательность действительных чисел а1 ,а2 ,..., ап. Заменить все ее члены, большие данного Z, этим
 числом. Подсчитать количество замен.
*/

package by.epam_training.java_online.module2.one_dimentional_array;

public class Task2 {
	
	public static void main(String[] args) {
		double[] array = { 15.2, 18.8, 1.6, 120.7, 45.6 };
		double z = 18.4;
		int counter = 0;
		
		Task2 task = new Task2();
		task.printArray(array);
		
		for (int i = 0; i < array.length; i++) {
			
			if(array[i] > z) {
				array[i] = z;
				counter++;
			}
		
		}
		
		task.printArray(array);
		System.out.println("The number of members replaced is " + counter);
	}
	
	public void printArray(double arr[]) {
		
		for(double num : arr ) {
			System.out.print(num + " ");
		}
		
		System.out.println();		
	}

}
