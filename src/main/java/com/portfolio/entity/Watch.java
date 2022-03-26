package com.portfolio.entity;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table
public class Watch {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String name;
	
	@ManyToOne()
	@JoinColumn(name = "investor_id", referencedColumnName = "id")
	@JsonIgnoreProperties("watchs")
	private Investor investor;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "watch_tstock", 
		joinColumns = {
				@JoinColumn(name="watch_id", nullable = false, updatable = false)
		},
		inverseJoinColumns = {
				@JoinColumn(name="tStock_id", nullable = false, updatable = false)
		}
	)
	private Set<TStock> tStocks = new CopyOnWriteArraySet<TStock>();
	
	public Watch() {
		
	}

	public Watch(String name, Investor investor) {
		this.name = name;
		this.investor = investor;
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

	public Investor getInvestor() {
		return investor;
	}

	public void setInvestor(Investor investor) {
		this.investor = investor;
	}

	public Set<TStock> gettStocks() {
		return tStocks;
	}

	public void settStocks(Set<TStock> tStocks) {
		this.tStocks = tStocks;
	}
	
	public Set<TStock> addtStock(TStock tStock) {
        tStocks.add(tStock);
        return tStocks;
    }
    
    public Set<TStock> removetStock(TStock tStock) {
        tStocks.remove(tStock);
        return tStocks;
    }
	
	
}
