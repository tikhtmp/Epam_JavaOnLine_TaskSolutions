/*
Модуль 4. Агрегация и композиция.
Задача 5.
Условие: Туристические путевки. Сформировать набор предложений клиенту по выбору туристической путевки
различного типа (отдых, экскурсии, лечение, шопинг, круиз и т. д.) для оптимального выбора. Учитывать 
возможность выбора транспорта, питания и числа дней. Реализовать выбор и сортировку путевок.
*/

package by.epam_training.java_online.module4.composition_and_aggregation.task5_travel.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import by.epam_training.java_online.module4.composition_and_aggregation.task5_travel.entity.Feed;
import by.epam_training.java_online.module4.composition_and_aggregation.task5_travel.entity.Transport;
import by.epam_training.java_online.module4.composition_and_aggregation.task5_travel.entity.Trip;
import by.epam_training.java_online.module4.composition_and_aggregation.task5_travel.entity.Type;
import by.epam_training.java_online.module4.composition_and_aggregation.task5_travel.logic.TripLogic;
import by.epam_training.java_online.module4.composition_and_aggregation.task5_travel.view.TripView;

public class Main {

	public static void main(String[] args) {
		Trip trip1 = new Trip("Roma", Type.EXCURSION, 3, Transport.FLIGHT, Feed.ALL_INCLUSIVE);
		Trip trip2 = new Trip("Roma", Type.VACATION, 20, Transport.BUS, Feed.ALL_INCLUSIVE);
		Trip trip3 = new Trip("Adreatic sea", Type.CRUISE, 25, Transport.FLIGHT, Feed.ALL_INCLUSIVE);
		Trip trip4 = new Trip("Paris", Type.EXCURSION, 7, Transport.BUS, Feed.ROOM_ONLY);
		Trip trip5 = new Trip("Antalia", Type.EXCURSION, 10, Transport.FLIGHT, Feed.FULL_BOARD);
		Trip trip6 = new Trip("Antalia", Type.CURE, 14, Transport.FLIGHT, Feed.HALF_BOARD);
		Trip trip7 = new Trip("Antalia", Type.VACATION, 21, Transport.FLIGHT, Feed.ALL_INCLUSIVE);
		Trip trip8 = new Trip("Varna", Type.VACATION, 15, Transport.FLIGHT, Feed.ALL_INCLUSIVE);
		Trip trip9 = new Trip("Varna", Type.VACATION, 20, Transport.TRAIN, Feed.HALF_BOARD);
		Trip trip10 = new Trip("Varna", Type.VACATION, 30, Transport.BUS, Feed.FULL_BOARD);

		List<Trip> travelAgency = new ArrayList<Trip>(
				Arrays.asList(trip1, trip2, trip3, trip4, trip5, trip6, trip7, trip8, trip9, trip10));
		
		System.out.println("All trips:");
		TripView.show(travelAgency);

		System.out.println("Trips sorted by destination:");
		TripLogic.sortByDestination(travelAgency);
		TripView.show(travelAgency);

		System.out.println("Trips sorted by type:");
		TripLogic.sortByType(travelAgency);
		TripView.show(travelAgency);

		System.out.println("Trips sorted by period:");
		TripLogic.sortByPeriod(travelAgency);
		TripView.show(travelAgency);

		System.out.println("Trips sorted by transport:");
		TripLogic.sortByTransport(travelAgency);
		TripView.show(travelAgency);

		System.out.println("Trips sorted by feed:");
		TripLogic.sortByFeed(travelAgency);
		TripView.show(travelAgency);

		/*поиск по пожеланиям клиента*/
		List<Trip> offer1 = TripLogic.generateOffer(travelAgency, "flight", "all_inclusive", 10, 24);
		TripView.show(offer1);

		/*поиск по пожеланиям клиента (заведомо невыполнимый вариант)*/
		List<Trip> offer2 = TripLogic.generateOffer(travelAgency, "fight", "all_inclusive", 1, 10);
		TripView.show(offer2);
	}
}
