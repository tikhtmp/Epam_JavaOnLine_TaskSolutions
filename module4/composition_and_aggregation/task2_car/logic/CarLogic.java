package by.epam_training.java_online.module4.composition_and_aggregation.task2_car.logic;

import by.epam_training.java_online.module4.composition_and_aggregation.task2_car.entity.Car;
import by.epam_training.java_online.module4.composition_and_aggregation.task2_car.entity.StockWheel;
import by.epam_training.java_online.module4.composition_and_aggregation.task2_car.view.CarView;

public class CarLogic {

	public static void fillUpTank(Car car) {
		car.sendReport("The " + car.getBrand() + "'s tank is full.");
	}

	public static void changeWheel(Car.Wheel oldOne, StockWheel newOne) {
		Car car = oldOne.getCar();

		String whichWheel = null;

		if (car.getFrontRight() == oldOne) {
			whichWheel = "front right wheel";
		}

		if (car.getFrontLeft() == oldOne) {
			whichWheel = "front left wheel";
		}

		if (car.getRearRight() == oldOne) {
			whichWheel = "rear right wheel";
		}

		if (car.getRearLeft() == oldOne) {
			whichWheel = "rear left wheel";
		}

		CarView.displayReport("The " + car.getBrand() + "'s " + whichWheel + " " + oldOne.getType() + " was replaced by "
				+ newOne.getType());
		
		oldOne.setType(newOne.getType());
	}
}
