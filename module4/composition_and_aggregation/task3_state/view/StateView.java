package by.epam_training.java_online.module4.composition_and_aggregation.task3_state.view;

import by.epam_training.java_online.module4.composition_and_aggregation.task3_state.entity.City;
import by.epam_training.java_online.module4.composition_and_aggregation.task3_state.entity.Region;
import by.epam_training.java_online.module4.composition_and_aggregation.task3_state.entity.State;

public class StateView {
	
	public static void show(City city) {
		System.out.print(city.getName());
	}
	
	public static void showCapital(State state) {
		System.out.print("The capital of " + state.getName() + " is ");
		show(state.getCapital());
		System.out.println(".\n");
	}

	public static void showArea(State state) {
		System.out.println("The area of " + state.getName() + " is " + state.getArea() + " square kilometres.\n");
	}

	public static void showNumberOfRegions (State state) {
		System.out.println(state.getName() + " has " + state.getRegions().size() + " regions.\n");
	}
	
	public static void showRegionMainCities (State state) {
		System.out.println("The regions of" + state.getName() + " have folowing main cities:");
		
		for (Region r  : state.getRegions()) {
			System.out.print("Region: " + r.getName() + ", main city: ");
			show(r.getMainCity());
			System.out.println(".");
		}
	}

}
