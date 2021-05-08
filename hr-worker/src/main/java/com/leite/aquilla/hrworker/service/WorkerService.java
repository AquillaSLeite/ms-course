package com.leite.aquilla.hrworker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leite.aquilla.hrworker.entity.Worker;
import com.leite.aquilla.hrworker.repository.WorkerRepository;

@Service
public class WorkerService {

	WorkerRepository workerRepository;

	@Autowired
	public WorkerService(WorkerRepository workerRepository) {
		super();
		this.workerRepository = workerRepository;
	}

	public List<Worker> findAll() {
		return workerRepository.findAll();
	}

	public Worker findById(Long id) {
		return workerRepository.findById(id).get();
	}
}
