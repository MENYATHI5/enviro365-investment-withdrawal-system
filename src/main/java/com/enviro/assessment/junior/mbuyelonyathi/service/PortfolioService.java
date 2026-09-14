package com.enviro.assessment.junior.mbuyelonyathi.service;

import com.enviro.assessment.junior.mbuyelonyathi.repository.PortfolioRepository;
import org.springframework.stereotype.Service;

@Service
public class PortfolioService {

    private final PortfolioRepository portfolioRepository;

    public PortfolioService(PortfolioRepository portfolioRepository) {
        this.portfolioRepository = portfolioRepository;
    }
}