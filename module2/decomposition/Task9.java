/* Условие задачи:
Даны числа X, Y, Z, Т — длины сторон четырехугольника. Написать метод(методы) вычисления его площади,
если угол между сторонами длиной X и Y— прямой.
*/

package by.epam_training.java_online.module2.decomposition;

public class Task9 {

	public static void main(String[] args) {

		Task9 task = new Task9();
		double x = 4.0;
		double y = 3.0;
		double z = 5.0;
		double t = 2.0;

		System.out.println(task.getTetragonArea(x, y, z, t));

	}

	/* Расчет площади треугольника по трем сторонам */
	public double getTriangleArea(double a, double b, double c) {
		double halfPerimeter = (a + b + c) / 2;
		return Math.sqrt(halfPerimeter * (halfPerimeter - a) * (halfPerimeter - b) * (halfPerimeter - c));
	}

	/* Расчет площади четырехугольника с прямым углом между сторонами x и у */
	public double getTetragonArea(double x, double y, double z, double t) {
		double area = 0.0;
		double diag = Math.sqrt(x * x + y * y);
		area = getTriangleArea(x, y, diag) + getTriangleArea(z, t, diag);
		return area;
	}

}
