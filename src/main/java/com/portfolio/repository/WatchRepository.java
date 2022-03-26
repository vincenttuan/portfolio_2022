package com.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.entity.Watch;

@Repository
public interface WatchRepository extends JpaRepository<Watch, Integer> {
	
}
