/*
Модуль 4. Агрегация и композиция.
Задача 4.
Условие: Счета. Клиент может иметь несколько счетов в банке. Учитывать возможность блокировки/разблокировки
счета. Реализовать поиск и сортировку счетов. Вычисление общей суммы по счетам. Вычисление суммы по 
всем счетам, имеющим положительный и отрицательный баланс.
*/
package by.epam_training.java_online.module4.composition_and_aggregation.task4_account.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import by.epam_training.java_online.module4.composition_and_aggregation.task4_account.entity.Account;
import by.epam_training.java_online.module4.composition_and_aggregation.task4_account.entity.Client;
import by.epam_training.java_online.module4.composition_and_aggregation.task4_account.logic.ClientLogic;
import by.epam_training.java_online.module4.composition_and_aggregation.task4_account.view.ClientView;

public class Main {

	public static void main(String[] args) {
		Account acc1 = new Account("BY67AKBB24240000538493010000", false, 100.12);
		Account acc2 = new Account("BY67AKBB24240000134593015000", false, -25.82);
		Account acc3 = new Account("BY67AKBB24240000258983010120", true, -140.00);
		Account acc4 = new Account("BY67AKBB24240000448933010011", false, -1.92);
		Account acc5 = new Account("BY67AKBB24240000888412016508", false, 558.18);
		List<Account> accs = new ArrayList<Account>(Arrays.asList(acc1, acc2, acc3, acc4, acc5));

		Client client = new Client("Peters Jeff", accs);
		ClientView.display(client);

		double balans = ClientLogic.getTotalBalans(client, 0); // общая сумма по счетам
		System.out.print("Total " + client.getName() + " balans: ");
		ClientView.displayBalans(balans);

		balans = ClientLogic.getTotalBalans(client, 1); // общая сумма по счетам с положительным балансом
		System.out.print("Total " + client.getName() + " positive balans: ");
		ClientView.displayBalans(balans);

		balans = ClientLogic.getTotalBalans(client, -1); // общая сумма по счетам с отрицательным балансом
		System.out.print("Total " + client.getName() + " negative balans: ");
		ClientView.displayBalans(balans);
		System.out.println();

		System.out.println("Accounts sorted by number.");
		ClientLogic.sortAccountsByNumber(client); // сортировка счетов по номерам
		ClientView.display(client);
		
		System.out.println("Accounts sorted by balans.");
		ClientLogic.sortAccountsByBalans(client); // сортировка счетов по балансу
		ClientView.display(client);
		
		System.out.println("Accounts sorted by status.");
		ClientLogic.sortAccountsByIsBlocked(client); // сортировка счетов по статусу (блокирован/не блокирован)
		ClientView.display(client);
		
		List<Account> filtered = ClientLogic.findAccounts(client, "010"); // поиск счета по параметру
		ClientView.display(client, filtered);
		
		filtered = ClientLogic.findAccounts(client, "BY67AKBB24240000134593015000"); // поиск счета по параметру
		ClientView.display(client, filtered);
		
		filtered = ClientLogic.findAccounts(client, "safa"); // поиск счета по параметру(некорректные параметры)
		ClientView.display(client, filtered);
	}

}
