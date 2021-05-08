package leite.aquilla.hrpayroll.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import leite.aquilla.hrpayroll.entity.Payment;
import leite.aquilla.hrpayroll.entity.Worker;

@Service
public class PaymentService {

	@Value("${hr-worker.host}")
	private String workerHost;

	RestTemplate restTemplate;

	@Autowired
	public PaymentService(RestTemplate restTemplate) {
		super();
		this.restTemplate = restTemplate;
	}

	public Payment getPayment(long workerId, int days) {
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("id", String.valueOf(workerId));

		Worker worker = restTemplate.getForObject(workerHost + "/{id}", Worker.class, uriVariables);

		return Payment.builder().name(worker.getName()).dailyIncome(worker.getDailyIncome()).days(days).build();
	}
}
