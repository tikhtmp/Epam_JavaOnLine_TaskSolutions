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

package by.epam_training.java_online.module4.simple_classes.task8_customer.entity;

public class Customer implements Comparable<Customer> {

	private static int customerCount = 0;
	private final int id;
	private final String name;
	private String address;
	private int cardNumber;
	private int account;

	public Customer() {
		id = ++customerCount;
		name = "";
		address = "";
		cardNumber = 0;
		account = 0;
	};

	public Customer(String name, String address, int cardNumber, int account) {
		this.id = ++customerCount;
		this.name = name;
		this.address = address;
		this.cardNumber = cardNumber;
		this.account = account;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getCardNumber() {
		return this.cardNumber;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}

	public int getAccount() {
		return this.account;
	}

	public void setAccount(int account) {
		this.account = account;
	}

	@Override
	public boolean equals(Object obj) {
	
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		Customer other = (Customer) obj;
		
		if (id != other.id)
			return false;
		if(name == null) {
			if(other.name != null) return false;
		} else	if (!name.equals(other.name))
			return false;
		
		if (address == null) {
			if(other.address != null) return false;
		}else if (!address.equals(other.address))
			return false;
		
		if (cardNumber != other.cardNumber)
			return false;
		
		if (account != other.account)
			return false;
		
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = result * prime + id;
		result = result * prime + ((name == null) ? 0 : name.hashCode());
		result = result * prime + ((address == null) ? 0: address.hashCode());
		result = result * prime + cardNumber;
		result = result * prime + account;
		return result;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [ID=" + id + ", name=" + name + ", address=" + address + ", cardNumber="
				+ cardNumber + ", account=" + account + "]";
	}
	
	@Override
	public int compareTo(Customer c) {
		return name.compareTo(c.name);
	}
}