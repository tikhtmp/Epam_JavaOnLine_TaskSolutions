/*
Модуль 4. Простейшие классы и объекты. 
Задача 6.
Составьте описание класса для представления времени. Предусмотрите возможность установки времени и
изменения его отдельных полей (час, минута, секунда) с проверкой допустимости вводимых значений. В случае
недопустимых значений полей поле устанавливается в значение 0. Создать методы изменения времени на
заданное количество часов, минут, секунд.
 */
package by.epam_training.java_online.module4.simple_classes.task6_time.entity;

public class Time {

	private int hour;
	private int min;
	private int sec;

	public Time() {
		this.hour = 0;
		this.min = 0;
		this.sec = 0;
	}

	public Time(int hour, int min, int sec) {
		this.hour = (hour < 0 || hour > 23) ? 0 : hour;
		this.min = (min < 0 || min > 60) ? 0 : min;
		this.sec = (sec < 0 || sec > 60) ? 0 : sec;
	}

	public void setTime(int hour, int min, int sec) {
		setHour(hour);
		setMin(min);
		setSec(sec);
	}

	public void setHour(int hour) {
		this.hour = (hour < 0 || hour > 23) ? 0 : hour;
	}

	public void setMin(int min) {
		this.min = (min < 0 || min > 60) ? 0 : min;
	}

	public void setSec(int sec) {
		this.sec = (sec < 0 || sec > 60) ? 0 : sec;
	}

	public int getHour() {
		return this.hour;
	}

	public int getMin() {
		return this.min;
	}

	public int getSec() {
		return this.sec;
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj) {
			return true;
		}
		
		if(obj == null) {
			return false;
		}
		
		if (getClass() != obj.getClass()) {
			return false;
		}
		
		Time other = (Time) obj;
		
		if(hour != other.hour) {
			return false;
		}
		
		if(min != other.min) {
			return false;
		}
		
		if(sec != other.sec) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = result * prime + hour;
		result = result * prime + min;
		result = result * prime + sec;
		return result;
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + " [hour=" + hour + ", min=" + min + ", sec=" + sec + "]";
	}
}