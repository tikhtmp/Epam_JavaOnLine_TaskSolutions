/*
Basics of software code development.
Ветвления. Задача 4.
Заданы размеры А, В прямоугольного отверстия и размеры х, у, z кирпича. Определить, пройдет ли кирпич через
отверстие.
*/

package by.epam_training.java_online.module1.branching;

public class Task4 {

	public static void main(String[] args) {
		double a = 8;
		double b = 6;
		double x = 5;
		double y = 7;
		double z = 6;

		double min = Math.min(Math.min(x, y), z); // минимальный размер кирпича
		double mid = x + y + z - min - Math.max(Math.max(x, y), z); // размер кирпича не максимальный и не минимальный
																	// (средний).

		/*
		 * Если меньший размер отверстия больше меньшего размера кирпича и больший
		 * размер отверстия больше среднего размера кирпича, то кирпич проходит.
		 */
		
		if (Math.min(a, b) > min && Math.max(a, b) > mid)
			System.out.println("The brick is fit");
		else
			System.out.println("The brick is not fit");
	}

}
