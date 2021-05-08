package leite.aquilla.hrpayroll.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import leite.aquilla.hrpayroll.entity.Payment;
import leite.aquilla.hrpayroll.entity.Worker;
import leite.aquilla.hrpayroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {

	WorkerFeignClient workerFeignClient;

	@Autowired
	public PaymentService(WorkerFeignClient workerFeignClient) {
		super();
		this.workerFeignClient = workerFeignClient;
	}

	public Payment getPayment(long workerId, int days) {
		Worker worker = workerFeignClient.show(workerId).getBody();
		return Payment.builder().name(worker.getName()).dailyIncome(worker.getDailyIncome()).days(days).build();
	}
}
