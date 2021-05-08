package com.leite.aquilla.hrworker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leite.aquilla.hrworker.entity.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
