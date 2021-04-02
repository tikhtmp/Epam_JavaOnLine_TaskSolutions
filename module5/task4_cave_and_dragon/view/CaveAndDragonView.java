package by.epam_training.java_online.module5.task4_cave_and_dragon.view;

import java.util.List;

import by.epam_training.java_online.module5.task4_cave_and_dragon.bean.Treasure;
import by.epam_training.java_online.module5.task4_cave_and_dragon.service.impl.CaveAndDragonServiceImpl;

public class CaveAndDragonView {

	public static void displayTreasure(Treasure treasure) {
		System.out.printf("%s%s\n", "Inventary number: ", treasure.getTreasureInfo());
	}

	public static void displayTreasure(List<Treasure> treasures) {

		if (!treasures.isEmpty()) {

			System.out.println("-----------------------------------------------------------------------------");

			for (Treasure t : treasures) {
				displayTreasure(t);
			}

			System.out.println("-----------------------------------------------------------------------------");
			System.out.printf("%38s %s\n", "Total sum: ", CaveAndDragonServiceImpl.calculateTotallValue(treasures));
		}
	}

	public static void displayMessage(String message) {
		System.out.println(message);
	}
}
