package com.leite.aquilla.hrworker.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leite.aquilla.hrworker.entity.Worker;
import com.leite.aquilla.hrworker.service.WorkerService;

@RefreshScope
@RestController
@RequestMapping("/workers")
public class WorkerController {

	private static Logger logger = LoggerFactory.getLogger(WorkerController.class);

	@Value("${test.config}")
	private String testConfig;

	WorkerService workerService;

	@Autowired
	public WorkerController(WorkerService workerService) {
		super();
		this.workerService = workerService;
	}

	@GetMapping
	public ResponseEntity<List<Worker>> index() {
		return ResponseEntity.ok().body(workerService.findAll());
	}

	@GetMapping("{id}")
	public ResponseEntity<Worker> show(@PathVariable Long id) {
		logger.info("CONFIG = " + this.testConfig);
		return ResponseEntity.ok().body(workerService.findById(id));
	}

}
