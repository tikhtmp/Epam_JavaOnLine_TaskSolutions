/*
Модуль 4. Агрегация и композиция.
Задача 4.
Условие: Счета. Клиент может иметь несколько счетов в банке. Учитывать возможность блокировки/разблокировки
счета. Реализовать поиск и сортировку счетов. Вычисление общей суммы по счетам. Вычисление суммы по 
всем счетам, имеющим положительный и отрицательный баланс.
*/

package by.epam_training.java_online.module4.composition_and_aggregation.task4_account.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Client implements Comparable<Client>, Serializable {

	private static final long serialVersionUID = 1L;
	private static int clientCount = 0;
	private final int id;
	private String name;
	private List<Account> accounts;

	public Client() {
		id = ++clientCount;
		name = null;
		accounts = null;
	}

	public Client(String name, Account account) {
		id = ++clientCount;
		this.name = name;
		this.accounts = new ArrayList<Account>(Arrays.asList(account));
	}

	public Client(String name, List<Account> accounts) {
		id = ++clientCount;
		this.name = name;
		this.accounts = accounts;
	}

	public int getClientCount() {
		return clientCount;
	}

	public int getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public List<Account> getAccounts() {
		return this.accounts;
	}

	public Account getAccount(int i) {
		return this.accounts.get(i);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		Client other = (Client) obj;

		if (id != other.id)
			return false;

		if (name == null) {
			if (other.name != null)
				return false;
		} else if (name.equals(other.name))
			return false;

		if (accounts == null) {
			if (other.accounts != null)
				return false;
		} else if (accounts.equals(other.accounts))
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = result * prime + id;
		result = result * prime + ((name == null) ? 0 : name.hashCode());
		result = result * prime + ((accounts == null) ? 0 : accounts.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [clientCount=" + clientCount + ", id=" + id + ", name=" + name + ", accounts="
				+ accounts + "]";
	}

	@Override
	public int compareTo(Client other) {
		return name.compareTo(other.name);
	}
}
