package com.portfolio.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table
public class Investor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String username;
	
	@Column
	private String email;
	
	@Column
	private Integer balance; // 目前帳戶餘額
	
	@OneToMany(cascade = {CascadeType.REMOVE}, mappedBy = "investor")
	@JsonIgnoreProperties("investor")
	private Set<Watch> watchs;
	
	public Investor() {
		
	}

	public Investor(String username, String email, Integer balance) {
		this.username = username;
		this.email = email;
		this.balance = balance;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public Set<Watch> getWatchs() {
		return watchs;
	}

	public void setWatchs(Set<Watch> watchs) {
		this.watchs = watchs;
	}
	
	
	
}
