/* Условие задачи:
Вычислить площадь правильного шестиугольника со стороной а, используя метод вычисления площади
треугольника.
*/

package by.epam_training.java_online.module2.decomposition;

public class Task3 {

	public static void main(String[] args) {
		Task3 task = new Task3();
		double a = 8;
		System.out.println("The area of the hexagon is: " + task.getAreaTriangle(a) * 6);

	}

	public double getAreaTriangle(double a) {
		return Math.sqrt(3) * a * a / 4;
	}

}
