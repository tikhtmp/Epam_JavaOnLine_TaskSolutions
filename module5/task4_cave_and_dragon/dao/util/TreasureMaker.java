package by.epam_training.java_online.module5.task4_cave_and_dragon.dao.util;

import java.util.ArrayList;
import java.util.List;

import by.epam_training.java_online.module5.task4_cave_and_dragon.bean.Treasure;

public class TreasureMaker {
	
	private static int counter = 1;

	public static List<Treasure> makeTreasure() {

		TreasureFactory factory = new TreasureFactory();
		int num;
		int value;
		String treasureType = null;
		
		List<Treasure> treasures = new ArrayList<Treasure>();
		
		for (int i = 0; i < 100; i++) {
			
			num = (int)( Math.random() * 7) + 1;
			value = (int) (Math.random() * 500);
			
			if(num == 1) {
				treasureType = "GoldJewelry";
				value = value + 700;
			}
			if(num == 2) {
				treasureType = "SilverJewelry";
				value = value + 300;
			}
			if(num == 3) {
				treasureType = "GoldCoin";
				value = value + 200;
			}
			if(num == 4) {
				treasureType = "SilverCoin";
				value = value + 100;
			}
			if(num == 5) {
				treasureType = "Diamond";
				value = value + 1000;
			}
			if(num == 6) {
				treasureType = "Ruby";
				value = value + 1500;
			}
			if(num == 7) {
				treasureType = "Sapphire";
				value = value + 1700;
			}

			treasures.add(factory.createTreasure(treasureType, value, null, counter++));
		}
		
		return treasures;
	}
}
