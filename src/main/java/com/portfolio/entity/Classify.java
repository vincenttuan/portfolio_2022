package com.portfolio.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// 商品分類表
@Entity
@Table
public class Classify {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String name; // 分類名稱
	
	@Column
	private Boolean tx; // 該商品是否可交易(transaction)
	
	public Classify() {
		 
	}
	
	public Classify(String name, Boolean tx) {
		super();
		this.name = name;
		this.tx = tx;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getTx() {
		return tx;
	}

	public void setTx(Boolean tx) {
		this.tx = tx;
	}
	
}
