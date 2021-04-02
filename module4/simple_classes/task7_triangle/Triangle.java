/*
Модуль 4. Простейшие классы и объекты. 
Задача 7.
Описать класс, представляющий треугольник. Предусмотреть методы для создания объектов, вычисления 
площади, периметра и точки пересечения медиан.
*/
package by.epam_training.java_online.module4.simple_classes.task7_triangle;

import java.util.Arrays;

public class Triangle {
	private double[] point1 = new double[2];
	private double[] point2 = new double[2];
	private double[] point3 = new double[2];
	double side1 = 0.0;
	double side2 = 0.0;
	double side3 = 0.0;

	public Triangle() {
	}

	public Triangle(int x1, int y1, int x2, int y2, int x3, int y3) {

		boolean isNotTriangle = (((x1 == x2 && y1 == y2) || (x1 == x3 && y1 == y3) || (x2 == x3 && y2 == y3))
				|| ((x1 - x3) * (y2 - y3) - (x2 - x3) * (y1 - y3) == 0));

		if (isNotTriangle) {
			System.out.println("Points\n" + x1 + "," + y1 + "\n" + +x2 + "," + y2 + "\n" + x3 + "," + y3 + "\n"
					+ "don't make a triangle!");
		} else {
			this.point1[0] = x1;
			this.point1[1] = y1;
			this.point2[0] = x2;
			this.point2[1] = y2;
			this.point3[0] = x3;
			this.point3[1] = y3;
			this.side1 = Math
					.sqrt(Math.pow(this.point1[0] - this.point2[0], 2) + Math.pow(this.point1[1] - this.point2[1], 2));
			this.side2 = Math
					.sqrt(Math.pow(this.point1[0] - this.point3[0], 2) + Math.pow(this.point1[1] - this.point3[1], 2));
			this.side3 = Math
					.sqrt(Math.pow(this.point3[0] - this.point2[0], 2) + Math.pow(this.point3[1] - this.point2[1], 2));
		}
	}
	

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;

		Triangle other = (Triangle) obj;
		
		if (!Arrays.equals(point1, other.point1))
			return false;
		
		if (!Arrays.equals(point2, other.point2))
			return false;
		
		if (!Arrays.equals(point3, other.point3))
			return false;
		
		if (Double.doubleToLongBits(side1) != Double.doubleToLongBits(other.side1))
			return false;
		
		if (Double.doubleToLongBits(side2) != Double.doubleToLongBits(other.side2))
			return false;
		
		if (Double.doubleToLongBits(side3) != Double.doubleToLongBits(other.side3))
			return false;
		
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(point1);
		result = prime * result + Arrays.hashCode(point2);
		result = prime * result + Arrays.hashCode(point3);
		long temp;
		temp = Double.doubleToLongBits(side1);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(side2);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(side3);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public String toString() {
		return getClass().getSimpleName() + " [point1=" + Arrays.toString(point1) + ", point2="
				+ Arrays.toString(point2) + ", point3=" + Arrays.toString(point3) + ", side1=" + side1 + ", side2="
				+ side2 + ", side3=" + side3 + "]";
	}

	private double[] findIntersectionOfMedians() {

		double[] medianaPoint = new double[2];
		double[] mediumSidePoint = new double[2];
		
		mediumSidePoint[0] = (point2[0] + point3[0]) / 2;
		mediumSidePoint[1] = (point2[1] + point3[1]) / 2;
		medianaPoint[0] = (point1[0] + 2 * mediumSidePoint[0]) / 3;
		medianaPoint[1] = (point1[1] + 2 * mediumSidePoint[1]) / 3;

		return medianaPoint;
	}

	public double сalculatePerimeter() {
		return side1 + side2 + side3;
	}

	public double сalculateArea() {
		double halfPerimeter = сalculatePerimeter() / 2;
		return Math.sqrt(halfPerimeter * (halfPerimeter - this.side1) * (halfPerimeter - this.side2)
				* (halfPerimeter - this.side3));
	}

	public static void main(String[] args) {

		Triangle triangle = new Triangle(1, 2, 5, 4, 5, 2);

		System.out.printf("%s %.3f\n", "The area of the triangle is: ", triangle.сalculateArea());

		System.out.printf("%s %.3f\n", "The perimeter of the triangle is: ", triangle.сalculatePerimeter());

		double[] mediansIntersectionPoint = triangle.findIntersectionOfMedians();
		System.out.printf("%s %.3f %s %.3f\n", "Coordinates of intersection of the medians are:",
				mediansIntersectionPoint[0], ":", mediansIntersectionPoint[1]);
	}
}
