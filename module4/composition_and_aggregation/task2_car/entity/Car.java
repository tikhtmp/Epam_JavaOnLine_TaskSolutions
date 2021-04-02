/*
Модуль 4. Агрегация и композиция.
Задача 2.
Условие: Создать объет класса Автомобиль, используя классы Колесо, Двигатель. Методы: ехать, заправляться,
менять колесо, вывести на консоль марку автомобиля.
*/

package by.epam_training.java_online.module4.composition_and_aggregation.task2_car.entity;

import java.io.Serializable;
import by.epam_training.java_online.module4.composition_and_aggregation.task2_car.view.CarView;

public class Car implements Comparable<Car> {

	private String brand;
	private Engine engine;
	private Wheel frontRight;
	private Wheel frontLeft;
	private Wheel rearRight;
	private Wheel rearLeft;

	public Car() {
		brand = null;
		engine = null;
		frontRight = null;
		frontLeft = null;
		rearRight = null;
		rearLeft = null;
	}

	public Car(String brand, Engine engine) {
		this.brand = brand;
		this.engine = engine;
	}
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public Wheel getFrontRight() {
		return frontRight;
	}

	public void setFrontRight(Wheel frontRight) {
		this.frontRight = frontRight;
	}

	public Wheel getFrontLeft() {
		return frontLeft;
	}

	public void setFrontLeft(Wheel frontLeft) {
		this.frontLeft = frontLeft;
	}

	public Wheel getRearRight() {
		return rearRight;
	}

	public void setRearRight(Wheel rearRight) {
		this.rearRight = rearRight;
	}

	public Wheel getRearLeft() {
		return rearLeft;
	}

	public void setRearLeft(Wheel rearLeft) {
		this.rearLeft = rearLeft;
	}

	public void move() {
		sendReport("The " + brand + " is moving.");
	}
	
	public void sendReport (String report) {
		CarView.displayReport(report);
	}
	
	@Override
	public String toString() {
		Class<Car> clazz = Car.class;
		return clazz.getSimpleName() + " [brand=" + brand + ", engine=" + engine + ", frontRight=" + frontRight
				+ ", frontLeft=" + frontLeft + ", rearRight=" + rearRight + ", rearLeft=" + rearLeft + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = result * prime + ((brand == null) ? 0 : brand.hashCode());
		result = result * prime + ((engine == null) ? 0 : engine.hashCode());
		result = result * prime + ((frontRight == null) ? 0 : frontRight.hashCode());
		result = result * prime + ((frontLeft == null) ? 0 : frontLeft.hashCode());
		result = result * prime + ((rearRight == null) ? 0 : rearRight.hashCode());
		result = result * prime + ((rearLeft == null) ? 0 : rearLeft.hashCode());
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

		Car other = (Car) obj;

		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;

		if (engine == null) {
			if (other.engine != null)
				return false;
		} else if (!engine.equals(other.engine))
			return false;

		if (frontRight == null) {
			if (other.frontRight != null)
				return false;
		} else if (!frontRight.equals(other.frontRight))
			return false;

		if (frontLeft == null) {
			if (other.frontLeft != null)
				return false;
		} else if (!frontLeft.equals(other.frontLeft))
			return false;

		if (rearRight == null) {
			if (other.rearRight != null)
				return false;
		} else if (!rearRight.equals(other.rearRight))
			return false;

		if (rearLeft == null) {
			if (other.rearLeft != null)
				return false;
		} else if (!rearLeft.equals(other.rearLeft))
			return false;

		return true;
	}

	@Override
	public int compareTo(Car other) {
		return brand.compareTo(other.brand);
	}

	/*колесо, установленное на авто*/
	public class Wheel implements Comparable<Wheel>, Serializable {

		private static final long serialVersionUID = 1L;
		
		private String type;

		public Wheel() {
			type = null;
		}

		public Wheel(String type) {
			this.type = type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getType() {
			return type;
		}
		
		public Car getCar() {
			return Car.this;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;

			Wheel other = (Wheel) obj;

			if (type == null) {
				if (other.type != null)
					return false;
			} else if (!this.type.equals(other.type))
				return false;
			return true;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = result * prime + ((type == null) ? 0 : type.hashCode());
			return result;
		}

		@Override
		public String toString() {
			Class<Wheel> clazz = Wheel.class;
			return clazz.getSimpleName() + " [type=" + type + "]";
		}

		@Override
		public int compareTo(Wheel other) {
			return type.compareTo(other.type);
		}
	}
}
