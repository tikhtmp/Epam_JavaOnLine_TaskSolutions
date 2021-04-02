/*
Модуль 4. Простейшие классы и объекты.
Задача 2.
Условие: Создайте класс Test2 с двумя переменными. Добавьте конструктор с входными параметрами. Добавьте 
конструктор, инициализирующий члены класса по умолчанию. Добавьте set- и get- методы для полей экземпляра
класса.
*/

package by.epam_training.java_online.module4.simple_classes.task2_test2;

public class Test2 {
	private int a;
	private int b;

	Test2() {
	}

	Test2(int a, int b) {
		this.a = a;
		this.b = b;
	}

	public void setVarA(int a) {
		this.a = a;
	}

	public void setVarB(int b) {
		this.b = b;
	}

	public int getVarA() {
		return this.a;
	}

	public int getVarB() {
		return this.b;
	}

	public static void main(String[] args) {

		Test2 test1 = new Test2();
		System.out.println("test1 a = " + test1.getVarA());
		System.out.println("test1 b = " + test1.getVarB());

		test1.setVarA(3);
		test1.setVarB(4);
		System.out.println("test1 a = " + test1.getVarA());
		System.out.println("test1 b = " + test1.getVarB());

		Test2 test2 = new Test2(5, 6);
		System.out.println("test2 a = " + test2.getVarA());
		System.out.println("test2 b = " + test2.getVarB());

	}
}
