/*
Модуль 5. Задача 3.
Условие:
Создать класс Календарь с внутренним классом, с помощью объектов которого можно хранить информацию о
выходных и праздничных днях.
*/

package by.epam_training.java_online.module5.task3_calendar.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Calendar implements Serializable {

	private static final long serialVersionUID = 8L;
	private static final Calendar instance = new Calendar();
	private static final String LOCATION = "C:/XTUSCalendar/xtuscalendar.xml";
	private static final DayOfWeek startDayOfWeek = DayOfWeek.FRIDAY;
	private static List<Date> dates2021 = new ArrayList<Date>(365);
	private static final Map<Month, Integer> monthes = new LinkedHashMap<Month, Integer>();

	static {
		monthes.put(Month.JANUARY, 31);
		monthes.put(Month.FEBRUARY, 28);
		monthes.put(Month.MARCH, 31);
		monthes.put(Month.APRIL, 30);
		monthes.put(Month.MAY, 31);
		monthes.put(Month.JUNE, 30);
		monthes.put(Month.JULY, 31);
		monthes.put(Month.AUGUST, 31);
		monthes.put(Month.SEPTEMBER, 30);
		monthes.put(Month.OCTOBER, 31);
		monthes.put(Month.NOVEMBER, 30);
		monthes.put(Month.DECEMBER, 31);
	}

	private Calendar() {
	}

	public static Calendar getInstance() {
		return instance;
	}

	public static String getLocation() {
		return LOCATION;
	}

	public List<Date> getDates2021() {
		return dates2021;
	}

	public Map<Month, Integer> getMonthes() {
		return monthes;
	}

	public static DayOfWeek getStartDayOfWeek() {
		return startDayOfWeek;
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + " [dates2021=" + dates2021 + "]";
	}
	
	public static class Date implements Serializable {

		private static final long serialVersionUID = 8L;

		private final Month month;
		private final int day;
		private final int year;
		private final DayOfWeek dayOfWeek;
		private boolean publicHoliday;
		private boolean personalDayOff;
		private String description;

		public Date(DateBuilder dateBuilder) {
			this.day = dateBuilder.day;
			this.year = dateBuilder.year;
			this.month = dateBuilder.month;
			this.dayOfWeek = dateBuilder.dayOfWeek;
			this.publicHoliday = dateBuilder.publicHoliday;
			this.personalDayOff = dateBuilder.personalDayOff;
			this.description = dateBuilder.description;
		}

		public Month getMonth() {
			return month;
		}

		public int getDay() {
			return day;
		}

		public int getYear() {
			return year;
		}

		public DayOfWeek getDayOfWeek() {
			return dayOfWeek;
		}

		public boolean isPublicHoliday() {
			return publicHoliday;
		}

		public boolean isPersonalDayOff() {
			return personalDayOff;
		}

		public String getDescription() {
			return description;
		}

		public void setPublicHoliday(boolean publicHoliday) {
			this.publicHoliday = publicHoliday;
		}

		public void setPersonalDayOff(boolean personalDayOff) {
			this.personalDayOff = personalDayOff;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		@Override
		public String toString() {
			return getClass().getSimpleName() + " [month=" + month + ", day=" + day + ", year=" + year + ", dayOfWeek="
					+ dayOfWeek + ", publicHoliday=" + publicHoliday + ", personalDayOff=" + personalDayOff
					+ ", description=" + description + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + day;
			result = prime * result + ((dayOfWeek == null) ? 0 : dayOfWeek.hashCode());
			result = prime * result + ((description == null) ? 0 : description.hashCode());
			result = prime * result + ((month == null) ? 0 : month.hashCode());
			result = prime * result + (personalDayOff ? 1231 : 1237);
			result = prime * result + (publicHoliday ? 1231 : 1237);
			result = prime * result + year;
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

			Date other = (Date) obj;
			if (day != other.day)
				return false;
			if (dayOfWeek != other.dayOfWeek)
				return false;
			if (description == null) {
				if (other.description != null)
					return false;
			} else if (!description.equals(other.description))
				return false;
			if (month != other.month)
				return false;
			if (personalDayOff != other.personalDayOff)
				return false;
			if (publicHoliday != other.publicHoliday)
				return false;
			if (year != other.year)
				return false;
			return true;
		}

		public static class DateBuilder implements Serializable {
			private static final long serialVersionUID = 8L;
			private int day;
			private Month month;
			private int year;
			private DayOfWeek dayOfWeek;
			private boolean publicHoliday;
			private boolean personalDayOff;
			private String description;

			public DateBuilder(Month month, int day, int year) {
				this.year = year;
				this.month = month;
				this.day = day;
			}

			public DateBuilder withDayOfWeek(DayOfWeek dayOfWeek) {
				this.dayOfWeek = dayOfWeek;
				return this;
			}

			public DateBuilder withPublicHoliday(boolean publicHoliday) {
				this.publicHoliday = publicHoliday;
				return this;
			}

			public DateBuilder withPersonalDayOff(boolean personalDayOff) {
				this.personalDayOff = personalDayOff;
				return this;
			}

			public DateBuilder withDescription(String description) {
				this.description = description;
				return this;
			}

			public Date build() {
				return new Date(this);
			}

			@Override
			public String toString() {
				return getClass().getSimpleName() + " [day=" + day + ", month=" + month + ", year=" + year
						+ ", dayOfWeek=" + dayOfWeek + ", publicHoliday=" + publicHoliday + ", personalDayOff="
						+ personalDayOff + ", description=" + description + "]";
			}

			@Override
			public int hashCode() {
				final int prime = 31;
				int result = 1;
				result = prime * result + day;
				result = prime * result + ((dayOfWeek == null) ? 0 : dayOfWeek.hashCode());
				result = prime * result + ((description == null) ? 0 : description.hashCode());
				result = prime * result + ((month == null) ? 0 : month.hashCode());
				result = prime * result + (personalDayOff ? 1231 : 1237);
				result = prime * result + (publicHoliday ? 1231 : 1237);
				result = prime * result + year;
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

				DateBuilder other = (DateBuilder) obj;
				if (day != other.day)
					return false;
				if (dayOfWeek != other.dayOfWeek)
					return false;
				if (description == null) {
					if (other.description != null)
						return false;
				} else if (!description.equals(other.description))
					return false;
				if (month != other.month)
					return false;
				if (personalDayOff != other.personalDayOff)
					return false;
				if (publicHoliday != other.publicHoliday)
					return false;
				if (year != other.year)
					return false;
				return true;
			}

		}
	}
}
