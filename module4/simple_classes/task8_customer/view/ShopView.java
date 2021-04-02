package by.epam_training.java_online.module4.simple_classes.task8_customer.view;

import java.util.List;

import by.epam_training.java_online.module4.simple_classes.task8_customer.entity.Customer;
import by.epam_training.java_online.module4.simple_classes.task8_customer.entity.Shop;
import by.epam_training.java_online.module4.simple_classes.task8_customer.logic.ShopLogic;

public class ShopView {

	public static void display(Customer customer) {
		System.out.format("%-2s%04d  %-5s %-16s %-8s %-50s   %-12s %04d  %-8s %08d\n", "id: ", customer.getId(),
				"Name:", customer.getName(), "Address:", customer.getAddress(), "Card number:",
				customer.getCardNumber(), "Account:", customer.getAccount());
	}

	public static void display(Shop shop) {
		List<Customer> customers = shop.getCustomers();
		for (Customer c : customers) {
			display(c);
		}
		System.out.println();
	}

	public static void display(Shop shop, int start, int end) {

		for (Customer c : shop.getCustomers()) {

			if (ShopLogic.isInsideRange(c, start, end))
				display(c);
		}
		System.out.println();
	}

	public static void display(List<Customer> customerList) {

		for (Customer c : customerList) {
			display(c);
		}

		System.out.println();
	}

}
