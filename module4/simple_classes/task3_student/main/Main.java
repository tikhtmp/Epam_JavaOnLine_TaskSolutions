/*
Модуль 4. Простейшие классы и объекты. 
Задача 3.
Создайте класс с именем Student, содержащий поля: фамилия и инициалы, номер группы, успеваемость (массив
из пяти элементов). Создайте массив из десяти элементов такого типа. Добавьте возможность вывода фамилий и
номеров групп студентов, имеющих оценки, равные только 9 и 10.
 */
package by.epam_training.java_online.module4.simple_classes.task3_student.main;

import by.epam_training.java_online.module4.simple_classes.task3_student.entity.Student;
import by.epam_training.java_online.module4.simple_classes.task3_student.logic.StudentLogic;
import by.epam_training.java_online.module4.simple_classes.task3_student.view.ViewStudent;

public class Main {

	public static void main(String[] args) {

		StudentLogic studentProcessing = new StudentLogic();
		Student[] group = studentProcessing.generateTestData(10);
		ViewStudent.display(group[5]); // данные по студенту 6
		System.out.println();
		ViewStudent.show(group); // данные по всем студентам
		ViewStudent.display(group, 9); // студенты с оценками не ниже 9
	}
}
