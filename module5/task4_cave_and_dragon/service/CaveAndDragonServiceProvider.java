package by.epam_training.java_online.module5.task4_cave_and_dragon.service;

import by.epam_training.java_online.module5.task4_cave_and_dragon.service.impl.CaveAndDragonServiceImpl;

public class CaveAndDragonServiceProvider {

	private static final CaveAndDragonServiceProvider instance = new CaveAndDragonServiceProvider();
	private static CaveAndDragonServiceImpl caveAndDragonServiceImpl = new CaveAndDragonServiceImpl();

	private CaveAndDragonServiceProvider() {
	}

	public static CaveAndDragonServiceProvider getInstance() {
		return instance;
	}

	public static CaveAndDragonServiceImpl getCaveAndDragonServiceImpl() {
		return caveAndDragonServiceImpl;
	}

}
