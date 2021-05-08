package leite.aquilla.hrpayroll.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import leite.aquilla.hrpayroll.entity.Worker;

@Component
@FeignClient(name = "hr-worker", path = "/api/v1/workers")
public interface WorkerFeignClient {

	@GetMapping("{id}")
	ResponseEntity<Worker> show(@PathVariable Long id);
}
