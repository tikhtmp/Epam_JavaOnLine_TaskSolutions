package by.epam_training.java_online.module4.composition_and_aggregation.task4_account.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import by.epam_training.java_online.module4.composition_and_aggregation.task4_account.entity.Account;
import by.epam_training.java_online.module4.composition_and_aggregation.task4_account.entity.Client;

public class ClientLogic {

	public static double getTotalBalans(Client client, int selector) {

		double total = 0.0;

		switch (selector) {

		case 1: {
			for (Account a : client.getAccounts()) {
				if (a.getBalans() > 0)
					total = total + a.getBalans();
			}
			return total;
		}

		case -1: {
			for (Account a : client.getAccounts()) {
				if (a.getBalans() < 0)
					total = total + a.getBalans();
			}
			return total;
		}

		default: {
			for (Account a : client.getAccounts()) {
				total = total + a.getBalans();
			}
			return total;
		}
		}
	}

	public static double getBalans(List<Account> accounts) {

		double total = 0.0;

		for (Account a : accounts) {
			total = total + a.getBalans();
		}

		return total;
	}

	public static void sortAccountsByNumber(Client client) {
		Collections.sort(client.getAccounts());
	}

	public static void sortAccountsByBalans(Client client) {

		Collections.sort(client.getAccounts(), new Comparator<Account>() {
			@Override
			public int compare(Account acc1, Account acc2) {
				return Double.compare(acc1.getBalans(), acc2.getBalans());
			}
		});
	}

	public static void sortAccountsByIsBlocked(Client client) {
		Collections.sort(client.getAccounts(), new Comparator<Account>() {
			@Override
			public int compare(Account acc1, Account acc2) {
				return Boolean.compare(acc1.isBlocked(), acc2.isBlocked());
			}
		});
	}

	public static List<Account> findAccounts(Client client, String param) {
		List<Account> result = new ArrayList<Account>();

		for (Account a : client.getAccounts()) {
			if (a.getNumber().contains(param))
				result.add(a);
		}

		if (result.size() > 0) {
			System.out.println("On request: " + client.getName() + " \"" + param + "\"" + " is found:");
		} else {
			System.out.println("Nothing has been found on request: " + client.getName() + " \"" + param + "\".");
		}

		return result;
	}
}
