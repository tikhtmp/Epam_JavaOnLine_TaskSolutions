/*
Модуль 5. Задача 4.
Условие:
Создать консольное приложение, удовлетворяющее следующим требованиям:
- Приложение должно быть объектно-, а не процедурно-ориентированным.
- Каждый класс должен иметь отражающее смысл название и информативный состав.
- Наследование должно применяться только тогда, когда это имеет смысл.
- При кодировании должны быть использованы соглашения об оформлении кода java code convention.
- Классы должны быть грамотно разложены по пакетам.
- Консольное меню должно быть минимальным.
- Для хранения данных можно использовать файлы.

Дракон и его сокровища. Создать программу, позволяющую обрабатывать сведения о 100 сокровищах в пещере
дракона. Реализовать возможность просмотра сокровищ, выбора самого дорогого по стоимости сокровища и 
выбора сокровищ на заданную сумму.

*/

package by.epam_training.java_online.module5.task4_cave_and_dragon.main;

import by.epam_training.java_online.module5.task4_cave_and_dragon.controller.CaveAndDragonControllerException;
import by.epam_training.java_online.module5.task4_cave_and_dragon.controller.DragonAndTreasureController;

public class Main {

	public static void main(String[] args) throws CaveAndDragonControllerException {
		DragonAndTreasureController.startGame();
	}
}
