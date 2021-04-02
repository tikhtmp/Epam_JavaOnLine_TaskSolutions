package by.epam_training.java_online.module4.simple_classes.task8_customer.entity;

import java.util.List;

public class Shop {
	private String name;
	private List<Customer> customers;

	public Shop() {
		name = null;
		customers = null;
	}

	public Shop(String name, List<Customer> customers) {
		this.name = name;
		this.customers = customers;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (getClass() != obj.getClass())
			return false;

		Shop other = (Shop) obj;

		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name)) {
			return false;
		}

		if (customers == null) {
			if (other != null)
				return false;
		} else if (!customers.equals(other.customers)) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = result * prime + ((name == null) ? 0 : name.hashCode());
		result = result * prime + ((customers == null) ? 0 : customers.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "[name=" + name + ", customers=" + customers + "]";
	}
}
