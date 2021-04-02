package by.epam_training.java_online.module4.simple_classes.task4_train.view;

import java.util.List;

import by.epam_training.java_online.module4.simple_classes.task4_train.entity.Train;

public class TrainView {

	public static void display(Train train) {
		System.out.format("%-12s %-3s %-12s %-10s %-16s %02d%s%02d\n", "Train number:", train.getNumber(),
				"Destination:", train.getDestination(), "Departure time:", train.getDepartureTime().get(11), ":",
				train.getDepartureTime().get(12));
	}

	public static void display(List<Train> list) {

		for (Train train : list) {
			display(train);
		}

		System.out.println();
	}

	public static void display(Train[] list) {

		for (Train train : list) {
			display(train);
		}

		System.out.println();
	}

}
