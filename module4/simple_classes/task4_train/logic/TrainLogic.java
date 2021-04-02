package by.epam_training.java_online.module4.simple_classes.task4_train.logic;

import java.util.List;
import java.util.Scanner;

import by.epam_training.java_online.module4.simple_classes.task4_train.entity.Train;
import by.epam_training.java_online.module4.simple_classes.task4_train.view.TrainView;

public class TrainLogic {

	public static void manualSortByNumber(Train[] trains) {

		for (int i = 0; i < trains.length; i++) {

			for (int j = i + 1; j < trains.length; j++) {

				if (trains[j].getNumber() < trains[i].getNumber()) {
					swap(i, j, trains);
				}
			}
		}
	}

	public static void manualSortByDestination(Train[] trains) {

		/* первоначальная сортировка по пункту назначения */
		for (int i = 0; i < trains.length; i++) {

			for (int j = i + 1; j < trains.length; j++) {

				if (trains[i].getDestination().compareTo(trains[j].getDestination()) > 0) {
					swap(i, j, trains);
				}
			}
		}

		/* повторная сортировка по времени отправления */
		for (int i = 0; i < trains.length; i++) {

			for (int j = i + 1; j < trains.length; j++) {

				if (trains[i].getDestination() == trains[j].getDestination()) {
					if (trains[i].getDepartureTime().compareTo(trains[j].getDepartureTime()) > 0) {
						swap(i, j, trains);
					}
				}
			}
		}
	}

	private static void swap(int i, int j, Train[] trains) {
		Train tmp = new Train();
		tmp = trains[i];
		trains[i] = trains[j];
		trains[j] = tmp;
	}

	public static void chooseTrain(List<Train> trains) {

		int num = 0;
		boolean isAvailable = false;

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		while (!isAvailable) {

			System.out.print("Please, input a train number. Available numbers are: ");

			for (Train train : trains) {
				System.out.print(train.getNumber() + " ");
			}

			System.out.println();

			while (!sc.hasNextInt()) {
				@SuppressWarnings("unused")
				String str = sc.next();
				System.out.print("Invalid input! Try again.");
			}

			num = sc.nextInt();

			for (Train train : trains) {

				if (num == train.getNumber()) {
					TrainView.display(train);
					isAvailable = true;
					break;
				}
			}

			if (!isAvailable) {
				System.out.println("The train N" + num + " doesn't exist! Try again...\n");
			}
		}
	}
}
