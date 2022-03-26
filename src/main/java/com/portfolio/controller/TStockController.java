package com.portfolio.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.entity.Classify;
import com.portfolio.entity.TStock;
import com.portfolio.repository.ClassifyRepository;
import com.portfolio.repository.TStockRepository;

@RestController
@RequestMapping("/tstock")
public class TStockController {
	
	@Autowired
	private TStockRepository tStockRepository;
	
	@Autowired
	private ClassifyRepository classifyRepository;
	
	@GetMapping(value = {"/", "/query"})
	public List<TStock> query() {
		return tStockRepository.findAll();
	}
	
	@GetMapping(value = {"/{id}", "/get/{id}"})
	public TStock get(@PathVariable("id") Integer id) {
		Optional<TStock> optTStock = tStockRepository.findById(id);
		return optTStock.isPresent()  ?  optTStock.get() : null;
	}
	
	@PostMapping(value = {"/", "/add"})
	@Transactional
	public TStock add(@RequestBody Map<String, String> map) {
		Optional<Classify> optClassify = classifyRepository.findById(Integer.parseInt(map.get("classify_id")));
		if(!optClassify.isPresent()) {
			return null;
		}
		TStock ts = new TStock();
		ts.setName(map.get("name"));
		ts.setSymbol(map.get("symbol"));
		ts.setClassify(optClassify.get());
		ts = tStockRepository.save(ts);
		return ts;
	}
	
	@PutMapping(value = {"/{id}", "/update/{id}"})
	@Transactional
	public TStock update(@PathVariable("id") Integer id, @RequestBody Map<String, String> map) {
		Optional<Classify> optClassify = classifyRepository.findById(Integer.parseInt(map.get("classify_id")));
		if(!optClassify.isPresent()) {
			return null;
		}
		TStock tStock = get(id);
		if(tStock == null) {
			return null;
		}
		tStock.setName(map.get("name"));
		tStock.setSymbol(map.get("symbol"));
		tStock.setClassify(optClassify.get());
		//tStockRepository.saveAndFlush(tStock); // 可以不用下達
		return tStock;
	}
	
	@DeleteMapping(value = {"/{id}", "/delete/{id}"})
	@Transactional
	public Boolean delete(@PathVariable("id") Integer id) {
		Optional<TStock> optTStock = tStockRepository.findById(id);
		if(!optTStock.isPresent()) {
			return false;
		}
		tStockRepository.deleteById(id);
		return true;
	}
}












