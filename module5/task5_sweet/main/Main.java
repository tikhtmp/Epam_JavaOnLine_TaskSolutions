/*
Модуль 5. Задача 5.
Условие:
Создать консольное приложение, удовлетворяющее следующим требованиям:
- Корректно спроектируйте и реализуйте предметную область задачи.
- Для создания объектов из иерархии классов продумайте возможность использования порождающих шаблонов проектирования.
- Реализуйте проверку данных, вводимых пользователем, но не на стороне клиента.
- Для проверки корректности переданных данных можно применить регулярные выражения.
- Меню выбора действия пользователем можно не реализовывать, используйте заглушку.
- Особое условие: переопределите, где необходимо, методы toString(), equals(), и hashCode().

Вариант В. Подарки. Реализовать приложение, позволяющее создавать подарки (объект, представляющий собой 
подарок). Составляющими целого подарка являются сладости и упаковка.
*/
package by.epam_training.java_online.module5.task5_sweet.main;

import by.epam_training.java_online.module5.task5_sweet.bean.GiftBag;
import by.epam_training.java_online.module5.task5_sweet.service.SweetService;
import by.epam_training.java_online.module5.task5_sweet.service.SweetServiceException;
import by.epam_training.java_online.module5.task5_sweet.view.SweetView;

public class Main {

	public static void main(String[] args) throws SweetServiceException {

		String gift1 = "box=cardboard, candy=M&M, cookie=Barney, chocolate=Alpen Gold";
		GiftBag giftBag1 = SweetService.createGiftBag(gift1);
		SweetView.displayGiftBag(giftBag1);

		String gift2 = "plasticBag=transparent, candy=Honey, cookie=Oats, chocolate=Kommunarka";
		GiftBag giftBag2 = SweetService.createGiftBag(gift2);
		SweetView.displayGiftBag(giftBag2);

		/* раскоментировать, чтобы проверить работу валидации запроса */
//		String gift3 = "paprBag=transparent, candy=Dushes, cookie=Chess, chocolate=Alenka";
//		GiftBag giftBag3 = SweetService.createGiftBag(gift3);
//		SweetView.displayGiftBag(giftBag3);

	}
}
