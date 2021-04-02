/*
Модуль 5. Задача 2.
Условие:
Создать класс Payment с внутренним классом, с помощью объектов которого можно сформировать покупку из 
нескольких товаров 
*/

package by.epam_training.java_online.module5.task2_payment.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Payment implements Comparable<Payment>, Serializable {

	private static final long serialVersionUID = 1L;
	private List<Item> purchaseList = new ArrayList<Item>();

	public Payment() {
	}

	public Payment(List<Item> purchaseList) {
		this.purchaseList = purchaseList;
	}

	public void addItem(Item item) {
		purchaseList.add(item);
	}

	public void removeItem(Item item) {
		purchaseList.remove(item);
	}

	public void setPurchaseList(List<Item> purchaseList) {
		this.purchaseList = purchaseList;
	}

	public List<Item> getPurchaseList() {
		return purchaseList;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (getClass() != obj.getClass())
			return false;

		Payment other = (Payment) obj;

		if (purchaseList == null) {
			if (other.purchaseList != null)
				return false;
		} else if (!purchaseList.equals(other.purchaseList))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		int result = 1;
		final int prime = 31;
		result = result * prime + ((purchaseList == null) ? 0 : purchaseList.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [purchaseList=" + purchaseList + "]";
	}

	@Override
	public int compareTo(Payment other) {
		return purchaseList.size() - other.purchaseList.size();
	}

	/*внутренний класс*/
	public static class Item implements Comparable<Item>, Serializable{
		
		private static final long serialVersionUID = 1L;
		private String title;
		private double price;

		public Item() {
		}

		public Item(String title, double price) {
			this.title = title;
			this.price = price;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public String getTitle() {
			return title;
		}

		public double getPrice() {
			return price;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			long temp;
			temp = Double.doubleToLongBits(price);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			result = prime * result + ((title == null) ? 0 : title.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;

			Item other = (Item) obj;

			if (title == null) {
				if (other.title != null)
					return false;
			} else if (!title.equals(other.title))
				return false;

			if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
				return false;

			return true;
		}

		@Override
		public String toString() {
			return getClass().getSimpleName() + " [title=" + title + ", price=" + price + "]";
		}

		@Override
		public int compareTo(Item other) {		
			return Double.compare(price, other.price);
		}
	}
}
