package by.epam_training.java_online.module5.task2_payment.view;

import by.epam_training.java_online.module5.task2_payment.entity.Payment;
import by.epam_training.java_online.module5.task2_payment.entity.Payment.Item;
import by.epam_training.java_online.module5.task2_payment.logic.PaymentLogic;

public class PaymentView {

	private final static PaymentView instance = new PaymentView();

	private PaymentView() {
	}

	public static PaymentView getInstance() {
		return instance;
	}

	public void displayPayment(Payment p) {
		
		System.out.println("-------------------");
		System.out.format("%-12s|  %-6s\n", "Items", "Sum");
		System.out.println("-------------------");

		for (Item i : p.getPurchaseList()) {
			System.out.format("%-12s|  %.2f\n", i.getTitle(), i.getPrice());
		}

		System.out.println("-------------------");
		System.out.format("%-12s|  %.2f\n", "Total sum", PaymentLogic.getInstance().getTotalSum(p));
		System.out.println("-------------------\n");
	}
}
