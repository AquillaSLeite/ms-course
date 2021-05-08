package leite.aquilla.hrpayroll.service;

import org.springframework.stereotype.Service;

import leite.aquilla.hrpayroll.entity.Payment;

@Service
public class PaymentService {

	public Payment getPayment(long workerId, int days) {
		return Payment.builder().name("Bob").dailyIncome(200.0).days(days).build();
	}
}
