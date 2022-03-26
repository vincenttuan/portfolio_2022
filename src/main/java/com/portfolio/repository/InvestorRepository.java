package com.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.entity.Investor;

@Repository
public interface InvestorRepository extends JpaRepository<Investor, Integer> {
	
}
