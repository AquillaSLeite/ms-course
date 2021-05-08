package com.leite.aquilla.hrworker.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leite.aquilla.hrworker.entity.Worker;
import com.leite.aquilla.hrworker.service.WorkerService;

@RestController
@RequestMapping("/api/v1/workers")
public class WorkerController {

	private static Logger logger = LoggerFactory.getLogger(WorkerController.class);

	WorkerService workerService;
	Environment environment;

	@Autowired
	public WorkerController(WorkerService workerService, Environment environment) {
		super();
		this.workerService = workerService;
		this.environment = environment;
	}

	@GetMapping
	public ResponseEntity<List<Worker>> index() {
		return ResponseEntity.ok().body(workerService.findAll());
	}

	@GetMapping("{id}")
	public ResponseEntity<Worker> show(@PathVariable Long id) {
		logger.info("PORT = " + environment.getProperty("local.server.port"));

		return ResponseEntity.ok().body(workerService.findById(id));
	}

}
