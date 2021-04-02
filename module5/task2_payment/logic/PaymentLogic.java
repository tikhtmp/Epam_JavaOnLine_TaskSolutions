package by.epam_training.java_online.module5.task2_payment.logic;

import by.epam_training.java_online.module5.task2_payment.entity.Payment;
import by.epam_training.java_online.module5.task2_payment.entity.Payment.Item;

public class PaymentLogic {
	private final static PaymentLogic instance = new PaymentLogic();
	
	private PaymentLogic(){}
	
	public static PaymentLogic getInstance() {
			return instance;
	}
	
	public double getTotalSum (Payment p) {
		double sum = 0.0;
		
		for (Item item : p.getPurchaseList()) {
			sum = sum + item.getPrice();
		}
		
		return sum;
	}
}
