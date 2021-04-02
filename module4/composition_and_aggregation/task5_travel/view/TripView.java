package by.epam_training.java_online.module4.composition_and_aggregation.task5_travel.view;

import java.util.List;

import by.epam_training.java_online.module4.composition_and_aggregation.task5_travel.entity.Trip;

public class TripView {

	private static void show(Trip trip) {
		System.out.format("%-13s | %-10s |   %-3d | %-9s | %-15s\n", trip.getDestination(), trip.getType(),
				trip.getPeriod(), trip.getTransport(), trip.getFeed());
	}

	private static void showHeader() {
		showLine();
		System.out.format("%-13s | %-10s | %-5s | %-9s | %-15s\n", " Destination", "   Type", "Days", "Transport",
				"    Feed");
		showLine();
	}

	private static void showLine() {
		System.out.println("--------------------------------------------------------------");
	}

	public static void show(List<Trip> trips) {

		if (trips.size() > 0) {
			showHeader();

			for (Trip trip : trips) {
				show(trip);
			}

			showLine();
			System.out.println();
		}
	}

	public static void successSearchMessage(String transport, String feed, int minDays, int maxDays) {

		System.out.println("Following have been found on request \"" + transport + ", " + feed + " from " + minDays
				+ " to " + maxDays + " days\":");
	}

	public static void unsuccessSearchMessage(String transport, String feed, int minDays, int maxDays) {
		System.out.println("Nothing has been found on request \"" + transport + ", " + feed + " from " + minDays
				+ " to " + maxDays + " days\".\n");

	}
}
