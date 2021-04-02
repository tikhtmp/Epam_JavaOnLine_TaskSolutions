/*
Модуль 4. Простейшие классы и объекты.
Задача 1.
Условие: Создайте класс Test1 с двумя переменными. Добавьте метод вывода на экран и методы изменения этих
переменных. Добавьте метод, который выводит сумму значений этих переменных, и метод, который находит
наибольшее значение из этих двух переменных. 
*/
package by.epam_training.java_online.module4.simple_classes.task1_test1;

public class Test1 {

	private int a = 0;
	private int b = 0;
	
	public Test1() {
	}

	public Test1(int a, int b) {
		this.a = a;
		this.b = b;
	}

	void showVars() {
		System.out.println("a = " + a);
		System.out.println("b = " + b);
	}

	public void setVarA(int a) {
		this.a = a;
	}

	public void setVarB(int b) {
		this.b = b;
	}

	public int sumVars() {
		return a + b;
	}

	public void findMost() {

		System.out.print("The most variable is: ");
		if (a > b) {
			System.out.println("a = " + a);
		} else if (a < b) {
			System.out.println("b = " + b);
		} else {
			System.out.println("variables are equal");
		}
	}

	public static void main(String[] args) {
		Test1 test = new Test1(1, 2);
		test.showVars();

		test.setVarA(8);
		test.setVarB(6);
		test.showVars();

		System.out.println("The sum of " + test.a + " and " + test.b + " is: " + test.sumVars());
		test.findMost();
	}
}
