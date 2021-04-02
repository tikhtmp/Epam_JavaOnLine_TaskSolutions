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

Вариант А. Цветочная композиция. Реализовать приложение, позволяющее создавать цветочные композиции
(объект, представляющий собой цветочную композицию). Составляющими цветочной композиции являются цветы 
и упаковка.
*/

package by.epam_training.java_online.module5.task5_bouquet.main;

import by.epam_training.java_online.module5.task5_bouquet.bean.Bouquet;
import by.epam_training.java_online.module5.task5_bouquet.view.ViewBouquet;
import by.epam_training.java_online.module5.task5_bouquet.service.BouquetService;
import by.epam_training.java_online.module5.task5_bouquet.service.BouquetServiceException;

public class Main {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException,
			IllegalAccessException, BouquetServiceException {

		String bouquet1 = "paper=white, watercolor type | rose=red, sort Falstaff | tulip=yellow, sort Avocado";
		Bouquet b1 = BouquetService.createBouquet(bouquet1);
		ViewBouquet.displayBouquet(b1);

		String bouquet2 = "box=black, plastic | rose=white, sort Cinderella | Carnation=orange, sort Desperation | tulip=multicolor, sort Chinese";
		Bouquet b2 = BouquetService.createBouquet(bouquet2);
		ViewBouquet.displayBouquet(b2);

		/* раскоментировать, чтобы проверить работу валидации запроса */
//		String bouquet3 = "baske=green, straw| rose=white, sort Cinderella | rose=red, sort Cinderella | rose=white, sort Cinderella";
//		Bouquet b3 = BouquetService.createBouquet(bouquet3);
//		ViewBouquet.displayBouquet(b3);
	}

}
