package by.epam_training.java_online.module4.simple_classes.task6_time.view;

import by.epam_training.java_online.module4.simple_classes.task6_time.entity.Time;

public class TimeView {
	public static void displayTime(Time time) {
		System.out.format("%-12s %02d%s%02d%s%02d\n\n", "Current time:", time.getHour(), ":", time.getMin(), ":", time.getSec());
	}

}
