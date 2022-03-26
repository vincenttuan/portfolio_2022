package com.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.entity.Classify;

@Repository(value = "classifyRepository")
public interface ClassifyRepository extends JpaRepository<Classify, Integer> {
	
}
