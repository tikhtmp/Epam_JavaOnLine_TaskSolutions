package by.epam_training.java_online.module5.task4_cave_and_dragon.service;

import java.util.List;

import by.epam_training.java_online.module5.task4_cave_and_dragon.bean.Cave;
import by.epam_training.java_online.module5.task4_cave_and_dragon.bean.Knight;
import by.epam_training.java_online.module5.task4_cave_and_dragon.bean.Treasure;

public interface CaveAndDragonService {
	
	public void createTreasureFile() throws CaveAndDragonServiceException;
	
	public List<Treasure> readTreasureFile() throws CaveAndDragonServiceException;

	public boolean searchCave(Knight knight, Cave cave);
	
	public void fight(Knight knight, Cave cave);
	
	public void examineTreasure(Cave cave);

	public List<Treasure> selectRandomTreasureForSum(int sum, Cave cave);
	
	public void disposeTreasures(Knight knight, Cave cave);
}
