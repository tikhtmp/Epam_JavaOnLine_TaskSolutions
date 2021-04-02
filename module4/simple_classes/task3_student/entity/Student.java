/*
Модуль 4. Простейшие классы и объекты. 
Задача 3.
Создайте класс с именем Student, содержащий поля: фамилия и инициалы, номер группы, успеваемость (массив
из пяти элементов). Создайте массив из десяти элементов такого типа. Добавьте возможность вывода фамилий и
номеров групп студентов, имеющих оценки, равные только 9 и 10.
 */
package by.epam_training.java_online.module4.simple_classes.task3_student.entity;

import java.util.Arrays;

public class Student {
	private String name;
	private int group;
	private int[] achievement = new int[subject];
	public final static int subject = 5;

	public Student() {
		this.name = "";
		this.group = 0;
		this.achievement = new int[] { 0, 0, 0, 0, 0 };
	}

	public Student(String name, int group, int[] achievement) {
		this.name = name;
		this.group = group;
		this.achievement = achievement;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setGroup(int group) {
		this.group = group;
	}

	public int getGroup() {
		return this.group;
	}

	public void setAchievement(int[] achievement) {
		this.achievement = achievement;
	}

	public int[] getAchievement() {
		return this.achievement;
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		Student other = (Student) obj;
		
		if (!Arrays.equals(achievement, other.achievement))
			return false;
		
		if (group != other.group)
			return false;
		
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(achievement);
		result = prime * result + group;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [name=" + name + ", group=" + group + ", achievement="
				+ Arrays.toString(achievement) + "]";
	}

}
