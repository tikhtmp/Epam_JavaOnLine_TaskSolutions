/*
Модуль 4. Простейшие классы и объекты. 
Задача 5.
Опишите класс, реализующий десятичный счетчик, который может увеличивать или уменьшать свое значение
на единицу в заданном диапазоне. Предусмотрите инициализацию счетчика значениями по умолчанию и
произвольными значениями. Счетчик имеет методы увеличения и уменьшения состояния и метод,
позволяющий получить его текущее состояние. Написать код, демонстрирующий все возможности класса.
 */

package by.epam_training.java_online.module4.simple_classes.task5_counter;

public class Counter {
	private int value = 0;

	public Counter() {
		value = 0;
	}

	public Counter(int value) {

		System.out.println("Current value = " + this.value);
		System.out.println("Trying to set value = " + value);

		if (value >= 0 && value < 11) {
			this.value = value;
		} else
			this.value = 0;

		System.out.println("Setted with constructor value = " + this.value);
	}

	public void upCount() {
		value++;

		if (value > 10) {
			value = 0;
		}
	}

	public void downCount() {
		value--;

		if (value < 0) {
			value = 0;
		}
	}

	public int getValue() {
		return value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + value;
		return result;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (getClass() != obj.getClass())
			return false;

		Counter other = (Counter) obj;

		if (value != other.value)
			return false;

		return true;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [value=" + value + "]";
	}

	public static void main(String[] args) {
		System.out.println("Creating count1");
		Counter count1 = new Counter(2);

		System.out.println("\nCreating count2");
		@SuppressWarnings("unused")
		Counter count2 = new Counter(15);

		System.out.println("\nCreating count3");
		Counter count3 = new Counter(9);

		count1.downCount();
		System.out.println("\nValue count1 = " + count1.getValue());
		count1.downCount();
		System.out.println("Value count1 = " + count1.getValue());

		count3.upCount();
		System.out.println("\nValue count3 = " + count3.getValue());
		count3.upCount();
		System.out.println("Value count3 = " + count3.getValue());
	}
}
