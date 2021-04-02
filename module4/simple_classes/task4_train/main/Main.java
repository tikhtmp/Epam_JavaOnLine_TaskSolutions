/*
Модуль 4. Простейшие классы и объекты. 
Задача 4.
Создайте класс Train, содержащий поля: название пункта назначения, номер поезда, время отправления.
Создайте данные в массиве из пяти элементов типа Train, добавьте возможность сортировки элементов массива по
номерам поездов. Добавьте возможность вывода информации о поезде, номер которого введен пользователем. 
Добавьте возможность сортировки массива по пункту назначения, причем поезда с одинаковыми пунктами
назначения должны быть упорядочены по времени отправления.
 */

package by.epam_training.java_online.module4.simple_classes.task4_train.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.List;

import by.epam_training.java_online.module4.simple_classes.task4_train.entity.DepartureComparator;
import by.epam_training.java_online.module4.simple_classes.task4_train.entity.DestinationComparator;
import by.epam_training.java_online.module4.simple_classes.task4_train.entity.Train;
import by.epam_training.java_online.module4.simple_classes.task4_train.logic.TrainLogic;
import by.epam_training.java_online.module4.simple_classes.task4_train.view.TrainView;

public class Main {

	public static void main(String[] args) {
		Train train1 = new Train("Gaaga", 15, new GregorianCalendar(0, 0, 0, 7, 25));
		Train train2 = new Train("Paris", 22, new GregorianCalendar(0, 0, 0, 12, 15));
		Train train3 = new Train("Gaaga", 3, new GregorianCalendar(0, 0, 0, 15, 5));
		Train train4 = new Train("Gaaga", 41, new GregorianCalendar(0, 0, 0, 6, 15));
		Train train5 = new Train("Abudabi", 5, new GregorianCalendar(0, 0, 0, 23, 55));

		Train[] trainsArray = { train1, train2, train3, train4, train5 };
		System.out.println("The list of trains:");
		TrainView.display(trainsArray);

		TrainLogic.manualSortByNumber(trainsArray);
		System.out.println("Sorted by train number(manual version):");
		TrainView.display(trainsArray);

		TrainLogic.manualSortByDestination(trainsArray);
		System.out.println("Sorted by destination & departure time (manual version):");
		TrainView.display(trainsArray);

		System.out.println("------------------------------------------------------------------------");

		List<Train> trains = new ArrayList<>(Arrays.asList(train1, train2, train3, train4, train5));

		System.out.println("The list of trains:");
		TrainView.display(trains);

		Collections.sort(trains, new Comparator<Train>() {
			@Override
			public int compare(Train train1, Train train2) {
				return Integer.compare(train1.getNumber(), train2.getNumber());
			}
		});

		System.out.println("Sorted by train number (with comporator):");
		TrainView.display(trains);

		Collections.sort(trains, new DepartureComparator());
		System.out.println("Sorted by departure time (with comporator):");
		TrainView.display(trains);

		Collections.sort(trains, new DestinationComparator());
		System.out.println("Sorted by destination and departure time(with comporator):");
		TrainView.display(trains);

		TrainLogic.chooseTrain(trains);

	}
}
