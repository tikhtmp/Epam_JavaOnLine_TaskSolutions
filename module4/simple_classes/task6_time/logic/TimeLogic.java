package by.epam_training.java_online.module4.simple_classes.task6_time.logic;

import by.epam_training.java_online.module4.simple_classes.task6_time.entity.Time;

public class TimeLogic {
	
	/* изменение времени на заданное кол-во часов, минут, секунд */
	public static void changeTime(Time t, int hour, int min, int sec) {
		
		int resultHour = t.getHour();
		int resultMin = t.getMin();
		int resultSec = t.getSec();

		if (resultSec + sec > 59) {
			resultSec = resultSec + sec - 60;
			resultMin++;
		} else if (resultSec + sec < 0) {
			resultSec = resultSec + sec + 60;
			resultMin--;
		} else
			resultSec = resultSec + sec;

		if (resultMin + min > 59) {
			resultMin = resultMin + min - 60;
			resultHour++;
		} else if (resultMin + min < 0) {
			resultMin = resultMin + min + 60;
			resultHour--;
		} else
			resultMin = resultMin + min;

		if (resultHour + hour > 23) {
			resultHour = resultHour + hour - 24;
		} else if (resultHour + hour < 0) {
			resultHour = resultHour + hour + 24;
		} else
			resultHour = resultHour + hour;
		
		t.setTime(resultHour, resultMin, resultSec);
	}

	/* изменение времени на заданное кол-во секунд */
	public static void сhangeSec(Time t, long sec) {
		long time = sec;
		int[] timeArray = parseSeconds(time);
		changeTime(t, timeArray[0], timeArray[1], timeArray[2]);
	}

	/* изменение времени на заданное кол-во минут */
	public static void сhangeMin(Time t, long min) {
		long time = min * 60;
		int[] timeArray = parseSeconds(time);
		changeTime(t, timeArray[0], timeArray[1], timeArray[2]);
	}

	/* изменение времени на заданное кол-во часов */
	public static void сhangeHour(Time t, long hour) {
		long time = hour * 3600;
		int[] timeArray = parseSeconds(time);
		changeTime(t, timeArray[0], timeArray[1], timeArray[2]);
	}

	/* разбор секунд, на которые изменяется время */
	private static int[] parseSeconds(long time) {
		long days = time / 3600 / 24;
		long hours = (time - days * 3600 * 24) / 3600; // исключение из расчета полных суток
		long mins = (time - days * 3600 * 24 - hours * 3600) / 60;
		long secs = (time - days * 3600 * 24 - hours * 3600 - mins * 60);
		return new int[] { (int) hours, (int) mins, (int) secs };
	}
}
