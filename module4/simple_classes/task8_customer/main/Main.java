/*
Модуль 4. Простейшие классы и объекты. 
Задача 8.
Создать класс Customer, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы
и метод toString(). Создать второй класс, агрегирующий массив типа Customer, с подходящими конструкторами
и методами. Задать критерии выбора данных и вывести эти данные на консоль.
Класс Customer: id, фамилия, имя, отчество, номер кредитной карточки, номер банковского счета.
Найти и вывести:
а) список покупателей в алфавитном порядке;
б) список покупателей, у которых номер кредитной карточки находится в заданном интервале.
*/
package by.epam_training.java_online.module4.simple_classes.task8_customer.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import by.epam_training.java_online.module4.simple_classes.task8_customer.entity.Customer;
import by.epam_training.java_online.module4.simple_classes.task8_customer.entity.Shop;
import by.epam_training.java_online.module4.simple_classes.task8_customer.logic.ShopLogic;
import by.epam_training.java_online.module4.simple_classes.task8_customer.view.ShopView;

public class Main {
	public static void main(String[] args) {
		
		Customer c1 = new Customer("Peters Jeff", "775 Westminster Avenue APT D5 Brooklyn, NY, 11230", 123, 456789);
		Customer c2 = new Customer("Tucker Andy", "611 Westminster Avenue APT D5 Brooklyn, NY, 11230", 511, 346157);
		Customer c3 = new Customer("Tennyson Albert", "8141 Indian Spring Avenue Mission, TX 78572", 440, 892218);
		Customer c4 = new Customer("James Hilary", "9423 Hamilton Dr.Hayward, CA 94544", 80, 116559);
		Customer c5 = new Customer("Kowalski Jane", "473 South River Ave.Titusville, FL 32780", 891, 752910);

		List<Customer> petShopCustomers = new ArrayList<>(Arrays.asList(c1, c2, c3, c4, c5));

		Shop petShop = new Shop("Pet shop", petShopCustomers);
		ShopView.display(petShop);
		
		Customer c6 = new Customer("Edwards Donald", "7972 Foxrun Ave. Oklahoma City, OK 73132", 8, 140532);

		System.out.println("Adding a new customer.");
		ShopLogic.addCustomer(petShop, c6);
		ShopView.display(petShop);
		
		System.out.println("Deleting the customer 3.");
		ShopLogic.removeCustomer(petShop, c3);
		ShopView.display(petShop);
		
		Collections.sort(petShopCustomers);
		System.out.println("Customers sorted by name:");
		ShopLogic.sortCustomers(petShop);
		ShopView.display(petShop);
		
		System.out.println("These customers have card's number from 10 to 800 (version2):");
		ShopView.display((ShopLogic.findCustomersInsideRange(petShop, 10, 800)));
	}
}
