package com.enviro.assessment.junior.mbuyelonyathi.service;

import com.enviro.assessment.junior.mbuyelonyathi.entity.Investor;
import com.enviro.assessment.junior.mbuyelonyathi.exception.BusinessException;
import com.enviro.assessment.junior.mbuyelonyathi.repository.InvestorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvestorService {

    private final InvestorRepository investorRepository;

    public InvestorService(InvestorRepository investorRepository) {
        this.investorRepository = investorRepository;
    }

    public List<Investor> getAllInvestors() {
        return investorRepository.findAll();
    }

    public Investor getInvestorById(Long id) {
        return investorRepository.findById(id)
                .orElseThrow(() ->
                        new BusinessException("Investor not found with id: " + id));
    }
}