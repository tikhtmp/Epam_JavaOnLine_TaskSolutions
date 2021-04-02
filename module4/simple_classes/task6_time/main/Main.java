/*
Модуль 4. Простейшие классы и объекты. 
Задача 6.
Составьте описание класса для представления времени. Предусмотрите возможность установки времени и
изменения его отдельных полей (час, минута, секунда) с проверкой допустимости вводимых значений. В случае
недопустимых значений полей поле устанавливается в значение 0. Создать методы изменения времени на
заданное количество часов, минут, секунд.
 */

package by.epam_training.java_online.module4.simple_classes.task6_time.main;

import by.epam_training.java_online.module4.simple_classes.task6_time.entity.Time;
import by.epam_training.java_online.module4.simple_classes.task6_time.logic.TimeLogic;
import by.epam_training.java_online.module4.simple_classes.task6_time.view.TimeView;

public class Main {

	public static void main(String[] args) {
		Time clock = new Time(23, 1, 56);
		TimeView.displayTime(clock);

		System.out.println("Setting new time:");
		clock.setHour(10);
		clock.setMin(55);
		clock.setSec(18);
		TimeView.displayTime(clock);

		System.out.println("Setting invalid time:");
		clock.setHour(100);
		clock.setMin(-55);
		clock.setSec(118);
		TimeView.displayTime(clock);

		System.out.println("Setting new time:");
		clock.setTime(20, 44, 56);
		TimeView.displayTime(clock);

		System.out.println("Setting invalid hours:");
		clock.setHour(25);
		TimeView.displayTime(clock);

		System.out.println("Setting invalid minutes:");
		clock.setMin(-25);
		TimeView.displayTime(clock);

		System.out.println("Setting invalid secundes:");
		clock.setSec(105);
		TimeView.displayTime(clock);

		System.out.println("Setting new time:");
		clock.setTime(10, 55, 18);
		TimeView.displayTime(clock);

		System.out.println("Adding time(-10h -10m -50s ):");
		TimeLogic.changeTime(clock, -10, -10, -50);
		TimeView.displayTime(clock);

		long secs = 3665;
		System.out.println("Adding " + secs + " seconds");
		TimeLogic.сhangeSec(clock, secs);
		TimeView.displayTime(clock);

		long mins = -125;
		System.out.println("Adding " + mins + " minutes");
		TimeLogic.сhangeMin(clock, mins);
		TimeView.displayTime(clock);

		long hours = 25;
		System.out.println("Adding " + hours + " hours");
		TimeLogic.сhangeHour(clock, hours);		
		TimeView.displayTime(clock);
	}
}