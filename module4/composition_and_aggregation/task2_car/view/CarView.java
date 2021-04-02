package by.epam_training.java_online.module4.composition_and_aggregation.task2_car.view;

import by.epam_training.java_online.module4.composition_and_aggregation.task2_car.entity.Car;

public class CarView {

	public static void displayReport(String report) {
		System.out.println(report);
	}
	
	public static void displayBrand(Car car) {
		System.out.println("Brand: " + car.getBrand());
	}
}
