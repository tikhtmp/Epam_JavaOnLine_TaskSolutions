package by.epam_training.java_online.module5.task4_cave_and_dragon.controller;

import java.util.List;

import by.epam_training.java_online.module5.task4_cave_and_dragon.bean.Cave;
import by.epam_training.java_online.module5.task4_cave_and_dragon.bean.Dragon;
import by.epam_training.java_online.module5.task4_cave_and_dragon.bean.Knight;
import by.epam_training.java_online.module5.task4_cave_and_dragon.bean.Treasure;
import by.epam_training.java_online.module5.task4_cave_and_dragon.service.CaveAndDragonServiceException;
import by.epam_training.java_online.module5.task4_cave_and_dragon.service.CaveAndDragonServiceProvider;
import by.epam_training.java_online.module5.task4_cave_and_dragon.service.impl.CaveAndDragonServiceImpl;
import by.epam_training.java_online.module5.task4_cave_and_dragon.view.CaveAndDragonView;

public class DragonAndTreasureController {

	public static void startGame() throws CaveAndDragonControllerException {

		CaveAndDragonServiceImpl serviceAction = CaveAndDragonServiceProvider.getCaveAndDragonServiceImpl();

		try {
			serviceAction.createTreasureFile();
		} catch (CaveAndDragonServiceException e) {
			throw new CaveAndDragonControllerException(e);
		}

		Dragon dragon = new Dragon();
		List<Treasure> treasures;

		try {
			treasures = serviceAction.readTreasureFile();
		} catch (CaveAndDragonServiceException e) {
			throw new CaveAndDragonControllerException(e);
		}

		Cave cave = new Cave(treasures, dragon);
		Knight knight = new Knight();

		if (serviceAction.searchCave(knight, cave)) {
			serviceAction.fight(knight, cave);
		}

		int sum = 3468;

		CaveAndDragonView.displayMessage("\nRandom treasures for sum " + sum + "(var1):");
		List<Treasure> list = serviceAction.selectTreasureForSum(sum, cave);
		CaveAndDragonView.displayTreasure(list);

		CaveAndDragonView.displayMessage("\nRandom treasures for sum " + sum + "(var2):");
		List<Treasure> list1 = serviceAction.selectRandomTreasureForSum(sum, cave);
		CaveAndDragonView.displayTreasure(list1);

		CaveAndDragonView.displayMessage("\n" + knight.getName() + ": How will I spend the treasure?");

		serviceAction.disposeTreasures(knight, cave);
		
		CaveAndDragonView.displayMessage("GAME OVER");

	}
}
