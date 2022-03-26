package com.portfolio.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.entity.Asset;
import com.portfolio.repository.AssetRepository;
import com.portfolio.repository.ProfitRepository;

@RestController
@RequestMapping("/chart")
public class ChartController {
    @Autowired
    private AssetRepository assetRepository;
    
    @Autowired
    private ProfitRepository profitRepository;
    
    @GetMapping(value = {"/asset/{invid}"})
    public List<Asset> asset(@PathVariable("invid") Integer invid) {
        return assetRepository.findByInvid(invid);
    }
    
    @GetMapping(value = {"/profit/{invid}"})
    public List<?> profit(@PathVariable("invid") Integer invid) {
        return profitRepository.findByInvId(invid);
    }
}
