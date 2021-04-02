package by.epam_training.java_online.module5.task4_cave_and_dragon.service.impl;

import java.util.ArrayList;
import java.util.List;

import by.epam_training.java_online.module5.task4_cave_and_dragon.bean.Cave;
import by.epam_training.java_online.module5.task4_cave_and_dragon.bean.Dragon;
import by.epam_training.java_online.module5.task4_cave_and_dragon.bean.Knight;
import by.epam_training.java_online.module5.task4_cave_and_dragon.bean.Treasure;
import by.epam_training.java_online.module5.task4_cave_and_dragon.dao.CaveAndDragonDAOException;
import by.epam_training.java_online.module5.task4_cave_and_dragon.dao.CaveAndDragonDAOProvider;
import by.epam_training.java_online.module5.task4_cave_and_dragon.dao.impl.CaveAndDragonDAOImpl;
import by.epam_training.java_online.module5.task4_cave_and_dragon.service.CaveAndDragonService;
import by.epam_training.java_online.module5.task4_cave_and_dragon.service.CaveAndDragonServiceException;
import by.epam_training.java_online.module5.task4_cave_and_dragon.service.util.SelectSubsetForSum;
import by.epam_training.java_online.module5.task4_cave_and_dragon.view.CaveAndDragonView;

public class CaveAndDragonServiceImpl implements CaveAndDragonService {

	private static CaveAndDragonDAOImpl DAO_Action = CaveAndDragonDAOProvider.getInstance().getCaveAndDragonDAOImpl();

	@Override
	public void createTreasureFile() throws CaveAndDragonServiceException {

		try {
			DAO_Action.createTreasureFile();
		} catch (CaveAndDragonDAOException e) {
			throw new CaveAndDragonServiceException(e);
		}
	}

	@Override
	public List<Treasure> readTreasureFile() throws CaveAndDragonServiceException {

		List<Treasure> result;

		try {
			result = DAO_Action.readTreasureFile();
		} catch (CaveAndDragonDAOException e) {
			throw new CaveAndDragonServiceException(e);
		}

		return result;
	}

	public List<Treasure> selectTreasureForSum(int sum, Cave cave) {

		List<Treasure> treasures = cave.getTreasures();
		int arrTreasures[] = new int[treasures.size()];

		for (int i = 0; i < treasures.size(); i++) {
			arrTreasures[i] = treasures.get(i).getValue();
		}

		int arr[] = arrTreasures;
		int n = arr.length;

		SelectSubsetForSum.findAllSubsets(arr, n, sum);
		List<Integer> set = SelectSubsetForSum.result;
		List<Treasure> result = new ArrayList<Treasure>();

		for (Integer value : set) {
			result.add(selectTreasureByValue(value, cave));
		}

		if (result.isEmpty()) {
			System.out.println("There are no treasures for sum " + sum);
		}

		return result;
	}

	@Override
	public List<Treasure> selectRandomTreasureForSum(int sum, Cave cave) {
		List<Treasure> treasures = cave.getTreasures();
		List<Treasure> result = new ArrayList<Treasure>();
		List<Integer> list = new ArrayList<Integer>();
		int index = 0;
		long selectionTime = System.currentTimeMillis();
		System.out.println("Treasure selection...");

		while (calculateTotallValue(result) != sum) {

			index = (int) (Math.random() * 100);

			if (!list.contains(index)) {
				result.add(treasures.get(index));
				list.add(index);
			}

			if (calculateTotallValue(result) > sum) {
				result.clear();
				list.clear();
			}

			if (System.currentTimeMillis() - selectionTime > 5000) {
				System.out.println("Nothing has been found for sum " + sum);
				break;
			}
		}

		return result;
	}

	private static Treasure selectTreasureByValue(Integer value, Cave cave) {

		for (Treasure t : cave.getTreasures()) {

			if (t.getValue() == value) {
				return t;
			}
		}

		return null;
	}

	public static List<Treasure> findMostValueTreasure(List<Treasure> treasures) {

		int max = 0;
		List<Treasure> result = new ArrayList<Treasure>();

		for (Treasure t : treasures) {

			if (max < t.getValue()) {
				result.clear();
				result.add(t);
				max = t.getValue();
			} else if (max == t.getValue()) {
				result.add(t);
			}
		}

		return result;
	}

	public static List<Treasure> findMinValueTreasure(List<Treasure> treasures) {

		int min = Integer.MAX_VALUE;
		List<Treasure> result = new ArrayList<Treasure>();

		for (Treasure t : treasures) {

			if (min > t.getValue()) {
				result.clear();
				result.add(t);
				min = t.getValue();
			} else if (min == t.getValue()) {
				result.add(t);
			}
		}

		return result;
	}

	public static int calculateTotallValue(List<Treasure> treasures) {

		int sum = 0;

		for (Treasure t : treasures) {

			sum = sum + t.getValue();
		}

		return sum;
	}

	@Override
	public boolean searchCave(Knight knight, Cave cave) {

		if (cave != null) {
			knight.say("I've found a cave.");

			if (cave.getTreasures() != null) {
				knight.say("There are treasures in it.");
			}

			if (cave.getDragon() != null) {
				knight.say("And a dragon too!!!");
				cave.getDragon().say("Hhhhhhhhh! I'll kill you!!!");
			}

			return true;
		}

		knight.say("I haven't found a cave...");
		return false;
	}

	@Override
	public void fight(Knight knight, Cave cave) {
		Dragon dragon = cave.getDragon();

		if (Math.random() > 0.3) {
			knight.say("I killed the dragon!!!");
			dragon.setAlive(false);
			knight.say("All these are mine:");
		} else {
			knight.setAlive(false);
			dragon.say("Nobody can touch my treasures!");
			dragon.say("All these are mine:");
		}

		examineTreasure(cave);
	}

	@Override
	public void examineTreasure(Cave cave) {
		List<Treasure> treasures = cave.getTreasures();
		CaveAndDragonView.displayTreasure(treasures);
		CaveAndDragonView.displayMessage("\nThe most valued treasures are:");
		CaveAndDragonView.displayTreasure(findMostValueTreasure(treasures));
	}

	@Override
	public void disposeTreasures(Knight knight, Cave cave) {
		
		if (Math.random() > 0.3) {
			knight.say("All the treasures will be spent for charity");
			knight.setName("knight St. George");
			knight.say("It's time to go");
		} else {
			knight.say("The treasures are so beauty!");
			knight.setAlive(false);
			Dragon newDragon = new Dragon();
			newDragon.setName("dragon Seduced Knight");
			cave.setDragon(newDragon);
			newDragon.say("Nobody can touch my treasures!");
		}
	}
}
