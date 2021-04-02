package by.epam_training.java_online.module4.composition_and_aggregation.task5_travel.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import by.epam_training.java_online.module4.composition_and_aggregation.task5_travel.entity.Trip;
import by.epam_training.java_online.module4.composition_and_aggregation.task5_travel.view.TripView;

public class TripLogic {

	public static List<Trip> generateOffer(List<Trip> availableTrips, String transport, String feed, int minDays,
			int maxDays) {
		List<Trip> trips = new ArrayList<Trip>();

		for (Trip t : availableTrips) {

			if (t.getTransport().toString().equalsIgnoreCase(transport) && t.getFeed().toString().equalsIgnoreCase(feed)
					&& t.getPeriod() >= minDays && t.getPeriod() <= maxDays)
				trips.add(t);
		}

		if (trips.size() <= 0) {
			TripView.unsuccessSearchMessage(transport, feed, minDays, maxDays);
		} else {
			TripView.successSearchMessage(transport, feed, minDays, maxDays);
		}
		return trips;
	}

	public static void sortByDestination(List<Trip> trips) {
		Collections.sort(trips);
	}

	public static void sortByType(List<Trip> trips) {
		Collections.sort(trips, new Comparator<Trip>() {
			@Override
			public int compare(Trip trip1, Trip trip2) {
				return trip2.getType().compareTo(trip1.getType());
			}
		});
	}

	public static void sortByPeriod(List<Trip> trips) {
		Collections.sort(trips, new Comparator<Trip>() {
			@Override
			public int compare(Trip trip1, Trip trip2) {
				return trip1.getPeriod() - trip2.getPeriod();
			}
		});
	}

	public static void sortByTransport(List<Trip> trips) {
		Collections.sort(trips, new Comparator<Trip>() {
			@Override
			public int compare(Trip trip1, Trip trip2) {
				return trip1.getTransport().compareTo(trip2.getTransport());
			}
		});
	}

	public static void sortByFeed(List<Trip> trips) {

		Collections.sort(trips, new Comparator<Trip>() {
			@Override
			public int compare(Trip trip1, Trip trip2) {
				return trip2.getFeed().compareTo(trip1.getFeed());
			}
		});
	}

}
