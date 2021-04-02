package by.epam_training.java_online.module4.composition_and_aggregation.task4_account.entity;

import java.io.Serializable;

public class Account implements Comparable<Account>, Serializable {

	private static final long serialVersionUID = 1L;
	private String number;
	private boolean isBlocked;
	private double balans;

	public Account() {
		number = null;
		isBlocked = false;
		balans = 0;
	}

	public Account(String number, boolean isBlocked, double balans) {
		this.number = number;
		this.isBlocked = isBlocked;
		this.balans = balans;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getNumber() {
		return number;
	}

	public void setIsBlocked(boolean isBlocked) {
		this.isBlocked = isBlocked;
	}

	public boolean isBlocked() {
		return isBlocked;
	}

	public void setBalans(double balans) {
		this.balans = balans;
	}

	public double getBalans() {
		return balans;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		Account other = (Account) obj;

		if (number == null) {
			if (other != null)
				return false;
		} else if (!number.equals(other.number))
			return false;

		if (isBlocked != other.isBlocked)
			return false;

		if (Double.doubleToLongBits(balans) != Double.doubleToLongBits(other.balans))
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = result * prime + ((number == null) ? 0 : number.hashCode());
		result = result * prime + (isBlocked ? 1231 : 1237);
		result = result * prime + (int) balans;
		return result;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [number=" + number + ", isBlocked=" + isBlocked + ", balans=" + balans + "]";
	}

	@Override
	public int compareTo(Account other) {
		return number.compareTo(other.number);
	}

}
