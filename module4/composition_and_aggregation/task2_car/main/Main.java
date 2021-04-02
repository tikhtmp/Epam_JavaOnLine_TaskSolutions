/*
Модуль 4. Агрегация и композиция.
Задача 2.
Условие: Создать объет класса Автомобиль, используя классы Колесо, Двигатель. Методы: ехать, заправляться,
менять колесо, вывести на консоль марку автомобиля.
*/

package by.epam_training.java_online.module4.composition_and_aggregation.task2_car.main;

import by.epam_training.java_online.module4.composition_and_aggregation.task2_car.entity.Car;
import by.epam_training.java_online.module4.composition_and_aggregation.task2_car.entity.Engine;
import by.epam_training.java_online.module4.composition_and_aggregation.task2_car.entity.StockWheel;
import by.epam_training.java_online.module4.composition_and_aggregation.task2_car.logic.CarLogic;
import by.epam_training.java_online.module4.composition_and_aggregation.task2_car.view.CarView;

public class Main {

	public static void main(String[] args) {
		Engine engine = new Engine ("Diesel 40 TDI");
		Car audiA6 = new Car ("Audi A6", engine);
		audiA6.setFrontRight(audiA6.new Wheel("Continental 245/45 R17"));
		audiA6.setFrontLeft(audiA6.new Wheel("Continental 245/45 R17"));
		audiA6.setRearRight(audiA6.new Wheel("Continental 245/45 R17"));
		audiA6.setRearLeft(audiA6.new Wheel("Continental 245/45 R17"));

		
		CarView.displayBrand(audiA6); // показать марку
		CarLogic.fillUpTank(audiA6);  // заправиться
		audiA6.move(); // ехать
		CarLogic.changeWheel(audiA6.getFrontRight(), new StockWheel("Belshina 245/45 R17")); // замена колеса
		
	}
}
