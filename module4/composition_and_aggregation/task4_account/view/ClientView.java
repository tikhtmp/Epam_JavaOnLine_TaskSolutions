package by.epam_training.java_online.module4.composition_and_aggregation.task4_account.view;

import java.util.List;

import by.epam_training.java_online.module4.composition_and_aggregation.task4_account.entity.Account;
import by.epam_training.java_online.module4.composition_and_aggregation.task4_account.entity.Client;
import by.epam_training.java_online.module4.composition_and_aggregation.task4_account.logic.ClientLogic;

public class ClientView {

	private static void display(Account acc) {
		System.out.format("%28s  |  %8.2f  |  ", acc.getNumber(), acc.getBalans());
		if (!acc.isBlocked()) {
			System.out.format("%-10s\n", "available");
		} else {
			System.out.format("%-10s\n", "blocked");
		}
	}

	public static void display(Client c, List<Account> accs) {

		if (accs.size() > 0) {
			displayHeader();

			for (Account a : accs) {
				display(a);
			}

			displayLine();
			double balans = ClientLogic.getBalans(accs);
			System.out.format("%31s", "Total:");
			displayBalans(balans);
			System.out.println();
		}
	}

	public static void display(Client c) {
		System.out.println("Client: " + c.getName());
		displayHeader();

		for (Account a : c.getAccounts()) {
			display(a);
		}

		displayLine();
		double balans = ClientLogic.getTotalBalans(c, 0);
		System.out.format("%31s", "Total:");
		displayBalans(balans);
		System.out.println();
	}

	public static void displayBalans(double balans) {
		System.out.format("%9.2f\n", balans);
	}

	private static void displayLine() {
		System.out.println("-------------------------------------------------------");
	}

	private static void displayHeader() {
		displayLine();
		System.out.format("%-28s  |  %-8s  |  %-8s\n", "       Account number", " Balans", " Status");
		displayLine();
	}
}
