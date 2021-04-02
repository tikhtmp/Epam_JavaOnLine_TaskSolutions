/*
Модуль 5. Задача 2.
Условие:
Создать класс Payment с внутренним классом, с помощью объектов которого можно сформировать покупку из 
нескольких товаров 
*/

package by.epam_training.java_online.module5.task2_payment.main;

import by.epam_training.java_online.module5.task2_payment.entity.Payment;
import by.epam_training.java_online.module5.task2_payment.entity.Payment.Item;
import by.epam_training.java_online.module5.task2_payment.view.PaymentView;

public class Main {
	
	public static void main (String[] args) {
		
		PaymentView paymentViewing = PaymentView.getInstance();
		
		Payment testPayment = new Payment ();
		
		Payment.Item i1 = new Item("Bread", 1.45);
		Payment.Item i2 = new Item("Milk", 1.10);
		Payment.Item i3 = new Item("Eggs", 2.61);

		testPayment.addItem(i1);
		testPayment.addItem(i2);
		testPayment.addItem(i3);
		
		paymentViewing.displayPayment(testPayment);
		
		testPayment.removeItem(i2);
		
		paymentViewing.displayPayment(testPayment);
	}
}
