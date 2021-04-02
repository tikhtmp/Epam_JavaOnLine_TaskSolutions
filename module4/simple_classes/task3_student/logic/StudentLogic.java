package by.epam_training.java_online.module4.simple_classes.task3_student.logic;

import by.epam_training.java_online.module4.simple_classes.task3_student.entity.Student;

public class StudentLogic {

	/* проверка успеваемости */
	public boolean isGradeMoreThan(Student st, int grade) {

		for (int i : st.getAchievement()) {

			if (i < grade) {
				return false;
			}
		}

		return true;
	}

	/* формирование случайного списка студентов для проверки работы класса */
	public Student[] generateTestData(int number) {
		Student[] student = new Student[number];

		for (int i = 0; i < number; i++) { // формирование списка студентов

			int[] achievement = new int[Student.subject];

			for (int j = 0; j < Student.subject; j++) { // формирование данных об успеваемости студентов
				achievement[j] = (int) (Math.random() * 3) + 8; // оценки в пределах 8-10
			}

			student[i] = new Student("Student" + (i + 1), (int) (Math.random() * 2 + 1), achievement);
		}

		return student;
	}
}
