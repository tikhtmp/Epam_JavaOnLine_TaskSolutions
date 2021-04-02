package by.epam_training.java_online.module5.task4_cave_and_dragon.dao.util;

import by.epam_training.java_online.module5.task4_cave_and_dragon.bean.Diamond;
import by.epam_training.java_online.module5.task4_cave_and_dragon.bean.GoldCoin;
import by.epam_training.java_online.module5.task4_cave_and_dragon.bean.GoldJewelry;
import by.epam_training.java_online.module5.task4_cave_and_dragon.bean.Ruby;
import by.epam_training.java_online.module5.task4_cave_and_dragon.bean.Sapphire;
import by.epam_training.java_online.module5.task4_cave_and_dragon.bean.SilverCoin;
import by.epam_training.java_online.module5.task4_cave_and_dragon.bean.SilverJewelry;
import by.epam_training.java_online.module5.task4_cave_and_dragon.bean.Treasure;

public class TreasureFactory {
	
	public Treasure createTreasure(String treasureType, int value, String description, int inventaryNumber) {

		if (treasureType.equals("GoldJewelry")) {

			if (description == null) {
				return new GoldJewelry(value, inventaryNumber, "Box with gold jewelry");
			} else {
				return new GoldJewelry(value, inventaryNumber, description);
			}

		} else if (treasureType.equals("SilverJewelry")) {

			if (description == null) {
				return new SilverJewelry(value, inventaryNumber, "Box with silver jewelry");
			} else {
				return new SilverJewelry(value, inventaryNumber, description);
			}

		} else if (treasureType.equals("GoldCoin")) {

			if (description == null) {
				return new GoldCoin(value, inventaryNumber, "Bag with gold coins");
			} else {
				return new GoldCoin(value, inventaryNumber, description);
			}

		} else if (treasureType.equals("SilverCoin")) {
			if (description == null) {
				return new SilverCoin(value, inventaryNumber, "Bag with silver coins");
			} else {
				return new SilverCoin(value, inventaryNumber, description);
			}

		} else if (treasureType.equals("Diamond")) {
			if (description == null) {
				return new Diamond(value, inventaryNumber, "Box with diamonds");
			} else {
				return new Diamond(value, inventaryNumber, description);
			}

		} else if (treasureType.equals("Ruby")) {
			if (description == null) {
				return new Ruby(value, inventaryNumber, "Box with rubies");
			} else {
				return new Ruby(value, inventaryNumber, description);
			}
		}

		if (description == null) {
			return new Sapphire(value, inventaryNumber, "Box with sapphire");
		}
		
		return new Sapphire(value, inventaryNumber, description);
	}
}