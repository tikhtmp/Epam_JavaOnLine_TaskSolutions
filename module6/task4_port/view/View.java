package by.epam_training.java_online.module6.task4_port.view;

import by.epam_training.java_online.module6.task4_port.bean.Ship;

public class View {
	public static synchronized void  display (Ship ship) {
		System.out.println("A new ship arrived - " + ship.getName() + " : " + ship.getCapacity() + " : " + ship.getCargo());
	}
	
	public static synchronized void display (String report) {
		System.out.println(report);
	}

}
