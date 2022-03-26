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
import com.portfolio.repository.ClassifyRepository;

/* 
 * -------------------------------------------------
 * METHOD PATH                     Desp
 * -------------------------------------------------
 * GET    {"/", "/query"}          查詢全部資料
 * GET    {"/{id}", "/get/{id}"}    查詢單筆資料
 * POST   {"/", "/add"}            新增資料
 * PUT    {"/{id}", "/update/{id}"} 修改資料(根據ID)
 * DELETE {"/{id}", "/delete/{id}"} 刪除資料(根據ID)
 * -------------------------------------------------
*/
@RestController
@RequestMapping("/classify")
public class ClassifyController {
	@Autowired
	private ClassifyRepository classifyRepository;
	
	@GetMapping(value = {"/", "/query"}) 
	public List<Classify> query() {
		return classifyRepository.findAll();
	}
	
	@GetMapping(value ={"/{id}", "/get/{id}"}) 
	public Classify get(@PathVariable("id") Integer id) {
		Optional<Classify> optClassify = classifyRepository.findById(id);
		return optClassify.isPresent() ? optClassify.get() : null;
	}
	
	@PostMapping(value = {"/", "/add"})
	@Transactional
	public Classify add(@RequestBody Map<String, String> map) {
		Classify classify = new Classify();
		classify.setName(map.get("name"));
		if(map.get("tx") == null) {
			classify.setTx(false);
		} else {
			classify.setTx(true);
		}
		classify = classifyRepository.save(classify);
		return classify;
	}
	
	@PutMapping(value = {"/{id}", "/update/{id}"})
	@Transactional
	public Classify update(@PathVariable("id") Integer id, @RequestBody Map<String, String> map) {
		Classify classify = get(id);
		if (classify == null) {
			return null;
		}
		classify.setName(map.get("name"));
		if(map.get("tx") == null) {
			classify.setTx(false);
		} else {
			classify.setTx(true);
		}
		classify = classifyRepository.saveAndFlush(classify);
		return classify;
	}
	
	@DeleteMapping(value = {"/{id}", "/delete/{id}"})
	public Boolean delete(@PathVariable("id") Integer id) {
		Classify classify = get(id);
		if (classify == null) {
			return false;
		}
		classifyRepository.deleteById(id);
		return true;
	}
	
	
}
