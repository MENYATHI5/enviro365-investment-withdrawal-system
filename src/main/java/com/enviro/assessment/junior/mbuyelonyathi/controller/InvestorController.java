package com.enviro.assessment.junior.mbuyelonyathi.controller;

import com.enviro.assessment.junior.mbuyelonyathi.entity.Investor;
import com.enviro.assessment.junior.mbuyelonyathi.service.InvestorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/investors")
public class InvestorController {

    private final InvestorService investorService;

    public InvestorController(InvestorService investorService) {
        this.investorService = investorService;
    }

    @GetMapping
    public List<Investor> getAllInvestors() {
        return investorService.getAllInvestors();
    }

    @GetMapping("/{id}")
    public Investor getInvestorById(@PathVariable Long id) {
        return investorService.getInvestorById(id);
    }
}