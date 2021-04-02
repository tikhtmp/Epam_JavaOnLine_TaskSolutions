package by.epam_training.java_online.module4.simple_classes.task8_customer.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import by.epam_training.java_online.module4.simple_classes.task8_customer.entity.Customer;
import by.epam_training.java_online.module4.simple_classes.task8_customer.entity.Shop;

public class ShopLogic {

	public static List<Customer> findCustomersInsideRange(Shop shop, int start, int end) {
		
		
		List<Customer> filtered = new ArrayList<>();

		for (Customer c : shop.getCustomers()) {

			if (isInsideRange(c, start, end)) {
				filtered.add(c);
			}
		}

		return filtered;
	}

	public static boolean isInsideRange(Customer c, int start, int end) {
		if (c.getCardNumber() < start || c.getCardNumber() > end) {
			return false;
		} else
			return true;
	}
	
	public static void addCustomer(Shop shop, Customer customer) {
		shop.getCustomers().add(customer);
	}
	
	public static void removeCustomer(Shop shop, Customer customer) {
		if (shop.getCustomers().contains(customer))
		shop.getCustomers().remove(customer);
	}
	
	public static void sortCustomers(Shop shop) {
		Collections.sort(shop.getCustomers());
	}
}
