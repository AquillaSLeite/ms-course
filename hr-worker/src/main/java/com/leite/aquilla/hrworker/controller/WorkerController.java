package com.leite.aquilla.hrworker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leite.aquilla.hrworker.entity.Worker;
import com.leite.aquilla.hrworker.service.WorkerService;

@RestController
@RequestMapping("/workers")
public class WorkerController {

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
		return ResponseEntity.ok().body(workerService.findById(id));
	}

}
